package app.creditme.service

import app.creditme.service.ICreditService
import app.creditme.domain.Credit
import app.creditme.repository.CreditRepository
import app.creditme.service.ICustomerService
import java.util.UUID

class CreditService(
  private val creditRepository: CreditRepository,
  private val customerService: ICustomerService
) 
: ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }
  
    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomer(customerId)

    override fun findByCreditCode(creditCode: UUID,customerId:Long ): Credit
    {
        val credit = 
            this.creditRepository.findByCreditCode(creditCode) ?:
            throw RuntimeException("Credit with code $creditCode not found") 

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }


}
