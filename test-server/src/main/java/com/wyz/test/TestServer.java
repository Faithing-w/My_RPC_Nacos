package com.wyz.test;

import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.server.RpcServer;

public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }
}
