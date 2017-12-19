/*
 * ***************************************************************************
 * Copyright (c) Transnal Inc.
 * @date:2016-12-24
 * @author:alex
 * @email:xalexec@gmail.com
 * ***************************************************************************
 */

package com.mww.handler;

public class AutoReplyOperation {

    /*private static AutoReplyContentService autoReplyContentService = SpringUtils.getBean(AutoReplyContentService.class);

    *//**
     * 发送消息
     *
     * @param autoReplyContent
     * @param wxMpService
     * @param openId
     *//*
    public static void sendMessage(List<AutoReplyContent> autoReplyContent, WxMpService wxMpService, String openId) {
        if (autoReplyContent == null) {
            return;
        }
        for (AutoReplyContent replyContent : autoReplyContent) {
            //按时间判断是否发送
            Boolean isSend = verifyDate(replyContent);
            if (isSend != true) {
                continue;
            }
            WxMpKefuMessage wxMpKefuMessage = null;
            switch (replyContent.getType()) {
                case CONTENT:
                    wxMpKefuMessage = WxMpKefuMessage.TEXT().toUser(openId).content(replyContent.getContent()).build();
                    break;
                case VOICE:
                    wxMpKefuMessage = WxMpKefuMessage.VOICE().toUser(openId).mediaId(replyContent.getContent()).build();
                    break;
                case IMG:
                    wxMpKefuMessage = WxMpKefuMessage.IMAGE().toUser(openId).mediaId(replyContent.getContent()).build();
                    break;
                case CARD:
                    wxMpKefuMessage = WxMpKefuMessage.WXCARD().toUser(openId).cardId(replyContent.getContent()).build();
                    break;
                case VIDEO:
                    wxMpKefuMessage = WxMpKefuMessage.VOICE().toUser(openId).mediaId(replyContent.getContent()).build();
                    break;
                case NEWS:
                    WxMpKefuMessage.WxArticle article = new WxMpKefuMessage.WxArticle();
                    article.setUrl(replyContent.getUrl());
                    article.setDescription(replyContent.getContent());
                    article.setTitle(replyContent.getTitle());
                    article.setPicUrl(replyContent.getPicurl());

                    wxMpKefuMessage = WxMpKefuMessage.NEWS().addArticle(article).toUser(openId).build();
                    break;
                case MPNEWS:
                    wxMpKefuMessage = WxMpKefuMessage.MPNEWS().toUser(openId).mediaId(replyContent.getContent()).build();
                    break;
            }
            try {
                wxMpService.getKefuService().sendKefuMessage(wxMpKefuMessage);
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
        }
    }

    *//**
     * 根据 matchMode 生成匹配表达式
     *
     * @param matchMode
     * @param content
     * @return Pattern
     *//*
    public static Pattern getPattern(MatchMode matchMode, String content) {
        if (MatchMode.EQUALS.equals(matchMode)) {
            content = "^" + content + "$";
        } else if (MatchMode.CONTAINS.equals(matchMode)) {

        }
        return Pattern.compile(content);
    }

    *//**
     * 获取回复
     *
     * @param autoReply
     * @return 回复列表
     *//*
    public static List<AutoReplyContent> getReply(AutoReply autoReply) {
        List<AutoReplyContent> autoReplyContents = autoReplyContentService.findByReplyIdOrderByWeightDesc(autoReply.getId());
        if (autoReplyContents == null || autoReplyContents.size() < 1) {
            return null;
        }
        switch (autoReply.getReplyMode()) {
            case RANDOM_ONE:
                AutoReplyContent autoReplyContent = getRandom(autoReplyContents);
                autoReplyContents.clear();
                autoReplyContents.add(autoReplyContent);
                break;
            case REPLY_ALL:
            default:
                break;
        }
        return autoReplyContents;
    }

    *//**
     * 随机取回复
     *
     * @param autoReplyContents
     * @return
     *//*
    private static AutoReplyContent getRandom(List<AutoReplyContent> autoReplyContents) {
        List<AutoReplyContent> list = new ArrayList<>();

        if (autoReplyContents.size() == 1) {
            return autoReplyContents.get(0);
        }

        int totalWeight = 0;
        for (AutoReplyContent autoReplyContent : autoReplyContents) {
            int weight = autoReplyContent.getWeight();
            if (weight < 1) {
                weight = 1;
            }
            totalWeight += weight;

            while (weight > 0) {
                list.add(autoReplyContent);
                weight--;
            }
        }
        int index = new Random().nextInt(totalWeight);
        return list.get(index);
    }

    *//**
     * 按回复时间判断是否能回复
     *//*
    public static Boolean verifyDate(AutoReplyContent autoReplyContent) {
        if (StringUtils.isNotEmpty(autoReplyContent.getStartDate()) && StringUtils.isNotEmpty(autoReplyContent.getEndDate())) {
            //开始时间
            String startDateStr = autoReplyContent.getStartDate().replaceAll(":", "");
            //结束时间
            String endDateStr = autoReplyContent.getEndDate().replaceAll(":", "");
            //当前小时+分钟
            String currentDateStr = DateUtils.getDate("HH:mm").replaceAll(":", "");
            //判断时间是否仅为数字
            if (StringUtils.isNumeric(startDateStr) && StringUtils.isNumeric(endDateStr) && StringUtils.isNumeric(currentDateStr)) {
                int startDate = Integer.valueOf(startDateStr);
                int endDate = Integer.valueOf(endDateStr);
                int currentDate = Integer.valueOf(currentDateStr);
                //判断能否发送
                if (startDate < endDate) {//endDate为当天时间
                    if (startDate <= currentDate && currentDate < endDate) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (startDate > endDate) {//endDate为第二天时间
                    if (startDate <= currentDate || currentDate < endDate) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }*/
}
