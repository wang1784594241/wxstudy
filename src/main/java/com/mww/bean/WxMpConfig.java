///*
// * ***************************************************************************
// * Copyright (c) Transnal Inc.
// * @date:2016-11-3
// * @author:alex
// * @email:xalexec@gmail.com
// * ***************************************************************************
// */
//
//package com.mww.bean;
//
//import com.mww.entity.WxConfig;
//import me.chanjar.weixin.common.bean.WxAccessToken;
//import me.chanjar.weixin.common.util.http.ApacheHttpClientBuilder;
//import me.chanjar.weixin.mp.api.WxMpConfigStorage;
//import org.springframework.cache.Cache;
//
//import javax.net.ssl.SSLContext;
//import java.io.File;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class WxMpConfig implements WxMpConfigStorage {
//
//    private final int RESERVE_TIME = 200;
//
//    private WxConfigService wxConfigService;
//    private Cache wxconfigCaptcha;
//
//    private long configId;
//    protected volatile String appId;
//    protected volatile String secret;
//    protected volatile String token;
//    protected volatile String aesKey;
//    protected volatile String partnerId;
//    protected volatile String partnerKey;
//    protected volatile String accessToken;
//    protected volatile long expiresTime;
//    protected volatile String jsapiTicket;
//    protected volatile long jsapiTicketExpiresTime;
//    protected volatile String cardApiTicket;
//    protected volatile long cardApiTicketExpiresTime;
//    protected volatile String oauth2redirectUri;
//    protected volatile String httpProxyHost;
//    protected volatile int httpProxyPort;
//    protected volatile String httpProxyUsername;
//    protected volatile String httpProxyPassword;
//    protected volatile File tmpDirFile;
//    protected volatile SSLContext sslContext;
//    protected volatile ApacheHttpClientBuilder apacheHttpClientBuilder;
//    protected Lock accessTokenLock = new ReentrantLock();
//    protected Lock jsapiTicketLock = new ReentrantLock();
//    protected Lock cardApiTicketLock = new ReentrantLock();
//
//    private WxConfig getConfig() {
//        Cache.ValueWrapper valueWrapper = wxconfigCaptcha.get(configId);
//        if (valueWrapper == null) {
//            WxConfig wxConfig = wxConfigService.findOne(configId);
//            wxconfigCaptcha.put(configId, wxConfig);
//            return wxConfig;
//        }
//
//        return (WxConfig) valueWrapper.get();
//    }
//
//    private void save(WxConfig wxConfig) {
//        wxConfigService.save(wxConfig);
//        wxconfigCaptcha.evict(configId);
//    }
//
//    public WxMpConfig(Long configId) {
//        this.configId = configId;
//        this.wxConfigService = ApplicationContextHolder.getBean(WxConfigService.class);
//        this.wxconfigCaptcha = CacheAccessor.getWxConfigCache();
//        WxConfig wxConfig = getConfig();
//
//        this.appId = wxConfig.getAppId();
//        this.secret = wxConfig.getSecret();
//        this.token = wxConfig.getToken();
//        this.aesKey = wxConfig.getAesKey();
//        this.partnerId = wxConfig.getPartnerId();
//        this.partnerKey = wxConfig.getPartnerKey();
//        this.accessToken = wxConfig.getAccessToken();
//        this.expiresTime = wxConfig.getExpiresTime();
//        this.jsapiTicket = wxConfig.getJsapiTicket();
//        this.jsapiTicketExpiresTime = wxConfig.getJsapiTicketExpiresTime();
//        this.cardApiTicket = wxConfig.getCardApiTicket();
//        this.cardApiTicketExpiresTime = wxConfig.getCardApiTicketExpiresTime();
//    }
//
//    public long getConfigId() {
//        return configId;
//    }
//
//    public void setConfigId(long configId) {
//        this.configId = configId;
//    }
//
//    @Override
//    public String getAppId() {
//        return appId;
//    }
//
//    @Override
//    public String getSecret() {
//        return secret;
//    }
//
//    @Override
//    public String getPartnerId() {
//        return partnerId;
//    }
//
//    @Override
//    public String getPartnerKey() {
//        return partnerKey;
//    }
//
//    @Override
//    public String getToken() {
//        return token;
//    }
//
//    @Override
//    public String getAesKey() {
//        return aesKey;
//    }
//
//    @Override
//    public String getAccessToken() {
//        return getConfig().getAccessToken();
//    }
//
//    @Override
//    public long getExpiresTime() {
//        return getConfig().getExpiresTime();
//    }
//
//    public boolean isAccessTokenExpired() {
//        return System.currentTimeMillis() > getExpiresTime();
//    }
//
//    @Override
//    public void updateAccessToken(WxAccessToken wxAccessToken) {
//        updateAccessToken(wxAccessToken.getAccessToken(), wxAccessToken.getExpiresIn());
//    }
//
//    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
//        this.accessToken = accessToken;
//        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - RESERVE_TIME) * 1000l;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setAccessToken(accessToken);
//        wxConfig.setExpiresTime(expiresTime);
//        save(wxConfig);
//    }
//
//    public void expireAccessToken() {
//        this.expiresTime = 0;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setExpiresTime(expiresTime);
//        save(wxConfig);
//    }
//
//
//    public String getJsapiTicket() {
//        return getConfig().getJsapiTicket();
//    }
//
//    public long getJsapiTicketExpiresTime() {
//        return getConfig().getJsapiTicketExpiresTime();
//    }
//
//    public boolean isJsapiTicketExpired() {
//        return System.currentTimeMillis() > getJsapiTicketExpiresTime();
//    }
//
//    public synchronized void updateJsapiTicket(String jsapiTicket, int expiresInSeconds) {
//        this.jsapiTicket = jsapiTicket;
//        this.jsapiTicketExpiresTime = System.currentTimeMillis() + (expiresInSeconds - RESERVE_TIME) * 1000l;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setJsapiTicket(jsapiTicket);
//        wxConfig.setJsapiTicketExpiresTime(jsapiTicketExpiresTime);
//        save(wxConfig);
//    }
//
//    public void expireJsapiTicket() {
//        this.jsapiTicketExpiresTime = 0;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setJsapiTicketExpiresTime(jsapiTicketExpiresTime);
//        save(wxConfig);
//    }
//
//
//    @Override
//    public String getCardApiTicket() {
//        return cardApiTicket;
//    }
//
//    public long getCardApiTicketExpiresTime() {
//        return getConfig().getCardApiTicketExpiresTime();
//    }
//
//    public boolean isCardApiTicketExpired() {
//        return System.currentTimeMillis() > getCardApiTicketExpiresTime();
//    }
//
//    public synchronized void updateCardApiTicket(String cardApiTicket, int expiresInSeconds) {
//        this.cardApiTicket = cardApiTicket;
//        this.cardApiTicketExpiresTime = System.currentTimeMillis() + (expiresInSeconds - RESERVE_TIME) * 1000l;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setCardApiTicket(cardApiTicket);
//        wxConfig.setCardApiTicketExpiresTime(cardApiTicketExpiresTime);
//        save(wxConfig);
//    }
//
//    public void expireCardApiTicket() {
//        this.cardApiTicketExpiresTime = 0;
//
//        WxConfig wxConfig = getConfig();
//        wxConfig.setCardApiTicketExpiresTime(cardApiTicketExpiresTime);
//        save(wxConfig);
//    }
//
//
//    @Override
//    public String getOauth2redirectUri() {
//        return oauth2redirectUri;
//    }
//
//    public void setOauth2redirectUri(String oauth2redirectUri) {
//        this.oauth2redirectUri = oauth2redirectUri;
//    }
//
//    @Override
//    public String getHttpProxyHost() {
//        return httpProxyHost;
//    }
//
//    public void setHttpProxyHost(String httpProxyHost) {
//        this.httpProxyHost = httpProxyHost;
//    }
//
//    @Override
//    public int getHttpProxyPort() {
//        return httpProxyPort;
//    }
//
//    public void setHttpProxyPort(int httpProxyPort) {
//        this.httpProxyPort = httpProxyPort;
//    }
//
//    @Override
//    public String getHttpProxyUsername() {
//        return httpProxyUsername;
//    }
//
//    public void setHttpProxyUsername(String httpProxyUsername) {
//        this.httpProxyUsername = httpProxyUsername;
//    }
//
//    @Override
//    public String getHttpProxyPassword() {
//        return httpProxyPassword;
//    }
//
//    public void setHttpProxyPassword(String httpProxyPassword) {
//        this.httpProxyPassword = httpProxyPassword;
//    }
//
//
//    @Override
//    public File getTmpDirFile() {
//        return null;
//    }
//
//    @Override
//    public SSLContext getSSLContext() {
//        return null;
//    }
//
//    @Override
//    public ApacheHttpClientBuilder getApacheHttpClientBuilder() {
//        return null; //设置自定义的ApacheHttpClientBuilder
//    }
//
//    @Override
//    public boolean autoRefreshToken() {
//        return true;
//    }
//
//    @Override
//    public Lock getAccessTokenLock() {
//        return accessTokenLock;
//    }
//
//    public void setAccessTokenLock(Lock accessTokenLock) {
//        this.accessTokenLock = accessTokenLock;
//    }
//
//    @Override
//    public Lock getJsapiTicketLock() {
//        return jsapiTicketLock;
//    }
//
//    public void setJsapiTicketLock(Lock jsapiTicketLock) {
//        this.jsapiTicketLock = jsapiTicketLock;
//    }
//
//    @Override
//    public Lock getCardApiTicketLock() {
//        return cardApiTicketLock;
//    }
//
//    public void setCardApiTicketLock(Lock cardApiTicketLock) {
//        this.cardApiTicketLock = cardApiTicketLock;
//    }
//
//    @Override
//    public String toString() {
//        return "WxMpConfig{" +
//                "RESERVE_TIME=" + RESERVE_TIME +
//                ", wxConfigService=" + wxConfigService +
//                ", configId=" + configId +
//                ", appId='" + appId + '\'' +
//                ", secret='" + secret + '\'' +
//                ", token='" + token + '\'' +
//                ", aesKey='" + aesKey + '\'' +
//                ", partnerId='" + partnerId + '\'' +
//                ", partnerKey='" + partnerKey + '\'' +
//                ", accessToken='" + accessToken + '\'' +
//                ", expiresTime=" + expiresTime +
//                ", jsapiTicket='" + jsapiTicket + '\'' +
//                ", jsapiTicketExpiresTime=" + jsapiTicketExpiresTime +
//                ", cardApiTicket='" + cardApiTicket + '\'' +
//                ", cardApiTicketExpiresTime=" + cardApiTicketExpiresTime +
//                ", oauth2redirectUri='" + oauth2redirectUri + '\'' +
//                ", httpProxyHost='" + httpProxyHost + '\'' +
//                ", httpProxyPort=" + httpProxyPort +
//                ", httpProxyUsername='" + httpProxyUsername + '\'' +
//                ", httpProxyPassword='" + httpProxyPassword + '\'' +
//                ", tmpDirFile=" + tmpDirFile +
//                ", sslContext=" + sslContext +
//                ", apacheHttpClientBuilder=" + apacheHttpClientBuilder +
//                '}';
//    }
//}
