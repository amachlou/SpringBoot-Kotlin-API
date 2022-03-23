package com.example.demo.entities


import lombok.NoArgsConstructor
import lombok.AllArgsConstructor
import lombok.Data
import java.math.BigDecimal
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
class Stock: java.io.Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val sku: Long? = null

    @Column(name = "name", nullable = false)
    val name: String? = null

    @Column(name = "description")
    val description: String? = null

    @ManyToOne
    val product: Product? = null

    @Column(name = "quantity", nullable = false)
    val quantity: Double = TODO()

    @UpdateTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: ZonedDateTime? = null

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: ZonedDateTime? = null
}