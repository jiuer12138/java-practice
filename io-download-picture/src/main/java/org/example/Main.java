package org.example;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String url = "https://jiuer12138.github.io/blog/logo.png";
        String path = "/Users/liujianfei/Downloads/javaDownLoad/";
        DownloadImageByUrl.download(url,path + UUID.randomUUID() + ".jpg");
    }
}