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
public class DefaultHandler implements WxMpMessageHandler {

//    private AutoReplyService autoReplyService = SpringUtils.getBean(AutoReplyService.class);

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

//        if (context.get("handle") == null) {
//            List<AutoReply> autoReplies = autoReplyService.findByIsUseAndIsDefaultOrderByWeightDesc();
//            for (AutoReply item : autoReplies) {
//                List<AutoReplyContent> autoReplyContents = AutoReplyOperation.getReply(item);
//                AutoReplyOperation.sendMessage(autoReplyContents, wxMpService, wxMessage.getFromUser());
//                context.put("handle", true);
//            }
//        }
        return null;
    }
}
