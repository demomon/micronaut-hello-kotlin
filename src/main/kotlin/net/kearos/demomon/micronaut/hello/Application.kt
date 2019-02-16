package net.kearos.demomon.micronaut.hello

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("net.kearos.demomon.micronaut.hello")
                .mainClass(Application.javaClass)
                .start()
    }
}