package com.mww.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import java.util.Map;

/**
 * Created by alex on 15/12/10.
 */
public class MenuHandler implements WxMpMessageHandler {

    private static String backgroudMediaId = "ICzPXd8iThjXnsmISoBf2bdGixLgW0sJ3d_fQEFBzvM";
    private static String signupVoiceMediaId = "piLcu9yg_Q-lSgitiqa2xX7U3muLhJe1R2StODQ6LrY";
    private final String imgPrefix = "https://img.xbbwsm.com/";
    private final String domainPrefix = "https://m.xbbwsm.com/frontend/?#/";

//    private AutoReplyService autoReplyService = SpringUtils.getBean(AutoReplyService.class);


    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {

       /*
        if ("recommend".equals(wxMessage.getEventKey())) {
            Integer sceneIdnew = 0;
            BwUser bwUser = bwUserService.findByWeixin(wxMessage.getFromUser());
            BwUser newBwUser = new BwUser();
            if (bwUser != null) {
                sceneIdnew = Integer.parseInt(bwUser.getId().toString() + "01");
            } else {
                newBwUser.setWeixin(wxMessage.getFromUser());
                bwUserService.save(newBwUser);
                sceneIdnew = Integer.parseInt(newBwUser.getId().toString() + "01");
            }
            WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(sceneIdnew, 2592000);
            String QrCode = wxMpService.getQrcodeService().qrCodePictureUrl(ticket.getTicket());
            InputStream is = null;
            try {
                is = ImagesUtils.imagesSynthesis(wxMpService.getMaterialService().materialImageOrVoiceDownload(backgroudMediaId), wxMpService.getUserService().userInfo(wxMessage.getFromUser()).getHeadImgUrl(), QrCode);
            } catch (WriterException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            WxMediaUploadResult wxMediaUploadResult = wxMpService.getMaterialService().mediaUpload(WxConsts.MEDIA_IMAGE, WxConsts.FILE_JPG, is);
            WxMpKefuMessage kefu2 = WxMpKefuMessage.IMAGE().mediaId(wxMediaUploadResult.getMediaId()).toUser(wxMessage.getFromUser()).build();
            wxMpService.getKefuService().sendKefuMessage(kefu2);
        }*/

        return null;
    }


}
