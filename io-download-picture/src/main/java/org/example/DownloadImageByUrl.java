package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

/**
 * @Description 通过url下载图片
 */
public class DownloadImageByUrl {
    // 通过url下载图片
    public static void download (String url,String path){
        URL url1 = null;
        try {
            url1 = new URL(url);
            //print("url1",url1);
            DataInputStream inputStream = new DataInputStream(url1.openStream());
            //print("inputStream",inputStream);

            // 如果目录不存在就创建目录
            File file = new File(path);
            //print("file",file);
            //print("file.getParentFile()",file.getParentFile());
            if (!file.getParentFile().exists()){
                try {
                    //mkdirs()方法创建一个文件夹和它的所有父文件夹
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 文件写出 该类用来创建一个文件并向文件中写数据
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            //print("fileOutputStream",fileOutputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length;

            while ((length=inputStream.read(bytes))>0){
                byteArrayOutputStream.write(bytes,0,length);
            }
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            //print("byteArrayOutputStream",byteArrayOutputStream);
            //print("fileOutputStream",fileOutputStream);
            //关闭连接
            fileOutputStream.close();
            byteArrayOutputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(String s,Object o){
        System.out.println(MessageFormat.format(s+"的值：{0}",o));
    }

}
