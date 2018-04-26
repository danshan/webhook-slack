package com.shanhh.webhook.integration.coding.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-06-01 17:17
 */
@Data
@NoArgsConstructor
public class CodingPushPayload implements CodingPayload {

    /*
    @formatter: on
     {
        "after": "daf52219b26f79ebb4e7fe367654975a141d8235",
        "ref": "master",
        "repository": {
            "https_url": "https://git.coding.net/kelvin/test_project.git",
            "description": "just demo",
            "web_url": "https://coding.net/u/kelvin/p/test_project",
            "name": "test_project",
            "project_id": "37915",
            "owner":     //仓库拥有者信息
            {
                "global_key": "kelvin",
                "name": "kelvin",
                "path": "/u/kelvin",
                "avatar": "https://dn-coding-net-production-static.qbox.me/9ed11de3-65e3-4cd8-b6aa-5abe7285ab43.jpeg?imageMogr2/auto-orient/format/jpeg/crop/!209x209a0a0"
            },
            "ssh_url": "git@git.coding.net:kelvin/test_project.git"
        },
        "before": "8e1dcdb66a4ce668706d9c774b1b0dd6d591fb52",
        "event": "push"  // 事件类型   ,
        "commits":      // 这次 push 包含的 commit 信息
         [
            {
                "sha": "daf52219b26f79ebb4e7fe367654975a141d8235",
                "short_message": "merge" // commit 提交时注释信息,
                "committer":      // 代码提交人信息
                {
                    "email": "xxxxx@gmail.com" ,
                    "name": "kelvin
                }
            }
            {
                "sha": "c8069e18c0b3ea4daad74bbcdfaa2d424ac7c861",
                "short_message": "webhook "  ,
                "committer": {
                    "email": "xxxxx@gmail.com",
                    "name": "kelvin"
                }
            }
        ]  ,
        "token": "xxx"  // token 需同 WebHook 设置一致
    }
    @formatter: off
     */

    private String before;
    private String after;
    private String ref;
    private String event; // 事件类型
    private Repository repository;
    private List<Commit> commits;
    private String token; // token 需同 webhook 设置一致


    @Data
    @NoArgsConstructor
    public static class Repository implements Serializable {
        @JsonProperty("https_url")
        private String httpsUrl;
        private String description;
        @JsonProperty("web_url")
        private String webUrl;
        private String name;
        @JsonProperty("project_id")
        private String projectId;
        @JsonProperty("ssh_url")
        private String sshUrl;
        private Owner owner; // 仓库拥有者信息
    }

    @Data
    @NoArgsConstructor
    public static class Owner implements Serializable {
        @JsonProperty("global_key")
        private String globalKey;
        private String name;
        private String path;
        private String avatar;
    }

    @Data
    @NoArgsConstructor
    public static class Commit implements Serializable {
        private String sha;
        @JsonProperty("short_message")
        private String shortMessage; // commit 提交时注释信息
        private Committer committer;
    }

    @Data
    @NoArgsConstructor
    public static class Committer implements Serializable {
        private String email;
        private String name;
    }
}
