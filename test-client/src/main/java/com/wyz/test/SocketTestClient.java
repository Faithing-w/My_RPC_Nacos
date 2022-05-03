package com.wyz.test;

import com.wyz.rpc.api.HelloObject;
import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.serializer.KryoSerializer;
import com.wyz.rpc.transport.socket.client.SocketClient;
import com.wyz.rpc.transport.RpcClientProxy;

public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        client.setSerializer(new KryoSerializer());
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }
}
