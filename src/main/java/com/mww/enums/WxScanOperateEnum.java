package com.mww.enums;

/**
 * Created by Administrator on 2017/12/18.
 */
public enum WxScanOperateEnum {

    wechat_binding("绑定微信"),
    wechat_scan_login("微信扫码登录");

    WxScanOperateEnum(String info) {
        this.info = info;
    }

    private String info;

    public String getInfo() {
        return this.info;
    }
}
