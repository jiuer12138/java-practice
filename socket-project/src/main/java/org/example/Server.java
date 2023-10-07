package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket连接，实现用户登录
 * 服务端
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1.创建一个服务端Socket，即ServerSocket,指定绑定的端口并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //记录客户端的数量
            int count = 0;
            Socket socket =null;
            System.out.println("=====服务即将启动，等待客户端连接=====");
            //循环监听等待客户端的连接
            while (true){
                //调用accept()方法开始监听，等待客户端的连接
                 socket = serverSocket.accept();
                 //创建一个新的线程
                 ServerThread serverThread = new ServerThread(socket);
                 //启动线程
                 serverThread.start();
                 count++;
                System.out.println("客户端的数量:"+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
