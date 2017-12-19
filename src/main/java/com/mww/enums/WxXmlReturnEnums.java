package com.mww.enums;

/**
 * 微信回调返回结果
 * Created by Administrator on 2017/12/7.
 */
public enum WxXmlReturnEnums {

    success("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[ok]]></return_msg></xml>"),

    result_code_is_FAIL("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg>" +
        "<![CDATA[result_code is FAIL]]></return_msg></xml>"),

    check_signature_FAIL("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[check signature " +
        "FAIL]]></return_msg></xml>");

    private String info;

    WxXmlReturnEnums(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}
