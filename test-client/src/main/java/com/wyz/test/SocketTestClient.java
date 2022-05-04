package com.wyz.test;

import com.wyz.rpc.api.HelloObject;
import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.serializer.CommonSerializer;
import com.wyz.rpc.transport.RpcClientProxy;
import com.wyz.rpc.transport.socket.client.SocketClient;

public class SocketTestClient {
    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        for (int i = 0; i < 20; i++) {
            String res = helloService.hello(object);
            System.out.println(res);
        }
    }
}
