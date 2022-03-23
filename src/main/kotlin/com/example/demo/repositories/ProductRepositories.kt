package com.example.demo.repositories

import com.example.demo.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String> {

    fun findBySku(sku: String): Product?
    fun findBySkuIn(skus: List<String?>): List<Product>?

}
