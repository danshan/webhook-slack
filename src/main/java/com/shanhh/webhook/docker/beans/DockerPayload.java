package com.shanhh.webhook.docker.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import jdk.net.SocketFlow;

/**
 * @author dan
 * @since 2017-03-13 15:44
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DockerPayload implements Serializable {
    /*
    @formatter:on
    {
        "callback_url": "https://registry.hub.docker.com/u/svendowideit/testhook/hook/2141b5bi5i5b02bec211i4eeih0242eg11000a/",
        "push_data": {
            "images": [
                "27d47432a69bca5f2700e4dff7de0388ed65f9d3fb1ec645e2bc24c223dc1cc3",
                "51a9c7c1f8bb2fa19bcd09789a34e63f35abb80044bc10196e304f6634cc582c",
                "..."
            ],
            "pushed_at": 1.417566161e+09,
            "pusher": "trustedbuilder"
        },
        "repository": {
            "comment_count": "0",
            "date_created": 1.417494799e+09,
            "description": "",
            "dockerfile": "#\n# BUILD\u0009\u0009docker build -t svendowideit/apt-cacher .\n# RUN\u0009\u0009docker run -d -p 3142:3142 -name apt-cacher-run apt-cacher\n#\n# and then you can run containers with:\n# \u0009\u0009docker run -t -i -rm -e http_proxy http://192.168.1.2:3142/ debian bash\n#\nFROM\u0009\u0009ubuntu\n\n\nVOLUME\u0009\u0009[\/var/cache/apt-cacher-ng\]\nRUN\u0009\u0009apt-get update ; apt-get install -yq apt-cacher-ng\n\nEXPOSE \u0009\u00093142\nCMD\u0009\u0009chmod 777 /var/cache/apt-cacher-ng ; /etc/init.d/apt-cacher-ng start ; tail -f /var/log/apt-cacher-ng/*\n",
            "full_description": "Docker Hub based automated build from a GitHub repo",
            "is_official": false,
            "is_private": true,
            "is_trusted": true,
            "name": "testhook",
            "namespace": "svendowideit",
            "owner": "svendowideit",
            "repo_name": "svendowideit/testhook",
            "repo_url": "https://registry.hub.docker.com/u/svendowideit/testhook/",
            "star_count": 0,
            "status": "Active"
        }
    }
    @formatter:off
    */

    @JsonProperty("callback_url")
    private String callbackUrl;

    @JsonProperty("push_data")
    private PushData pushData;

    private Repository repository;

    @Data
    @NoArgsConstructor
    public static class PushData implements Serializable {

        private List<String> images;

        @JsonProperty("pushed_at")
        private long pushedAt;

        public String pusher;
    }

    @Data
    @NoArgsConstructor
    public static class Repository implements Serializable {
        @JsonProperty("comment_count")
        private String commentCount;

        @JsonProperty("date_created")
        private long dateCreated;

        private String description;
        private String dockerfile;

        @JsonProperty("full_description")
        private String fullDescription;
        @JsonProperty("is_official")
        private boolean isOfficial;
        @JsonProperty("is_private")
        private boolean isPrivate;
        @JsonProperty("is_trusted")
        private boolean isTrusted;
        private String name;
        private String namespace;
        private String owner;
        @JsonProperty("repo_name")
        private String repoName;
        @JsonProperty("repo_url")
        private String repoUrl;
        @JsonProperty("star_count")
        private int starCount;
        private String status;

    }

}
