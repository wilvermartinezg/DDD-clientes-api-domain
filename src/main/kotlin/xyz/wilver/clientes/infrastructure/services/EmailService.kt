package xyz.wilver.clientes.infrastructure.services

interface EmailService {

    fun sendEmail(from: String, to: String, body: String)

}
