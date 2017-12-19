package com.mww.enums;

/**
 *
 * Created by Administrator on 2017/12/4.
 *
 * JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，MICROPAY--刷卡支付，统一下单接口trade_type的传参可参考这里
 * https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=4_2
 * 刷卡支付有单独的支付接口，不调用统一下单接口
 */

public enum WxTradeTypeEnum {

    JSAPI("公众号支付"),
    NATIVE("扫码支付"),
    APP("app支付"),
    MICROPAY("刷卡支付");

    private String info;

    WxTradeTypeEnum(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
