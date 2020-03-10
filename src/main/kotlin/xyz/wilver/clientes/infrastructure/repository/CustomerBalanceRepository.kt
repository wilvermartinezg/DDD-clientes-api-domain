package xyz.wilver.clientes.infrastructure.repository

import xyz.wilver.clientes.domain.entities.CustomerBalance

interface CustomerBalanceRepository {

    fun create(customerBalance: CustomerBalance)

}
