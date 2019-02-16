package net.kearos.demomon.micronaut.hello.service

import net.kearos.demomon.micronaut.hello.model.Message
import net.kearos.demomon.micronaut.hello.repository.MessageRepository
import javax.inject.Singleton

interface MessageService {
    fun getAll(): List<Message>
    fun addMessage(message: Message)
}

@Singleton
class MessageServiceImpl(val messageRepository: MessageRepository): MessageService {
    override fun getAll(): List<Message> {
        return messageRepository.getAll()
    }

    override fun addMessage(message: Message) {
        messageRepository.addMessage(message)
    }
}