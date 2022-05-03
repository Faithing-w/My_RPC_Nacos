package com.wyz.test;

import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.serializer.HessianSerializer;
import com.wyz.rpc.transport.socket.server.SocketServer;

public class SocketTestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998);
        socketServer.setSerializer(new HessianSerializer());
        socketServer.publishService(helloService, HelloService.class);
    }
}
