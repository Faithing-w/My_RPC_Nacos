package com.wyz.test;

import com.wyz.rpc.RpcClient;
import com.wyz.rpc.RpcClientProxy;
import com.wyz.rpc.api.HelloObject;
import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.netty.client.NettyClient;

public class TestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient("127.0.0.1", 9999);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}
