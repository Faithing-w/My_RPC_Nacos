package com.wyz.test;

import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.serializer.CommonSerializer;
import com.wyz.rpc.transport.netty.server.NettyServer;

public class NettyTestServer {

    public static void main(String[] args) {

        HelloService helloService = new HelloServiceImpl();
        NettyServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.publishService(helloService, HelloService.class);
    }
}
