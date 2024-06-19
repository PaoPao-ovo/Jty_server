package com.chilwee.jtyserver.tcp.threads;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

//指令线程类
public class InstructionThread implements Runnable {

    private Socket socket;

    public InstructionThread() {
    }

    public InstructionThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Integer hex1 = 0x01;
        Integer hex2 = 0x04;
        Integer hex3 = 0x00;
        Integer hex4 = 0x01;
        Integer hex5 = 0x00;
        Integer hex6 = 0x01;
        Integer hex7 = 0x60;
        Integer hex8 = 0x0a;
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] outarr = {hex1.byteValue(), hex2.byteValue(), hex3.byteValue(), hex4.byteValue(), hex5.byteValue(), hex6.byteValue(), hex7.byteValue(), hex8.byteValue()};
        while (true) {
            try {
                outputStream.write(outarr);
                outputStream.flush();
                Thread.sleep(1000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
