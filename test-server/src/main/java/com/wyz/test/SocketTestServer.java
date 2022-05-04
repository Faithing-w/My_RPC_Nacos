package com.wyz.test;

import com.wyz.rpc.annotation.ServiceScan;
import com.wyz.rpc.serializer.CommonSerializer;
import com.wyz.rpc.transport.RpcServer;
import com.wyz.rpc.transport.socket.server.SocketServer;

@ServiceScan
public class SocketTestServer {
    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        server.start();
    }
}
