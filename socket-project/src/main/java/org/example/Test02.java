package org.example;

import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jiuer12138.github.io/blog");
            URL url1 = new URL(url,"/interview/basics.html#promise");
            System.out.println("协议"+url1.getProtocol());//协议
            System.out.println("主机名"+url1.getHost());//主机名
            System.out.println("端口"+url1.getPort());//端口
            System.out.println("文件路径"+url1.getPath());//文件路径
            System.out.println("查询字符串"+url1.getQuery());//查询字符串
            System.out.println("文件名"+url1.getFile());//文件名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
