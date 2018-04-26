package com.shanhh.webhook;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PayloadUtils {

    public static String readPayload(String filename) throws IOException {
        ClassLoader classLoader = PayloadUtils.class.getClassLoader();
        URL url = classLoader.getResource("payload/" + filename);
        File file = new File(url.getFile());
        return Files.toString(file, Charsets.UTF_8);
    }
}
