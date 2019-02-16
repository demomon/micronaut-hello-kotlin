package net.kearos.demomon.micronaut.hello.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import net.kearos.demomon.micronaut.hello.model.Message
import net.kearos.demomon.micronaut.hello.service.MessageService

@Controller("/message")
class MessagesController(val messageService: MessageService) {

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun messages(): List<Message> {
        return messageService.getAll()
    }

    @Post("/")
    open fun send(@Body message: Message): HttpResponse<*> {
        messageService.addMessage(message)
        return HttpResponse.ok<Any>()
    }
}