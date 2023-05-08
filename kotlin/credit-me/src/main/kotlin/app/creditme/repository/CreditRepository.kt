package app.creditme.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import app.creditme.domain.Credit

@Repository
interface CreditRepository: JpaRepository<Credit,Long>
