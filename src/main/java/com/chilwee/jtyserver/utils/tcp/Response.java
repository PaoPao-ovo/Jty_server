package com.chilwee.jtyserver.utils.tcp;

import org.springframework.stereotype.Component;

@Component
public class Response {

    //  响应的数据长度
    private int length;

    //  响应数据实际长度
    private int resLength;

    //  本次响应的内容（字节数组）
    private byte[] data;

    //  无参构造
    public Response() {

    }

    //  全参数构造
    public Response(int length, int resLength, byte[] data) {
        this.length = length;
        this.resLength = resLength;
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getResLength() {
        return resLength;
    }

    public void setResLength(int resLength) {
        this.resLength = resLength;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
