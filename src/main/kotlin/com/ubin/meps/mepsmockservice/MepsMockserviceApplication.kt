package com.ubin.meps.mepsmockservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource

@SpringBootApplication(scanBasePackages = arrayOf("com.ubin.meps.mepsmockservice"))
@PropertySource("classpath:application.properties")
class MepsMockserviceApplication(){


}
fun main(args: Array<String>) {
    SpringApplication.run(MepsMockserviceApplication::class.java, *args)
}
