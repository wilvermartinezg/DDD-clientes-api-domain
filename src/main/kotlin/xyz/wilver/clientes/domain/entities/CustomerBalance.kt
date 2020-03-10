package xyz.wilver.clientes.domain.entities

import xyz.wilver.clientes.domain.valueObjects.MovementType
import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerBalance(
    val customerId: Long,
    val amount: BigDecimal,
    val movementType: MovementType
) {
    var id: Long = 0L
    var movementDate: LocalDateTime = LocalDateTime.now()
}
