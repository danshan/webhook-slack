package com.shanhh.webhook.integration.microbadger.service;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.shanhh.webhook.integration.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.repo.entity.SlackAttaColor;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dan
 * @since 2017-03-05 23:46
 */
@Service
@Slf4j
public class MicrobadgerServiceImpl implements MicrobadgerService {

    @Override
    public SlackPayload exec(MicrobadgerPayload payload) {
        if (checkSkip(payload)) {
            return null;
        }

        SlackAttaPayload slack = new SlackAttaPayload();

        List<SlackAttaPayload.Attachment.Field> fields = Lists.newLinkedList();
        if (!CollectionUtils.isEmpty(payload.getNewTags())) {
            String tags = Joiner.on(" | ").join(payload.getNewTags().stream().map(MicrobadgerPayload.TagBean::getTag).collect(Collectors.toList()));
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .shortField(false)
                    .title("New Tags")
                    .value(tags)
                    .build());
        }
        if (!CollectionUtils.isEmpty(payload.getChangedTags())) {
            String tags = Joiner.on(" | ").join(payload.getChangedTags().stream().map(MicrobadgerPayload.TagBean::getTag).collect(Collectors.toList()));
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .shortField(false)
                    .title("Changed Tags")
                    .value(tags)
                    .build());
        }
        if (!CollectionUtils.isEmpty(payload.getDeletedTags())) {
            String tags = Joiner.on(" | ").join(payload.getDeletedTags().stream().map(MicrobadgerPayload.TagBean::getTag).collect(Collectors.toList()));
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .shortField(false)
                    .title("Deleted Tags")
                    .value(tags)
                    .build());
        }

        SlackAttaPayload.Attachment attachment = SlackAttaPayload.Attachment.builder()
                .title("Microbadger " + payload.getImageName() + " Updated")
                .text(payload.getText())
                .fallback(payload.getText())
                .color(SlackAttaColor.good.name())
                .fields(fields)
                .build();

        slack.setAttachments(Arrays.asList(attachment));
        return slack;
    }

    private boolean checkSkip(MicrobadgerPayload payload) {
        return false;
    }
}
