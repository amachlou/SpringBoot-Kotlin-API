package com.example.demo.services

import com.example.demo.entities.Product

interface IProductService {
    fun findBySkuIn(skus: List<String?>): List<Product>?
    fun findProductBySku(sku: String): Product?
    fun updateProduct(product: Product): Product
}