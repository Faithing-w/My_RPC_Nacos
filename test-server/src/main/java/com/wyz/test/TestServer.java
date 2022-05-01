package com.wyz.test;

import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.netty.server.NettyServer;
import com.wyz.rpc.registry.DefaultServiceRegistry;
import com.wyz.rpc.registry.ServiceRegistry;
import com.wyz.rpc.socket.server.SocketServer;

public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }
}
