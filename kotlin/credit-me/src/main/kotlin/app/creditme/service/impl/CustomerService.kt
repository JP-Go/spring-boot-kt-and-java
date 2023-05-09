package app.creditme.service

import app.creditme.service.ICustomerService
import app.creditme.domain.Customer
import app.creditme.repository.CustomerRepository
import java.util.UUID

class CustomerService(private val customerRepository: CustomerRepository): ICustomerService {

    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(customerId: Long): Customer = this.customerRepository.findById(customerId).orElseThrow{
        throw RuntimeException("Id $customerId not found")
      }

    override fun delete(customerId: Long) = this.customerRepository.deleteById(customerId)
    }
}
