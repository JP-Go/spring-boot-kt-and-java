package app.creditme.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PatchMapping

import app.creditme.service.impl.CustomerService

import app.creditme.dto.CustomerDto
import app.creditme.dto.CustomerUpdateDto
import app.creditme.dto.CustomerView



@RestController()
@RequestMapping("/api/v1/customer")
class CustomerController(
        private val customerService: CustomerService
) {

    @PostMapping
    fun registerCustomer(@RequestBody customerDto: CustomerDto):String {
        val customer = this.customerService.save(customerDto.toEntity())
        return "Customer $customer.email saved"
    }

    @GetMapping("/{id}")
    fun findCustomerById(@PathVariable id:Long): CustomerView {
        val customer = this.customerService.findById(id)
        return CustomerView(customer)
    }
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.deleteById(id)

    @PatchMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, customerUpdateDto: CustomerUpdateDto): CustomerView {

        val customer = this.customerService.findById(id).apply {
            customerUpdateDto.toEntity(this)
        }

        val updatedCustomer = this.customerService.save(customer)

        return CustomerView(updatedCustomer)
    }

}
