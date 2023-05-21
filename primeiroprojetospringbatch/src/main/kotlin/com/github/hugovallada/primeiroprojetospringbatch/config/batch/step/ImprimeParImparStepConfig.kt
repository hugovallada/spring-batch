package com.github.hugovallada.primeiroprojetospringbatch.config.batch.step

import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.function.FunctionItemProcessor
import org.springframework.batch.item.support.IteratorItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ImprimeParImparStepConfig(private val stepBuilderFactory: StepBuilderFactory) {

    @Bean
    fun imprimeParImpartStep(): Step {
        return stepBuilderFactory["imprimeParImparStep"]
            .chunk<Int, String>(5)
            .reader(contaAteDezReader())
            .processor(parOuImparProcessor())
            .writer(imprimeWriter())
            .build()
    }

    private fun contaAteDezReader(): ItemReader<Int> {
        val numerosDeUmAteDez = (1..10).toList()
        return IteratorItemReader(numerosDeUmAteDez)
    }

    private fun parOuImparProcessor(): ItemProcessor<Int, String> {
        return FunctionItemProcessor {
            if (it % 2 == 0) {
                "Item $it é Par"
            } else {
                "Item $it é Ímpar"
            }
        }
    }

    private fun imprimeWriter(): ItemWriter<String> {
        return ItemWriter { iw ->
            iw.forEach(System.out::println)
        }
    }
}