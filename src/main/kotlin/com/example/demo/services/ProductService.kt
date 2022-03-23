package com.example.demo.services

import com.example.demo.entities.Product
import com.example.demo.repositories.ProductRepository
//import com.example.demo.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) : IProductService {

    override fun findProductBySku(sku: String): Product? {
        return productRepository.findBySku(sku);
    }

    override fun findBySkuIn(skus: List<String?>): List<Product>? {
        return productRepository.findBySkuIn(skus);
    }

    override fun updateProduct(product: Product): Product {
        return productRepository.save(product)
    }


}