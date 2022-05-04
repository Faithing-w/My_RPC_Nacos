package com.wyz.rpc.transport;

import com.wyz.rpc.serializer.CommonSerializer;

/**
 * 服务器通用接口
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, String serviceName);
}
