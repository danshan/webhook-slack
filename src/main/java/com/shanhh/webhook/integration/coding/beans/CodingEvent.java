package com.shanhh.webhook.integration.coding.beans;

/**
 * @author dan
 * @since 2017-06-01 17:25
 */
public enum CodingEvent {
    ping,
    /**
     * 任何时间项目内的 Push 操作
     */
    push,
    /**
     * 项目中的成员操作
     */
    member,
    /**
     * 任何时间项目内的任务操作
     */
    task,
    /**
     * 任何时间项目内的讨论创建，评论
     */
    topic,
    /**
     * 任何时间项目内的文档操作
     */
    document,
    /**
     * 任何时间第三方用户关注你的项目(限公有项目)
     */
    watch,
    /**
     * 任何时间对项目的收藏(限公有项目)
     */
    star,
    /**
     * 任何时间项目内的 Merge Request 操作
     */
    merge_request,
    /**
     * 任何时间项目内的 Pull Request 操作
     */
    pull_request
}
