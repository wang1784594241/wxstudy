package com.mww.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;


/**
 * 微信配置表
 * @since Dec 04, 2017
 * @version 1.0
 * @author Transnal
 */
@Entity
@Table(name = "wx_config")
public class WxConfig {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static final long serialVersionUID = 1L;
    @Length(max=255)
	@Column(name = "access_token")
    private String accessToken;// accessToken

    @Length(max=255)
	@Column(name = "aes_key")
    private String aesKey;// aesKey

    @Length(max=255)
	@Column(name = "app_id")
    private String appId;// appId

    @Length(max=255)
	@Column(name = "card_api_ticket")
    private String cardApiTicket;// cardApiTicket

	@Column(name = "card_api_ticket_expires_time")
    private Long cardApiTicketExpiresTime;// cardApiTicketExpiresTime

	@Column(name = "expires_time")
    private Long expiresTime;// expiresTime

    @Length(max=255)
	@Column(name = "jsapi_ticket")
    private String jsapiTicket;// jsapiTicket

	@Column(name = "jsapi_ticket_expires_time")
    private Long jsapiTicketExpiresTime;// jsapiTicketExpiresTime

    @Length(max=255)
	@Column(name = "key_content")
    private String keyContent;// keyContent

    @Length(max=255)
	@Column(name = "partner_id")
    private String partnerId;// partnerId

    @Length(max=255)
	@Column(name = "partner_key")
    private String partnerKey;// partnerKey

    @Length(max=255)
	@Column(name = "secret_")
    private String secret;// secret

    @Length(max=255)
	@Column(name = "token_")
    private String token;// token

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param value accessToken
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * @return aesKey
     */
    public String getAesKey() {
        return aesKey;
    }

    /**
     * @param value aesKey
     */
    public void setAesKey(String value) {
        this.aesKey = value;
    }

    /**
     * @return appId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param value appId
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * @return cardApiTicket
     */
    public String getCardApiTicket() {
        return cardApiTicket;
    }

    /**
     * @param value cardApiTicket
     */
    public void setCardApiTicket(String value) {
        this.cardApiTicket = value;
    }

    /**
     * @return cardApiTicketExpiresTime
     */
    public Long getCardApiTicketExpiresTime() {
        return cardApiTicketExpiresTime;
    }

    /**
     * @param value cardApiTicketExpiresTime
     */
    public void setCardApiTicketExpiresTime(Long value) {
        this.cardApiTicketExpiresTime = value;
    }

    /**
     * @return expiresTime
     */
    public Long getExpiresTime() {
        return expiresTime;
    }

    /**
     * @param value expiresTime
     */
    public void setExpiresTime(Long value) {
        this.expiresTime = value;
    }

    /**
     * @return jsapiTicket
     */
    public String getJsapiTicket() {
        return jsapiTicket;
    }

    /**
     * @param value jsapiTicket
     */
    public void setJsapiTicket(String value) {
        this.jsapiTicket = value;
    }

    /**
     * @return jsapiTicketExpiresTime
     */
    public Long getJsapiTicketExpiresTime() {
        return jsapiTicketExpiresTime;
    }

    /**
     * @param value jsapiTicketExpiresTime
     */
    public void setJsapiTicketExpiresTime(Long value) {
        this.jsapiTicketExpiresTime = value;
    }

    /**
     * @return keyContent
     */
    public String getKeyContent() {
        return keyContent;
    }

    /**
     * @param value keyContent
     */
    public void setKeyContent(String value) {
        this.keyContent = value;
    }

    /**
     * @return partnerId
     */
    public String getPartnerId() {
        return partnerId;
    }

    /**
     * @param value partnerId
     */
    public void setPartnerId(String value) {
        this.partnerId = value;
    }

    /**
     * @return partnerKey
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * @param value partnerKey
     */
    public void setPartnerKey(String value) {
        this.partnerKey = value;
    }

    /**
     * @return secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param value secret
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param value token
     */
    public void setToken(String value) {
        this.token = value;
    }

}

