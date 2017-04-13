package app.grpc.client

import app.config.AppProperties
import grpc.server.gen.echo.EchoMessage
import grpc.server.gen.echo.EchoServiceGrpc
import io.grpc.okhttp.OkHttpChannelBuilder
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import java.util.*

/**
 *
 * @author nsoushi
 */
@Component
class EchoClient(val appProperties: AppProperties) {

    fun request(req: Optional<String>): Mono<String> {

        if (!req.isPresent)
            return Mono.error(IllegalArgumentException())

        val channel = getChannel()
        try {
            val stub = EchoServiceGrpc.newBlockingStub(getChannel())
            val msg = EchoMessage.newBuilder().setMessage(req.get()).build()
            return Mono.just(stub.echoService(msg).message)
        } finally {
            channel.shutdown()
        }
    }

    private fun getChannel() = OkHttpChannelBuilder.forAddress(appProperties.grpc.server.hostname, appProperties.grpc.server.port!!)
                // for testing
                .usePlaintext(true)
                .build()
}
