package com.wyz.test;

import com.wyz.rpc.api.HelloObject;
import com.wyz.rpc.api.HelloService;
import com.wyz.rpc.client.RpcClientProxy;

public class TestClient {

    static class MyInner implements MyIn, MyIn2{
        private int id;

        @Override
        public void fun() {
            System.out.println("fun can do");
        }

        @Override
        public void doIt() {
            System.out.println("just do it");
        }
    }

    interface MyIn {
        void fun();
    }
    interface MyIn2 {
        void doIt();
    }
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(99, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }
}
