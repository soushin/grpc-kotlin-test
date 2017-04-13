package app.grpc.server

import grpc.server.gen.echo.EchoMessage
import grpc.server.gen.echo.EchoServiceGrpc
import grpc.server.gen.greet.GreetMessage
import grpc.server.gen.greet.GreetServiceGrpc
import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService

/**
 *
 * @author nsoushi
 */
@GRpcService
class GreetServer : GreetServiceGrpc.GreetServiceImplBase() {

    override fun greetService(request: GreetMessage?, responseObserver: StreamObserver<GreetMessage>?) {
        val msg = GreetMessage.newBuilder().setMessage("hello").build()
        responseObserver?.onNext(msg)
        responseObserver?.onCompleted()
    }
}
