/*
 * Copyright (c) 2016-9-30 alex
 */

package com.mww.controller;

import com.github.binarywang.utils.qrcode.QrcodeUtils;
import com.mww.MessageRouter;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by alex on 16/8/8.
 */
@RestController
@RequestMapping("/api/wechat")
public class WechatApiController {

    public static final String QR_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";

    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private MessageRouter messageRouter;

    @RequestMapping(value = "/open/check")
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String encrypt_type = request.getParameter("encrypt_type");
        String msg_signature = request.getParameter("msg_signature");

        String result = null;

        if (StringUtils.isNotBlank(signature) && StringUtils.isNotBlank(timestamp) && StringUtils.isNotBlank(nonce)
                && StringUtils.isNotBlank(echostr)) {
            // return echostr;
            result = echostr;
        } else {

            WxMpXmlMessage inMessage = null;

            if (("aes".equals(encrypt_type))) {
                // 是aes加密的消息
                String msgSignature = msg_signature;
                inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxMpService.getWxMpConfigStorage(), timestamp, nonce,
                        msgSignature);
            } else if (StringUtils.isBlank(encrypt_type) || "raw".equals(encrypt_type)) {
                // 明文传输的消息
                inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            }
            messageRouter.route(inMessage);


            result = "success";
        }
        //不允许同步回复消息，全部为异步
        //微信官方推荐回复 success，
        //此处必须使用 response 直接回复，使用 return 的话微信会报返回不合法
        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();
    }


    /**
     * 注入权限验证配置
     *
     * @param debug
     * @param url
     * @param api
     * @return
     */
    @RequestMapping(value = "/js_api")
    public String js_api(String debug, String url, String api) {
        if (StringUtils.isBlank(url)) {
            return null;
        }

        String config = "" + "wx.config({" + "debug: %s," + // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                "appId: '%s'," + // 必填，公众号的唯一标识
                "timestamp: %s," + // 必填，生成签名的时间戳
                "nonceStr: '%s'," + // 必填，生成签名的随机串
                "signature: '%s'," + // 必填，签名，见附录1
                "jsApiList: [%s]" + // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                "});";
        try {
            StringBuffer apiString = new StringBuffer();
            String[] apis = api.split(",");
            for (int i = 0; i < apis.length; i++) {
                apiString.append("'");
                apiString.append(apis[i]);
                apiString.append("'");
                if (i != apis.length - 1) {
                    apiString.append(",");
                }
            }
            url = url.split("#")[0];
            WxJsapiSignature signature = wxMpService.createJsapiSignature(url);
            config = String.format(config, StringUtils.isNotBlank(debug) ? true : false, wxMpService.getWxMpConfigStorage().getAppId(),
                    signature.getTimestamp(), signature.getNonceStr(), signature.getSignature(), apiString.toString());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return config;
    }

    /**
     * 注入权限验证配置
     *
     * @param url
     * @return
     */
    @RequestMapping(value = "/jsApi")
    public HashMap jsApi(String url) {
        if (StringUtils.isBlank(url)) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            url = url.split("#")[0];
            WxJsapiSignature signature = wxMpService.createJsapiSignature(url);
            map.put("appId", signature.getAppId());
            map.put("timestamp", signature.getTimestamp());
            map.put("nonceStr", signature.getNonceStr());
            map.put("signature", signature.getSignature());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取二维码ticket
     * http://mp.weixin.qq.com/wiki/18/167e7d94df85d8389df6c94a7a8f78ba.html
     *
     * @param sceneId
     * @param expireSeconds 不填写 默认30秒
     * @return
     * @throws WxErrorException
     */
    @RequestMapping(value = "/qrCodeTicket", method = RequestMethod.GET)
    public String ticket(Integer sceneId, String type, Integer expireSeconds, HttpServletResponse response) throws
            Exception {
        WxMpQrCodeTicket ticket = null;
        if (StringUtils.isNotBlank(type)) {
            ticket = wxMpService.getQrcodeService().qrCodeCreateLastTicket(sceneId);
        } else {
            ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(sceneId, expireSeconds);
        }
        if (ticket == null) {
            return null;
        }
        return QR_URL + ticket.getTicket();
    }

    /**
     * 生成二维码
     * http://mp.weixin.qq.com/wiki/18/167e7d94df85d8389df6c94a7a8f78ba.html
     *
     * @param sceneId
     * @param expireSeconds 不填写 默认30秒
     * @return
     * @throws WxErrorException
     */
    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public void qrcode(Integer sceneId, Integer expireSeconds, HttpServletResponse response) throws
            Exception {
        WxMpQrCodeTicket ticket = null;
        ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(sceneId, expireSeconds);
        byte[] qrcode = QrcodeUtils.createQrcode(ticket.getUrl(), 258, null);
        IOUtils.write(qrcode, response.getOutputStream());
    }
}
