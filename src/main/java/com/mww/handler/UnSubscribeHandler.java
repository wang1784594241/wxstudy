package com.mww.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

/**
 * Created by alex on 15/12/5.
 */
public class UnSubscribeHandler implements WxMpMessageHandler {

//    private BwUserService bwUserService = SpringUtils.getBean(BwUserService.class);

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

//        if (WxConsts.XML_MSG_EVENT.equals(wxMessage.getMsgType()) && WxConsts.EVT_UNSUBSCRIBE.equals(wxMessage.getEvent())) {
//            BwUser bwUser = bwUserService.findByWeixin(wxMessage.getFromUser());
//            bwUser.setSubscribe(false);
//            bwUser.setUnsubscribeTime(System.currentTimeMillis());
//            bwUserService.update(bwUser);
//        }
        return null;
    }
}
