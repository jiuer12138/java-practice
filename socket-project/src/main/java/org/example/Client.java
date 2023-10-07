package org.example;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            //1.创建客户端Socket,指定地址以及端口
            Socket socket = new Socket("localhost", 8888);
            //2.获取输出流，向服务器端发送信息
            //字节输出流
            OutputStream outputStream = socket.getOutputStream();
            //输出流包装为打印流
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：admin,密码：123");
            printWriter.flush();
            //3.获取输入流，读取服务端响应信息
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("我是客户端，服务端说：" + info);
            }
            //关闭资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
