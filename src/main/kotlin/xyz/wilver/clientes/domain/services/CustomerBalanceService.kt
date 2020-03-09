package xyz.wilver.clientes.domain.services

import xyz.wilver.clientes.domain.entities.CustomerBalance
import xyz.wilver.clientes.domain.valueObjects.MovementType
import xyz.wilver.clientes.infrastructure.repository.CustomerBalanceRepository
import xyz.wilver.clientes.presentation.UserInputValueError
import xyz.wilver.clientes.presentation.UserInputValuesException
import java.math.BigDecimal

class CustomerBalanceService(private val customerBalanceRepository: CustomerBalanceRepository) {

    /**
     * Realiza la acreditacion de puntos a un cliente
     * @param customerId ID de cliente
     * @param amount Cantidad de puntos a acreditar
     */
    fun accredit(customerId: Long, amount: BigDecimal) {
        if (amount.toDouble() <= 0) {
            val description = "El monto a acreditar no puede ser menor a 1"
            val error = UserInputValueError("02", "customerBalance amount", description)
            throw UserInputValuesException(listOf(error))
        }

        val balance = CustomerBalance(customerId).apply {
            this.amount = amount
            this.movementType = MovementType.CREDIT
        }

        customerBalanceRepository.create(balance)
    }

    /**
     * Realiza el debito de puntos a un cliente
     * @param customerId ID del cliente
     * @param amount Cantidad de puntos a debitar
     */
    fun debit(customerId: Long, amount: BigDecimal) {
        if (amount.toDouble() <= 0) {
            val description = "El monto a debitar no puede ser menor a 1"
            val error = UserInputValueError("03", "customerBalance amount", description)
            throw UserInputValuesException(listOf(error))
        }

        val balance = CustomerBalance(customerId).apply {
            this.amount = amount.multiply(BigDecimal(-1))
            this.movementType = MovementType.DEBIT
        }

        customerBalanceRepository.create(balance)
    }

}
