package com.chilwee.jtyserver.localthread;

import com.chilwee.jtyserver.utils.TcpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketThread implements Runnable {

//  响应处理工具类
    private static TcpUtils tcpUtils;
//  当前的客户端对象
    private Socket socket;

    public SocketThread() {
    }
    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        handleSocket(socket);
    }

    private void handleSocket(Socket socket) {
        System.out.println("Socket connected");
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                int read = inputStream.read(tcpUtils.getResponse().getData());
                if (read == -1) {
                    System.out.println(tcpUtils.getResponse().getData()[0]);
                }else {
                    break;
                }
            }
        }catch (Exception e){
            System.out.println("Socket Error");
        }finally {
            System.out.println("Socket Closed");
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket Error --关闭失败");
            }
        }
    }
}
