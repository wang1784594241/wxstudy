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
public class LocationHandler implements WxMpMessageHandler {

//    private BwUserLocationService bwUserLocationService = SpringUtils.getBean(BwUserLocationService.class);
//    private BwUserService bwUserService = SpringUtils.getBean(BwUserService.class);


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
       /* BwUserLocation bwUserLocation = new BwUserLocation();
        bwUserLocation.setOpenId(wxMessage.getFromUser());
        bwUserLocation.setLatitude(wxMessage.getLatitude().toString());
        bwUserLocation.setLongitude(wxMessage.getLongitude().toString());
        BwUser bwUser = bwUserService.findByWeixin(wxMessage.getFromUser());
        if(bwUser != null){
            bwUserLocation.setUserId(bwUser.getId());
        }
        bwUserLocationService.save(bwUserLocation);*/
        return null;
    }
}
