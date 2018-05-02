package com.shanhh.webhook.integration.coding.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-06-01 17:17
 */
@Setter
@Getter
@NoArgsConstructor
public class CodingPushPayload implements CodingPayload {

    /**
     * ref : refs/heads/master
     * before : bd4f17e41cb9b608597b6e6b91ef40dc64e262a1
     * after : 6f6211fa72ff042286953e86f90035b575e890e6
     * created : false
     * deleted : false
     * compare : https://coding.net/u/danshan/p/shanhh-hexo/git/compare/bd4f17e41cb9b...6f6211fa72ff0
     * commits : [{"id":"6f6211fa72ff042286953e86f90035b575e890e6","distinct":false,"message":"feature update dockerfile\n","timestamp":1525230478000,"url":"https://coding.net/u/danshan/p/shanhh-hexo/git/commit/6f6211fa72ff042286953e86f90035b575e890e6","author":{"name":"dan","email":"i@shanhh.com","username":"dan"},"committer":{"name":"dan","email":"i@shanhh.com","username":"dan"},"added":[],"removed":[],"modified":["Dockerfile"]}]
     * head_commit : {"id":"6f6211fa72ff042286953e86f90035b575e890e6","distinct":false,"message":"feature update dockerfile\n","timestamp":1525230478000,"url":"https://coding.net/u/danshan/p/shanhh-hexo/git/commit/6f6211fa72ff042286953e86f90035b575e890e6","author":{"name":"dan","email":"i@shanhh.com","username":"dan"},"committer":{"name":"dan","email":"i@shanhh.com","username":"dan"},"added":[],"removed":[],"modified":["Dockerfile"]}
     * pusher : {"name":"法克蛋壳","email":"i@shanhh.com","username":"danshan"}
     * sender : {"id":85050,"login":"danshan","avatar_url":"https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg","url":"https://coding.net/api/user/key/danshan","html_url":"https://coding.net/u/danshan","name":"法克蛋壳","name_pinyin":"|fkdk|fakedanke"}
     * repository : {"id":2822566,"name":"shanhh-hexo","full_name":"danshan/shanhh-hexo","owner":{"id":85050,"login":"danshan","avatar_url":"https://dn-coding-net-avatar.qbox.me/9a153f96-e7d9-47d8-b513-dcbf8579f5dc.jpg","url":"https://coding.net/api/user/key/danshan","html_url":"https://coding.net/u/danshan","name":"法克蛋壳","name_pinyin":"|fkdk|fakedanke"},"private":true,"html_url":"https://coding.net/u/danshan/p/shanhh-hexo","description":"https://www.shanhh.com","fork":false,"url":"https://coding.net/api/user/danshan/project/shanhh-hexo","created_at":1524644815000,"updated_at":1524645173000,"clone_url":"https://git.coding.net/danshan/shanhh-hexo.git","ssh_url":"git@git.coding.net:danshan/shanhh-hexo.git","default_branch":"master"}
     */

    @SerializedName("ref")
    private String ref;
    @SerializedName("before")
    private String before;
    @SerializedName("after")
    private String after;
    @SerializedName("created")
    private boolean created;
    @SerializedName("deleted")
    private boolean deleted;
    @SerializedName("compare")
    private String compare;
    @SerializedName("head_commit")
    private HeadCommitBean headCommit;
    @SerializedName("pusher")
    private PusherBean pusher;
    @SerializedName("sender")
    private SenderBean sender;
    @SerializedName("repository")
    private RepositoryBean repository;
    @SerializedName("commits")
    private List<CommitsBean> commits;

    @Setter
    @Getter
    @NoArgsConstructor
    public static class HeadCommitBean implements Serializable {
        /**
         * id : 6f6211fa72ff042286953e86f90035b575e890e6
         * distinct : false
         * message : feature update dockerfile
         * <p>
         * timestamp : 1525230478000
         * url : https://coding.net/u/danshan/p/shanhh-hexo/git/commit/6f6211fa72ff042286953e86f90035b575e890e6
         * author : {"name":"dan","email":"i@shanhh.com","username":"dan"}
         * committer : {"name":"dan","email":"i@shanhh.com","username":"dan"}
         * added : []
         * removed : []
         * modified : ["Dockerfile"]
         */

        @SerializedName("id")
        private String id;
        @SerializedName("distinct")
        private boolean distinct;
        @SerializedName("message")
        private String message;
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("url")
        private String url;
        @SerializedName("author")
        private AuthorBean author;
        @SerializedName("committer")
        private CommitterBean committer;
        @SerializedName("added")
        private List<?> added;
        @SerializedName("removed")
        private List<?> removed;
        @SerializedName("modified")
        private List<String> modified;

        @Setter
        @Getter
        @NoArgsConstructor
        public static class AuthorBean implements Serializable {
            /**
             * name : dan
             * email : i@shanhh.com
             * username : dan
             */

            @SerializedName("name")
            private String name;
            @SerializedName("email")
            private String email;
            @SerializedName("username")
            private String username;

        }

        @Setter
        @Getter
        @NoArgsConstructor
        public static class CommitterBean implements Serializable {
            /**
             * name : dan
             * email : i@shanhh.com
             * username : dan
             */

            @SerializedName("name")
            private String name;
            @SerializedName("email")
            private String email;
            @SerializedName("username")
            private String username;

        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    public static class PusherBean implements Serializable {
        /**
         * name : 法克蛋壳
         * email : i@shanhh.com
         * username : danshan
         */

        @SerializedName("name")
        private String name;
        @SerializedName("email")
        private String email;
        @SerializedName("username")
        private String username;

    }

    @Setter
    @Getter
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

    @Setter
    @Getter
    @NoArgsConstructor
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

        @Setter
        @Getter
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

    @Setter
    @Getter
    @NoArgsConstructor
    public static class CommitsBean implements Serializable {
        /**
         * id : 6f6211fa72ff042286953e86f90035b575e890e6
         * distinct : false
         * message : feature update dockerfile
         * <p>
         * timestamp : 1525230478000
         * url : https://coding.net/u/danshan/p/shanhh-hexo/git/commit/6f6211fa72ff042286953e86f90035b575e890e6
         * author : {"name":"dan","email":"i@shanhh.com","username":"dan"}
         * committer : {"name":"dan","email":"i@shanhh.com","username":"dan"}
         * added : []
         * removed : []
         * modified : ["Dockerfile"]
         */

        @SerializedName("id")
        private String id;
        @SerializedName("distinct")
        private boolean distinct;
        @SerializedName("message")
        private String message;
        @SerializedName("timestamp")
        private long timestamp;
        @SerializedName("url")
        private String url;
        @SerializedName("author")
        private AuthorBeanX author;
        @SerializedName("committer")
        private CommitterBeanX committer;
        @SerializedName("added")
        private List<?> added;
        @SerializedName("removed")
        private List<?> removed;
        @SerializedName("modified")
        private List<String> modified;

        @Setter
        @Getter
        @NoArgsConstructor
        public static class AuthorBeanX implements Serializable {
            /**
             * name : dan
             * email : i@shanhh.com
             * username : dan
             */

            @SerializedName("name")
            private String name;
            @SerializedName("email")
            private String email;
            @SerializedName("username")
            private String username;

        }

        @Setter
        @Getter
        @NoArgsConstructor
        public static class CommitterBeanX implements Serializable {
            /**
             * name : dan
             * email : i@shanhh.com
             * username : dan
             */

            @SerializedName("name")
            private String name;
            @SerializedName("email")
            private String email;
            @SerializedName("username")
            private String username;

        }
    }
}
