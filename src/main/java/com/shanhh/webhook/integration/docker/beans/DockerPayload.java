package com.shanhh.webhook.integration.docker.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-13 15:44
 */
@Getter
@Setter
@NoArgsConstructor
public class DockerPayload implements Serializable {
    /**
     * callback_url : https://registry.hub.docker.com/u/svendowideit/testhook/hook/2141b5bi5i5b02bec211i4eeih0242eg11000a/
     * push_data : {"images":["27d47432a69bca5f2700e4dff7de0388ed65f9d3fb1ec645e2bc24c223dc1cc3","51a9c7c1f8bb2fa19bcd09789a34e63f35abb80044bc10196e304f6634cc582c","..."],"pushed_at":1.417566161E9,"pusher":"trustedbuilder"}
     * repository : {"comment_count":"0","date_created":1.417494799E9,"description":"","dockerfile":"dockerfile content","is_official":false,"is_private":true,"is_trusted":true,"name":"testhook","namespace":"svendowideit","owner":"svendowideit","repo_name":"svendowideit/testhook","repo_url":"https://registry.hub.docker.com/u/svendowideit/testhook/","star_count":0,"status":"Active"}
     */

    @SerializedName("callback_url")
    private String callbackUrl;
    @SerializedName("push_data")
    private PushDataBean pushData;
    @SerializedName("repository")
    private RepositoryBean repository;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PushDataBean implements Serializable {
        /**
         * images : ["27d47432a69bca5f2700e4dff7de0388ed65f9d3fb1ec645e2bc24c223dc1cc3","51a9c7c1f8bb2fa19bcd09789a34e63f35abb80044bc10196e304f6634cc582c","..."]
         * pushed_at : 1.417566161E9
         * pusher : trustedbuilder
         */

        @SerializedName("pushed_at")
        private double pushedAt;
        @SerializedName("pusher")
        private String pusher;
        @SerializedName("images")
        private List<String> images;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class RepositoryBean implements Serializable {
        /**
         * comment_count : 0
         * date_created : 1.417494799E9
         * description :
         * dockerfile : dockerfile content
         * is_official : false
         * is_private : true
         * is_trusted : true
         * name : testhook
         * namespace : svendowideit
         * owner : svendowideit
         * repo_name : svendowideit/testhook
         * repo_url : https://registry.hub.docker.com/u/svendowideit/testhook/
         * star_count : 0
         * status : Active
         */

        @SerializedName("comment_count")
        private String commentCount;
        @SerializedName("date_created")
        private double dateCreated;
        @SerializedName("description")
        private String description;
        @SerializedName("dockerfile")
        private String dockerfile;
        @SerializedName("is_official")
        private boolean isOfficial;
        @SerializedName("is_private")
        private boolean isPrivate;
        @SerializedName("is_trusted")
        private boolean isTrusted;
        @SerializedName("name")
        private String name;
        @SerializedName("namespace")
        private String namespace;
        @SerializedName("owner")
        private String owner;
        @SerializedName("repo_name")
        private String repoName;
        @SerializedName("repo_url")
        private String repoUrl;
        @SerializedName("star_count")
        private int starCount;
        @SerializedName("status")
        private String status;

    }


}

