package com.wyz.rpc.transport;

import com.wyz.rpc.serializer.CommonSerializer;

/**
 * 服务器通用接口
 */
public interface RpcServer {
    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(Object service, Class<T> serviceClass);
}
