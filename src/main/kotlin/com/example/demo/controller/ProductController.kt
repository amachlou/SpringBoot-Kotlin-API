package com.example.demo.controller

import com.example.demo.entities.Product
import com.example.demo.services.ProductService
import com.fasterxml.jackson.core.JsonProcessingException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class ProductController(private val productService: ProductService) {

    private val logger = LoggerFactory.getLogger(ProductController::class.java)!!

    @GetMapping("/product/{sku}", produces = ["application/json;charset=utf-8"])
    fun findProductBySku(@PathVariable("sku") sku: String): ResponseEntity<Product> {
        logger.info("Request for product $sku")

        val product = productService.findProductBySku(sku)
        return if(product == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(product)
        }
    }

    @GetMapping("/products", produces = ["application/json;charset=utf-8"])
    fun findProductsBySkus(@RequestParam(name = "sku") skus: String): ResponseEntity<List<Product>> {
        logger.info("Request for product $skus")

        val products = productService.findBySkuIn(skus.split(","))
        return if(products == null) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok(products)
        }
    }

    @PatchMapping(path = ["/product"], consumes = ["application/json"])
    fun updateProduct(@RequestBody product: Product): ResponseEntity<Product?>? {
        return try {
//            val product: Product? = productService.findProductBySku(sku) //.orElseThrow { Exception() }
            val updatedProduct: Product = productService.updateProduct(product)
            ResponseEntity.ok<Product?>(updatedProduct)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build<Product?>()
        } catch (e: JsonProcessingException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build<Product?>()
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build<Product?>()
        }
    }
}
