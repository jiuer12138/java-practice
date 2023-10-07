package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机主机名以及IP地址
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost);
//        System.out.println(localHost.getHostName());
//        System.out.println(localHost.getHostAddress());
//        // 获取字节数组形式IP地址
//        byte[] address = localHost.getAddress();
//        System.out.println(Arrays.toString(address));
//        // 根据主机名获取实例
//        InetAddress local1 = InetAddress.getByName("liujianfeideMacBook-Pro.local");
//        System.out.println(local1);
//        System.out.println(local1.getHostName());
//        System.out.println(local1.getHostAddress());
        //根据IP获取实例
        InetAddress local2 = InetAddress.getByName("127.0.0.1");
        System.out.println(local2);
        System.out.println(local2.getHostName());
        System.out.println(local2.getHostAddress());

    }
}