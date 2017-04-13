package app.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity.ok
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @author nsoushi
 */
@RestController
class HealthCheckController {

    @GetMapping(value = "/health_check")
    fun index() = try {
        ok(true)
    } catch (e :Exception) {
        status(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}