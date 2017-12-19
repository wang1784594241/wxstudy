/*
 * ***************************************************************************
 * Copyright (c) Transnal Inc.
 * @date:2016-11-5
 * @author:alex
 * @email:xalexec@gmail.com
 * ***************************************************************************
 */

package com.mww.handler;

/**
 * Created by alex on 16/9/17.
 */
public class WeChatUtils {

    private final static String NO_USER = "no_user";
    private final static String CODE_EXPIRE = "code_expire";

   /* public static String login(WxMpService wxService, LoginResult loginResult, HttpServletRequest request) {
        // 微信浏览器
        if (IsMobileUtils.isWechat(request)) {

            String code = request.getParameter("code");
            String state = request.getParameter("state");
            String backUrl = request.getParameter("backUrl");


            if (!StringUtils.isNotBlank(code)) {
//                String redirect = wxService.oauth2buildAuthorizationUrl("",WxConsts.OAUTH2_SCOPE_BASE, state);
                //return "redirect:" + redirect;
            } else {
                UrlReuslt urlReuslt = UrlReuslt.create(backUrl);
                try {
                    //code 换取token https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842&token=&lang=zh_CN 第二步：通过code换取网页授权access_token
                    WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
                    BearToken bearToken = new BearToken(wxMpOAuth2AccessToken.getOpenId());
                    System.out.println(bearToken.getOpenid());
                    String token = loginResult.login(bearToken);
                    System.out.println(token);
                    if (StringUtils.isNotBlank(token)) {
                        urlReuslt.addHashQuery(Constants.ACCESS_TOKEN, token);
                        return urlReuslt.toUrl();
                    } else {
                        WechatUserEntity wechatUserEntity = new WechatUserEntity(wxMpOAuth2AccessToken.getOpenId());
                        if (WxConsts.OAUTH2_SCOPE_USER_INFO.equals(wxMpOAuth2AccessToken.getScope())) {
                            WxMpUser wxMpUser = wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
                            ReflectUtils.mergeEneity(wechatUserEntity, wxMpUser);
                        }
                        String o = AesUtil.encrypt(JSON.toJSONString(wechatUserEntity));
                        urlReuslt.addQuery("err", NO_USER);
                        urlReuslt.addQuery("o", o);
                        return urlReuslt.toUrl();
                    }
                } catch (WxErrorException e) {
                    e.printStackTrace();
                    urlReuslt.addQuery("err", CODE_EXPIRE);
                    return urlReuslt.toUrl();
                }
            }
        }
        return null;
    }*/

}
