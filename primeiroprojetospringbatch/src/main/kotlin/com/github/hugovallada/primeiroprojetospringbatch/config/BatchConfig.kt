package com.github.hugovallada.primeiroprojetospringbatch.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BatchConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {


    @Bean
    fun imprimeOlaJob(): Job {
        return jobBuilderFactory["imprimeOlaJob"]
            .start(imprimeOlaStep())
            .build()
    }

    private fun imprimeOlaStep(): Step {
        return stepBuilderFactory["imprimeOlaStep"]
            .tasklet { _: StepContribution, _: ChunkContext ->
                println("Ola, mundo!")
                RepeatStatus.FINISHED
            }
            .build()
    }


}