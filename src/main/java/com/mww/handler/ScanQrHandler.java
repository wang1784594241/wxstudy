package com.mww.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import java.io.IOException;
import java.util.Map;

/**
 * Created by alex on 15/12/5.
 */
public class ScanQrHandler implements WxMpMessageHandler {

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) throws WxErrorException {

		// 绑定处理
		try {
			ScanQrOperation.bindingOpenId(wxMessage, wxMpService);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
