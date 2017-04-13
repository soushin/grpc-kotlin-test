package app

import app.config.AppProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import app.util.run
import org.springframework.boot.context.properties.EnableConfigurationProperties

/**
 *
 * @author nsoushi
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties::class)
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            run(Application::class, *args)
        }
    }
}
