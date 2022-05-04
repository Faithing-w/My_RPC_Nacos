package com.wyz.rpc.transport;

import com.wyz.rpc.entity.RpcRequest;
import com.wyz.rpc.serializer.CommonSerializer;

/**
 * 客户端通用接口
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);
}
