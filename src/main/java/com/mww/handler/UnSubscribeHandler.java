package com.mww.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.Map;

/**
 * Created by alex on 15/12/5.
 */
public class UnSubscribeHandler implements WxMpMessageHandler {

//    private BwUserService bwUserService = SpringUtils.getBean(BwUserService.class);

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

        if (WxConsts.XmlMsgType.EVENT.equals(wxMessage.getMsgType()) && WxConsts.EventType.UNSUBSCRIBE.equals(wxMessage.getEvent
                ())) {
            System.out.println(wxMessage.getFromUser()+" 取消了关注");
            WxMpUser wxMpUser = wxMpService.getUserService().userInfo(wxMessage.getFromUser());
            System.out.println(wxMpUser.toString());
        }

        return null;
    }
}
