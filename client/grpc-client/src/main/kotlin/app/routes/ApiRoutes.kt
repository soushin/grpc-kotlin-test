package app.routes

import app.handler.EchoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

/**
 *
 * @author nsoushi
 */
@Configuration
class ApiRoutes(val echoHandler: EchoHandler) {

    @Bean
    fun apiRouter() = router {
        (accept(MediaType.APPLICATION_JSON) and "/api").nest {
            GET("/echo", echoHandler::server)
        }
    }
}
