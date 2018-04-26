package com.shanhh.webhook.integration.microbadger.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-05 23:41
 */
@Getter
@Setter
@NoArgsConstructor
public class MicrobadgerPayload implements Serializable {

    /**
     * text : MicroBadger: Docker Hub image danshan/webhook-slack has changed https://microbadger.com/images/danshan/webhook-slack
     * new_tags : []
     * image_name : danshan/webhook-slack
     * changed_tags : [{"SHA":"8d60f60f52af0ef5450ec83bfc6fdbce4c05e3ea636d5c083db9f8e98c715805","tag":"latest"}]
     * deleted_tags : []
     */

    @SerializedName("text")
    private String text;
    @SerializedName("image_name")
    private String imageName;
    @SerializedName("new_tags")
    private List<TagBean> newTags;
    @SerializedName("changed_tags")
    private List<TagBean> changedTags;
    @SerializedName("deleted_tags")
    private List<TagBean> deletedTags;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TagBean implements Serializable {
        /**
         * SHA : 8d60f60f52af0ef5450ec83bfc6fdbce4c05e3ea636d5c083db9f8e98c715805
         * tag : latest
         */

        @SerializedName("SHA")
        private String SHA;
        @SerializedName("tag")
        private String tag;
    }

}
