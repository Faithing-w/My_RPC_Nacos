package com.wyz.rpc.transport.socket.server;

import com.wyz.rpc.handler.RequestHandler;
import com.wyz.rpc.entity.RpcRequest;
import com.wyz.rpc.entity.RpcResponse;
import com.wyz.rpc.provider.ServiceProvider;
import com.wyz.rpc.registry.ServiceRegistry;
import com.wyz.rpc.serializer.CommonSerializer;
import com.wyz.rpc.transport.socket.util.ObjectReader;
import com.wyz.rpc.transport.socket.util.ObjectWriter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * 处理线程，接受对象等
 */
@AllArgsConstructor
public class RequesthandlerThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RequesthandlerThread.class);

    private Socket socket;
    private RequestHandler requestHandler;
    private ServiceRegistry serviceRegistry;
    private CommonSerializer serializer;

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            RpcRequest rpcRequest = (RpcRequest) ObjectReader.readObject(inputStream);
            String interfaceName = rpcRequest.getInterfaceName();
            Object result = requestHandler.handle(rpcRequest);
            RpcResponse<Object> response = RpcResponse.success(result, rpcRequest.getRequestId());
            ObjectWriter.writeObject(outputStream, response, serializer);
        } catch (IOException e) {
            logger.error("调用或发送时有错误发生：", e);
        }
    }
}
