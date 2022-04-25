package com.wyz.rpc.client;

import com.wyz.rpc.entity.RpcRequest;
import com.wyz.rpc.entity.RpcResponse;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 于在客户端这一侧并没有接口的具体实现类，就没有办法直接生成实例对象。
 * 可以通过动态代理的方式生成实例，并且调用方法时生成需要的RpcRequest对象并且发送给服务端。
 */
@AllArgsConstructor
public class RpcClientProxy implements InvocationHandler {
    /**
     * 通过host 和 port 指定服务器的位置
     */
    private String host;
    private int port;

    /**
     * 生成代理对象
     */
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    /**
     * 需要生成一个RpcRequest对象，发送出去，然后返回从服务端接收到的结果
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = RpcRequest.builder()
                .interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .parameters(args)
                .paramTypes(method.getParameterTypes())
                .build();
        RpcClient rpcClient = new RpcClient();
        return ((RpcResponse) rpcClient.sendRequest(rpcRequest, host, port)).getData();
    }
}
