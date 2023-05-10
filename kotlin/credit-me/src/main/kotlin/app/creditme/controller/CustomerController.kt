package app.creditme.controller

import app.creditme.dto.CustomerDto
import app.creditme.dto.CustomerUpdateDto
import app.creditme.dto.CustomerView
import app.creditme.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

  @PostMapping
  fun registerCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> {
    val customer = this.customerService.save(customerDto.toEntity())
    return ResponseEntity("Customer $customer.email saved", HttpStatus.CREATED)
  }

  @GetMapping("/{id}")
  fun findCustomerById(@PathVariable id: Long): ResponseEntity<CustomerView> {
    val customer = this.customerService.findById(id)
    return ResponseEntity(CustomerView(customer), HttpStatus.OK)
  }
  @DeleteMapping("/{id}")
  fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Unit> =
      ResponseEntity(this.customerService.deleteById(id), HttpStatus.NO_CONTENT)

  @PatchMapping("/{id}")
  fun updateCustomer(@PathVariable id: Long, customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView> {

    val customer = this.customerService.findById(id).apply { customerUpdateDto.toEntity(this) }

    val updatedCustomer = this.customerService.save(customer)

    return ResponseEntity(CustomerView(updatedCustomer),HttpStatus.OK)
  }
}
