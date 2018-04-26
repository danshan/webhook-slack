package com.shanhh.webhook.repo.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-03 22:10
 */
@Data
public class SlackAttaPayload implements SlackPayload {
    /*
    @formatter:on
    {
        "attachments": [
            {
                "fallback": "Required plain-text summary of the attachment.",
                "color": "#36a64f",
                "pretext": "Optional text that appears above the attachment block",
                "author_name": "Bobby Tables",
                "author_link": "http://flickr.com/bobby/",
                "author_icon": "http://flickr.com/icons/bobby.jpg",
                "title": "Slack API Documentation",
                "title_link": "https://api.slack.com/",
                "text": "Optional text that appears within the attachment",
                "fields": [
                    {
                        "title": "Priority",
                        "value": "High",
                        "short": false
                    }
                ],
                "image_url": "http://my-website.com/path/to/image.jpg",
                "thumb_url": "http://example.com/path/to/thumb.png",
                "footer": "Slack API",
                "footer_icon": "https://platform.slack-edge.com/img/default_application_icon.png",
                "ts": 123456789
            }
        ]
    }
    @formatter:off
     */

    private String text;
    private List<Attachment> attachments;
    @SerializedName("mrkdwn_in")
    private List<String> mrkdwnIn;

    @Data
    @Builder
    public static class Attachment implements Serializable {
        /**
         * A plain-text summary of the attachment. This text will be used in clients that don't show
         * formatted text (eg. IRC, mobile notifications) and should not contain any markup.
         */
        private String fallback;

        /**
         * Like traffic signals, color-coding messages can quickly communicate intent and help
         * separate
         * them from the flow of other messages in the timeline.
         * <p>
         * An optional value that can either be one of good, warning, danger, or any hex color code
         * (eg.
         * #439FE0). This value is used to color the border along the left side of the message
         * attachment.
         */
        private String color;

        /**
         * This is optional text that appears above the message attachment block.
         */
        private String pretext;


        //=====================================================
        // author parameters
        // The author parameters will display a small section at the top of a message attachment that
        // can contain the following fields:
        //=================================================


        /**
         * Small text used to display the author's name.
         */
        @SerializedName("author_name")
        private String authorName;

        /**
         * A valid URL that will hyperlink the author_name text mentioned above. Will only work if
         * author_name is present.
         */
        @SerializedName("author_link")
        private String authorLink;

        /**
         * A valid URL that displays a small 16x16px image to the left of the author_name text. Will
         * only work if author_name is present.
         */
        @SerializedName("author_icon")
        private String authorIcon;

        /**
         * The title is displayed as larger, bold text near the top of a message attachment.
         */
        private String title;

        /**
         * By passing a valid URL in the title_link parameter (optional), the title text will be
         * hyperlinked.
         */
        @SerializedName("title_link")
        private String titleLink;

        /**
         * This is the main text in a message attachment, and can contain standard message markup.
         * The
         * content will automatically collapse if it contains 700+ characters or 5+ linebreaks, and
         * will
         * display a "Show more..." link to expand the content. Links posted in the text field will
         * not
         * unfurl.
         */
        private String text;

        private List<Field> fields;

        /**
         * A valid URL to an image file that will be displayed inside a message attachment. We
         * currently support the following formats: GIF, JPEG, PNG, and BMP.
         * <p>
         * Large images will be resized to a maximum width of 400px or a maximum height of 500px,
         * while still maintaining the original aspect ratio.
         */
        @SerializedName("image_url")
        private String imageUrl;

        /**
         * A valid URL to an image file that will be displayed as a thumbnail on the right side of a
         * message attachment. We currently support the following formats: GIF, JPEG, PNG, and BMP.
         * <p>
         * The thumbnail's longest dimension will be scaled down to 75px while maintaining the
         * aspect ratio of the image. The filesize of the image must also be less than 500 KB.
         * <p>
         * For best results, please use images that are already 75px by 75px.
         */
        @SerializedName("thumb_url")
        private String thumbUrl;

        /**
         * Add some brief text to help contextualize and identify an attachment. Limited to 300
         * characters, and may be truncated further when displayed to users in environments with
         * limited screen real estate.
         * <p>
         * Screenshot of rendered footer, footer_icon, and ts fields
         * <p>
         * Example: "Slack API"
         */
        private String footer;

        /**
         * To render a small icon beside your footer text, provide a publicly accessible URL string
         * in the footer_icon field. You must also provide a footer for the field to be recognized.
         * <p>
         * We'll render what you provide at 16px by 16px. It's best to use an image that is
         * similarly sized.
         * <p>
         * Example: "https://platform.slack-edge.com/img/default_application_icon.png"
         */
        @SerializedName("footer_icon")
        private String footerIcon;

        /**
         * Does your attachment relate to something happening at a specific time?
         * <p>
         * By providing the ts field with an integer value in "epoch time", the attachment will
         * display an additional timestamp value as part of the attachment's footer.
         * <p>
         * Use ts when referencing articles or happenings. Your message will have its own timestamp
         * when published.
         * <p>
         * Example: Providing 123456789 would result in a rendered timestamp of Nov 29th, 1973.
         */
        private long ts;

        @SerializedName("mrkdwn_in")
        private List<String> mrkdwnIn;

        /**
         * Fields are defined as an array, and hashes contained within it will be displayed in a
         * table inside the message attachment.
         */
        @Data
        @Builder
        public static class Field implements Serializable {

            /**
             * Shown as a bold heading above the value text. It cannot contain markup and will be
             * escaped for you.
             */
            private String title;

            /**
             * The text value of the field. It may contain standard message markup and must be
             * escaped as normal. May be multi-line.
             */
            private String value;

            /**
             * An optional flag indicating whether the value is short enough to be displayed
             * side-by-side with other values.
             */
            @SerializedName("short")
            private boolean shortField;

        }
    }
}
