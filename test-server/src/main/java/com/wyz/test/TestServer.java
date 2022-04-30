package com.wyz.test;

import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.registry.DefaultServiceRegistry;
import com.wyz.rpc.registry.ServiceRegistry;
import com.wyz.rpc.server.RpcServer;

public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);
    }
}
