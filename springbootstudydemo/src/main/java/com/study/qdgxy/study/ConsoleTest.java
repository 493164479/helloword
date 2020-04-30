package com.study.qdgxy.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ConsoleTest {
    public static void main(String[] args) throws Exception {
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 8888;
        Socket socket = new Socket(byName,port);
        FileInputStream fileInputStream = new FileInputStream(new File("a.txt"));
        byte[] bytes = new byte[1024];
        int lenght;

        if((lenght=fileInputStream.read(bytes))!=-1){
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes,0,lenght);
        }

    }
}
