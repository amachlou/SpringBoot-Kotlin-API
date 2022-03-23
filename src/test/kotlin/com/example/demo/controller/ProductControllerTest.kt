package com.example.demo.controller

import com.example.demo.entities.Product
import com.example.demo.services.IProductService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.stubbing.OngoingStubbing
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.web.client.RestTemplate
import java.math.BigDecimal
import java.net.http.HttpResponse


//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = ProductController.class, secure = false)
class ProductControllerTest {
    @Autowired
    private val mockMvc: MockMvc? = null

    @MockBean
    private val restTemplate = RestTemplate()

    @MockBean
    private val productService: IProductService? = null

//    var mockProject: Product("111", "Galaxy S22", "description test", BigDecimal(77))

    @Test
    fun testFindProductsBySkus() {
//        Product product = new Product(“E001”, "Eric Simmons");
        val p = Product("111", "Galaxy S22", "description test", BigDecimal(77))
        val p2 = Product("111", "Galaxy S22", "description test", BigDecimal(77))
        val skus: ArrayList<String?> = ArrayList()
        val products: MutableList<Product?> = ArrayList()
        skus.add(p.sku)
        skus.add(p2.sku)

        Mockito.`when`(productService?.findBySkuIn(skus)).thenReturn(products)

        val requestBuilder: RequestBuilder = MockMvcRequestBuilders
            .get("http://localhost:2020/products?sku=111")
            .accept(MediaType.APPLICATION_JSON)

        val result = mockMvc!!.perform(requestBuilder).andReturn()

        println(result.response)

        val expected = "{id:Project1,name:Spring-Boot Project,description:Data Management}"

        JSONAssert.assertEquals(expected, result.response.contentAsString, false)
    }

}

private fun <T> OngoingStubbing<T>.thenReturn(products: MutableList<Product?>) {

}
