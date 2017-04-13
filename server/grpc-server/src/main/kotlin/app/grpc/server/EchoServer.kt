package app.grpc.server

import grpc.server.gen.echo.EchoMessage
import grpc.server.gen.echo.EchoServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

/**
 *
 * @author nsoushi
 */
@GRpcService
class EchoServer : EchoServiceGrpc.EchoServiceImplBase() {

    override fun echoService(request: EchoMessage?, responseObserver: StreamObserver<EchoMessage>?) {
        val msg = EchoMessage.newBuilder().setMessage("echo \\${request?.message}/").build()
        responseObserver?.onNext(msg)
        responseObserver?.onCompleted()
    }
}
