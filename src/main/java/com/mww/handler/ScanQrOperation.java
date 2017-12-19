package com.mww.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class ScanQrOperation {


    public static void bindingOpenId(WxMpXmlMessage wxMessage, WxMpService wxMpService) throws WxErrorException
        , IOException {

        // 扫描二维码事件处理
        String openId = wxMessage.getFromUser();
        if (StringUtils.isBlank(wxMessage.getEventKey())) {
            return;
        }
        String sceneId = wxMessage.getEventKey().replace("qrscene_", "");
        int length = sceneId.length();
        int operate = Integer.parseInt(sceneId.substring(length - 2, length));
        String fieldStr = sceneId.substring(0, length - 2);
        Long field = null;
        if (StringUtils.isNumeric(fieldStr)) {
            field = Long.parseLong(fieldStr);
        }
        //绑定微信
//        if (WxScanOperateEnum.wechat_binding.ordinal() == operate) {
//
//        }
//        //扫码登录
//        else if (WxScanOperateEnum.wechat_scan_login.ordinal() == operate) {
//            WxMpKefuMessage kefu = WxMpKefuMessage.TEXT().content(msg).toUser(openId).build();
//            wxMpService.getKefuService().sendKefuMessage(kefu);
//        }
        WxMpKefuMessage kefu = WxMpKefuMessage.TEXT().content("登录成功").toUser(wxMessage.getFromUser()).build();
        wxMpService.getKefuService().sendKefuMessage(kefu);
    }
}

