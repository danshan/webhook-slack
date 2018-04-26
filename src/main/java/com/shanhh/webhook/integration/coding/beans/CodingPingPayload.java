package com.shanhh.webhook.integration.coding.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author shanhonghao
 * @since 2018-04-26 13:55
 */
@NoArgsConstructor
@Getter
@Setter
public class CodingPingPayload implements CodingPayload {

    /**
     * zen : Coding！ 让开发更简单
     * hook_id : 59448
     * hook : {"id":59448,"name":"web","type":"Repository","active":true,"events":["push","merge request","member","document","task"],"config":{"content_type":"json","url":"https://webhook.shanhh.com/webhook/coding"},"created_at":1524645286000,"updated_at":1524645287000}
     * sender : {"id":85050,"login":"danshan","avatar_url":"https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg","url":"https://coding.net/api/user/key/danshan","html_url":"https://coding.net/u/danshan","name":"法克蛋壳","name_pinyin":"|fkdk|fakedanke"}
     * repository : {"id":2822566,"name":"shanhh-hexo","full_name":"danshan/shanhh-hexo","owner":{"id":85050,"login":"danshan","avatar_url":"https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg","url":"https://coding.net/api/user/key/danshan","html_url":"https://coding.net/u/danshan","name":"法克蛋壳","name_pinyin":"|fkdk|fakedanke"},"private":true,"html_url":"https://coding.net/u/danshan/p/shanhh-hexo","description":"https://www.shanhh.com","fork":false,"url":"https://coding.net/api/user/danshan/project/shanhh-hexo","created_at":1524644815000,"updated_at":1524645173000,"clone_url":"https://git.coding.net/danshan/shanhh-hexo.git","ssh_url":"git@git.coding.net:danshan/shanhh-hexo.git","default_branch":"master"}
     */

    @SerializedName("zen")
    private String zen;
    @SerializedName("hook_id")
    private int hookId;
    @SerializedName("hook")
    private HookBean hook;
    @SerializedName("sender")
    private SenderBean sender;
    @SerializedName("repository")
    private RepositoryBean repository;

    @NoArgsConstructor
    @Getter
    @Setter
    public static class HookBean implements Serializable {
        /**
         * id : 59448
         * name : web
         * type : Repository
         * active : true
         * events : ["push","merge request","member","document","task"]
         * config : {"content_type":"json","url":"https://webhook.shanhh.com/webhook/coding"}
         * created_at : 1524645286000
         * updated_at : 1524645287000
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("type")
        private String type;
        @SerializedName("active")
        private boolean active;
        @SerializedName("config")
        private ConfigBean config;
        @SerializedName("created_at")
        private long createdAt;
        @SerializedName("updated_at")
        private long updatedAt;
        @SerializedName("events")
        private List<String> events;

        @Getter
        @Setter
        @NoArgsConstructor
        public static class ConfigBean implements Serializable {
            /**
             * content_type : json
             * url : https://webhook.shanhh.com/webhook/coding
             */

            @SerializedName("content_type")
            private String contentType;
            @SerializedName("url")
            private String url;

        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class SenderBean implements Serializable {
        /**
         * id : 85050
         * login : danshan
         * avatar_url : https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg
         * url : https://coding.net/api/user/key/danshan
         * html_url : https://coding.net/u/danshan
         * name : 法克蛋壳
         * name_pinyin : |fkdk|fakedanke
         */

        @SerializedName("id")
        private int id;
        @SerializedName("login")
        private String login;
        @SerializedName("avatar_url")
        private String avatarUrl;
        @SerializedName("url")
        private String url;
        @SerializedName("html_url")
        private String htmlUrl;
        @SerializedName("name")
        private String name;
        @SerializedName("name_pinyin")
        private String namePinyin;

    }

    @Getter
    @Setter
    public static class RepositoryBean implements Serializable {
        /**
         * id : 2822566
         * name : shanhh-hexo
         * full_name : danshan/shanhh-hexo
         * owner : {"id":85050,"login":"danshan","avatar_url":"https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg","url":"https://coding.net/api/user/key/danshan","html_url":"https://coding.net/u/danshan","name":"法克蛋壳","name_pinyin":"|fkdk|fakedanke"}
         * private : true
         * html_url : https://coding.net/u/danshan/p/shanhh-hexo
         * description : https://www.shanhh.com
         * fork : false
         * url : https://coding.net/api/user/danshan/project/shanhh-hexo
         * created_at : 1524644815000
         * updated_at : 1524645173000
         * clone_url : https://git.coding.net/danshan/shanhh-hexo.git
         * ssh_url : git@git.coding.net:danshan/shanhh-hexo.git
         * default_branch : master
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("full_name")
        private String fullName;
        @SerializedName("owner")
        private OwnerBean owner;
        @SerializedName("private")
        private boolean privateX;
        @SerializedName("html_url")
        private String htmlUrl;
        @SerializedName("description")
        private String description;
        @SerializedName("fork")
        private boolean fork;
        @SerializedName("url")
        private String url;
        @SerializedName("created_at")
        private long createdAt;
        @SerializedName("updated_at")
        private long updatedAt;
        @SerializedName("clone_url")
        private String cloneUrl;
        @SerializedName("ssh_url")
        private String sshUrl;
        @SerializedName("default_branch")
        private String defaultBranch;

        @Getter
        @Setter
        @NoArgsConstructor
        public static class OwnerBean implements Serializable {
            /**
             * id : 85050
             * login : danshan
             * avatar_url : https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg
             * url : https://coding.net/api/user/key/danshan
             * html_url : https://coding.net/u/danshan
             * name : 法克蛋壳
             * name_pinyin : |fkdk|fakedanke
             */

            @SerializedName("id")
            private int id;
            @SerializedName("login")
            private String login;
            @SerializedName("avatar_url")
            private String avatarUrl;
            @SerializedName("url")
            private String url;
            @SerializedName("html_url")
            private String htmlUrl;
            @SerializedName("name")
            private String name;
            @SerializedName("name_pinyin")
            private String namePinyin;

        }
    }
}
