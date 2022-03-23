package com.example.demo.entities


import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import lombok.Data
import java.math.BigDecimal
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Product: java.io.Serializable {
    @Id
    @Column(name = "sku", nullable = false)
    var sku: String? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "description")
    var description: String? = null

    @Column(name = "price", nullable = false)
    var price: BigDecimal? = null

    @UpdateTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: ZonedDateTime? = null

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: ZonedDateTime? = null

    @OneToMany(mappedBy = "product")
    val stocks: List<Stock>? = null

    constructor()

    constructor(sku: String, name: String, description: String, price: BigDecimal){
        this.sku = sku
        this.name = name
        this.description = description
        this.price = price
    }
}