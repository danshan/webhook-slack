package com.shanhh.webhook.daocloud.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 事件
 * 目前支持的 WebHook 事件有两种，镜像构建和持续集成。
 *
 * 镜像构建
 *
 * 这是镜像构建的事件，在返回结果中的build_type 为 image_build 。
 * 如果构建成功，image值将不为空。 此时你可以使用 docker pull来拉取该镜像。
 *
 * 持续集成
 *
 * 这是持续集成的事件，在返回结果中的build_type 为 ci_build 。
 *
 * @author dan
 * @since 2017-03-03 21:43
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaocloudPayload implements Serializable {
    /*
    @formatter:on
    {
        "repo":"daocloud/api",
        "image":"daocloud.io/daocloud/api:master-init",
        "build_flow_id":"8d7622ea-9323-4489-8c8e-fc4bed448961",
        "name":"api",
        "build":
        {
            "status":"Success",
            "duration_seconds":180,
            "author":"DaoCloud",
            "triggered_by":"tag",
            "sha":"a7c35d9dc7e93788ce81befbadeb0108de495e5e",
            "tag":"master-init",
            "branch":null,
            "pull_request":"",
            "message":"init build ",
            "started_at":"2015-01-01T08:20:00+00:00",
            "build_type":"image_build"}
        }
    }
    @formatter:off
     */

    private String repo; //	用户项目全名， 用户名/项目
    private String image; // 构建成功的镜像地址
    @JsonProperty("build_flow_id")
    private String buildFlowId; // 项目 id
    private String name; //项目名
    private Build build; // 新触发的构建

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Data
    @NoArgsConstructor
    public static class Build implements Serializable {
        private String status; //	构建的状态, Success,Failure,Error,Started
        @JsonProperty("duration_seconds")
        private int durationSeconds; // 构建持续的时间
        private String author; // 触发构建的用户
        @JsonProperty("triggered_by")
        private String triggeredBy; // 触发条件, 打tag还是手动构建
        private String sha;// 代码 sha
        private String tag; // 代码的tag
        private String branch; // 代码的分支

        @JsonProperty("pull_request")
        private String pullRequest; // 代码的pull request
        private String message; // 代码 commit 消息
        @JsonProperty("started_at")
        private String startedAt; // 触发时间, iso8601 format
        @JsonProperty("build_type")

        private String buildType; // 构建类型, image_build,ci_build

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }


}
