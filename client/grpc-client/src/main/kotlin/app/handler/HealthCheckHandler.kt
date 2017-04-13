package app.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import app.grpc.client.EchoClient
import app.util.json
import org.springframework.web.reactive.function.server.ServerResponse.badRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

/**
 *
 * @author nsoushi
 */
@Component
class HealthCheckHandler() {

    fun healthy(req: ServerRequest) = ok().json().body(Mono.just(Response(true)))
}

