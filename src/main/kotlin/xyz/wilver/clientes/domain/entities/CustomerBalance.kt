package xyz.wilver.clientes.domain.entities

import xyz.wilver.clientes.domain.valueObjects.MovementType
import java.math.BigDecimal
import java.time.LocalDateTime

class CustomerBalance(val customerId: Long) {
    var movementDate: LocalDateTime = LocalDateTime.now()
    var movementType: MovementType = MovementType.CREDIT
    var amount: BigDecimal = BigDecimal.ZERO
}
