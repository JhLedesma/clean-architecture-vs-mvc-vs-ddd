package ddd

import cleanarchitecture.app.run.SpringRun
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = ["ddd"])
@EnableJpaRepositories("ddd")
@EntityScan("ddd")
class SpringRun

fun main(args: Array<String>) {
    runApplication<SpringRun>(*args)
}