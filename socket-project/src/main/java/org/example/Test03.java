package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Test03 {
    public static void main(String[] args) {
        try {
            //创建一个url实例
            URL url =new URL("https://www.baidu.com");
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream inputStream = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //为字符输入流添加缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //读取单行数据
            String s = bufferedReader.readLine();
            while (s!=null){
                //打印数据
                System.out.println(s);
                s=bufferedReader.readLine();
            }
            //关闭资源
            inputStreamReader.close();
            inputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
