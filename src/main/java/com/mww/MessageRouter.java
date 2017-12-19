package com.mww;

import com.mww.handler.*;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Administrator on 2017/11/1.
 */
public class MessageRouter implements InitializingBean {

    private final static UnSubscribeHandler unSubscribeHanler = new UnSubscribeHandler();
    private final static SubscribeHandler subscribeHanler = new SubscribeHandler();
    private final static MenuHandler menuHandler = new MenuHandler();
    private final static TextAutoReplyHandler autoReplyHandler = new TextAutoReplyHandler();
    private final static DefaultHandler defaultHandler = new DefaultHandler();
    private final static ScanQrHandler scanQrHandler = new ScanQrHandler();
    private final static LocationHandler LocationHandler = new LocationHandler();
    private final static VoiceHandler voiceHandler = new VoiceHandler();
    private final static AlternatelyHandler alternatelyHandler = new AlternatelyHandler();

    @Autowired
    private WxMpService wxMpService;

    WxMpMessageRouter wxMpMessageRouter;

    @Override
    public void afterPropertiesSet() throws Exception {
        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
//            1、用户发送信息 XML_MSG_TEXT,XML_MSG_IMAGE,XML_MSG_VOICE,XML_MSG_SHORTVIDEO,XML_MSG_VIDEO,XML_MSG_NEWS,XML_MSG_MUSIC,XML_MSG_LOCATION,XML_MSG_LINK
//            2、点击自定义菜单（仅有点击推事件 BUTTON_CLICK、扫码推事件 BUTTON_SCANCODE_PUSH、扫码推事件且弹出“消息接收中”提示框 BUTTON_SCANCODE_WAITMSG这3种菜单类型是会触发客服接口的）
//            3、关注公众号 EVT_SUBSCRIBE
//            4、扫描二维码
//            5、支付成功
//            6、用户维权
        wxMpMessageRouter
            .rule().msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SUBSCRIBE).handler(subscribeHanler,
                alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.UNSUBSCRIBE).handler
                (unSubscribeHanler).end()
            .rule().msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.SCAN).handler(scanQrHandler,
                alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.CLICK).handler(menuHandler,
                alternatelyHandler, autoReplyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.EVENT).event(WxConsts.EventType.LOCATION).handler(LocationHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.VOICE).handler(voiceHandler, alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.IMAGE).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.SHORTVIDEO).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.VIDEO).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.NEWS).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.LOCATION).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.XmlMsgType.LINK).handler(alternatelyHandler).end()
            .rule().msgType(WxConsts.KefuMsgType.TEXT).handler(autoReplyHandler, defaultHandler, alternatelyHandler).end();
    }

    public WxMpXmlOutMessage route(WxMpXmlMessage wxMessage) {
        return wxMpMessageRouter.route(wxMessage);
    }
}
