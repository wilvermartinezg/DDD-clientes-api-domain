package xyz.wilver.clientes.infrastructure.repository

import xyz.wilver.clientes.domain.entities.Customer

interface CustomerRepository {

    fun create(customer: Customer)

    fun update(customer: Customer)

    fun findById(id: Long): Customer?

}
