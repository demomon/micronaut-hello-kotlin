package net.kearos.demomon.micronaut.hello.repository

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands
import net.kearos.demomon.micronaut.hello.model.Message
import java.util.*
import javax.inject.Singleton

@Singleton
class MessageRepository(val redisConnection: StatefulRedisConnection<String, String>) {

    fun getAll(): List<Message> {
        val syncCommands = redisConnection.sync()
        return syncCommands.keys("message-*").flatMap{key -> keyToMessage(key, syncCommands)}
    }

    private fun keyToMessage(key: String?, syncCommands: RedisCommands<String, String>): Iterable<Message> {
        val messageBody = syncCommands.get(key)
        val message = Message(messageBody, key.orEmpty())
        val messages = ArrayList<Message>()
        messages.add(message)
        return messages
    }

    fun addMessage(message: Message) {
        val hash = UUID.randomUUID()
        val key = "message-" + message.sender + "-" + hash
        val syncCommands = redisConnection.sync()
        syncCommands.append(key, message.body)
    }

}