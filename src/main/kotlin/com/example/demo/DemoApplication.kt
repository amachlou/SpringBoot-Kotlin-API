package com.example.demo

//import com.example.demo.repositories.ProductRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication {

//	@Bean
//	fun init(vararg args: String?, productRepository:ProductRepository) = CommandLineRunner {
////		productRepository.save(
////			Product("123", "BrandName", "short desc", BigDecimal(444), ZonedDateTime.now(), ZonedDateTime.now())
////		)
//	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
