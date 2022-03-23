package com.example.demo

import com.example.demo.entities.Product
import java.math.BigDecimal

data class ProductResponse(
    val sku: String,
    val name: String,
    val description: String,
    val price: BigDecimal
) {
    companion object {
        fun Product.toProductResponse() = sku?.let {
            name?.let { it1 ->
                price?.let { it2 ->
                    ProductResponse(
                        sku = it,
                        name = it1,
                        description = description ?: "",
                        price = it2
                    )
                }
            }
        }
    }
}
