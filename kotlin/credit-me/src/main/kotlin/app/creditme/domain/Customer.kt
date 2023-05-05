package app.creditme.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.Embedded

@Entity
data class Customer(
    @Column(nullable = false) var firstName: String = "",
    @Column(nullable = false) var LastName: String = "",
    @Column(nullable = false, unique = true) val cpf: String,
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var password: String = "",
    @Column(nullable = false) @Embedded var address: Address = Address(),
    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE), mappedBy = "customer")
    var credits: List<Credit> = mutableListOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
