package com.chilwee.jtyserver.tcp.config;

import com.chilwee.jtyserver.tcp.config.res.Response;
import org.springframework.stereotype.Component;

@Component
public class TcpUtils {
    //响应的数据对象
    private Response response;

    public TcpUtils() {
    };

    public TcpUtils(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
