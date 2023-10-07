package org.example;

import java.io.*;
import java.net.Socket;

/**
 * 服务器端线程类
 */
public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //线程执行的操作，响应客户端的请求
    public void run() {
        //字节输入流
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        try {
            inputStream = socket.getInputStream();
            //字节输入流转换为字符输入流
            inputStreamReader = new InputStreamReader(inputStream);
            //为字节输入流添加缓冲
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是服务端，客户端说：" + info);
            }
            socket.shutdownInput();//关闭输入流
            //4.获取输出流，响应服务端数据
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您!");
            printWriter.flush();//输出缓冲
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();//关闭输出流
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();

                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
