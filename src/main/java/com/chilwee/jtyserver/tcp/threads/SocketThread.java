package com.chilwee.jtyserver.tcp.threads;

import com.chilwee.jtyserver.tcp.config.TcpUtils;

import java.io.*;
import java.net.Socket;

//响应线程类
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

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    private void handleSocket(Socket socket) {
        System.out.println("Socket connected");
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            new Thread(new InstructionThread(socket)).start();
            while (true) {
                int read = inputStream.read(bytes);
                String hexString = bytesToHexString(bytes);
                if (read != -1) {
                    System.out.println("Received data: " + hexString);
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
