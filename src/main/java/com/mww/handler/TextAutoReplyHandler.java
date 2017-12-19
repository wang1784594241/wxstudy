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
public class TextAutoReplyHandler implements WxMpMessageHandler {

//    private AutoReplyService autoReplyService = SpringUtils.getBean(AutoReplyService.class);
//    private BwWechatUserService bwWechatUserService = SpringUtils.getBean(BwWechatUserService.class);
//    private BwWechatMsgService bwWechatMsgService = SpringUtils.getBean(BwWechatMsgService.class);

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

//        // 判断是否已经被处理
//        if (context.get("handle") == null) {
//            BwUser bwUser = bwUserService.findByWeixin(wxMessage.getFromUser());
//            User weixinUser = UserAPI.userInfo(wxMpService.getAccessToken(), wxMessage.getFromUser());
//            if (bwUser != null) {
//                bwUser.setNickName(weixinUser.getNickname());
//                bwUserService.save(bwUser);
//            } else {
//                BwUser newBwUser = new BwUser();
//                newBwUser.setNickName(weixinUser.getNickname());
//                newBwUser.setPhoto(weixinUser.getHeadimgurl());
//                newBwUser.setWeixin(wxMessage.getFromUser());
//                bwUserService.save(newBwUser);
//            }
//
//            // 自动回复规则
//            List<AutoReply> autoReplies = autoReplyService.findByIsUseOrderByWeightDesc();
//            for (AutoReply item : autoReplies) {
//                // 自动回复关键词
//                String[] keywords = item.getKeyWord().split(",");
//                for (String keyword : keywords) {
//                    // 通过匹配模式得到匹配表达式
//                    Pattern p = AutoReplyOperation.getPattern(item.getMatchMode(), keyword);
//                    Matcher m = p.matcher(wxMessage.getContent());
//                    if (m.find()) {
//                        // 匹配后根据发送规则取消息
//                        List<AutoReplyContent> autoReplyContents = AutoReplyOperation.getReply(item);
//                        // 发送消息
//                        AutoReplyOperation.sendMessage(autoReplyContents, wxMpService, wxMessage.getFromUser());
//                        //消息发送数量+1
//                        autoReplyService.updateReplyNum(item.getId());
//                        // 标记消息已经处理
//                        context.put("handle", true);
//                        //标记消息已自动回复
//                        context.put("autoReply", true);
//                        break;
//                    }
//                }
//            }
//        }
        return null;
    }
}
