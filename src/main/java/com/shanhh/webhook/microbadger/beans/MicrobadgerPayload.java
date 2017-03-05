package com.shanhh.webhook.microbadger.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-05 23:41
 */
@Data
@NoArgsConstructor
public class MicrobadgerPayload implements Serializable {
    /*
    @formatter:on
     {
      "text":"MicroBadger: Docker Hub image org/name has changed",
      "image_name":"org/name",
      "new_tags":[],
      "changed_tags":[
        {
          "tag":"latest",
          "SHA":"123456789a...."
        }
      ],
      "deleted_tags":[]
    }
    @formatter:off
     */

    /**
     * A field called 'text' means these webhooks work with Slack
     */
    private String text;

    /**
     * Name of the changed image
     */
    @JsonProperty("image_name")
    private String imageName;

    /**
     * List of tags added to this image
     */
    @JsonProperty("new_tags")
    private List<Tag> newTags;

    /**
     * List of tags where the SHA has changed. The SHA given is the new one for this tag.
     */
    @JsonProperty("changed_tags")
    private List<Tag> changedTags;

    /**
     * List of tags that have been removed from this image
     */
    @JsonProperty("deleted_tags")
    private List<Tag> deletedTags;

    @Data
    @NoArgsConstructor
    public static class Tag implements Serializable {
        private String tag;
        private String SHA;
    }
}
