package com.github.hugovallada.primeiroprojetospringbatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class PrimeiroprojetospringbatchApplication

fun main(args: Array<String>) {
	runApplication<PrimeiroprojetospringbatchApplication>(*args)
}
