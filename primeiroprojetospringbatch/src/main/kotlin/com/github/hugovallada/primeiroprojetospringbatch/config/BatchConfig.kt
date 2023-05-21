package com.github.hugovallada.primeiroprojetospringbatch.config

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Value
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
            .incrementer(RunIdIncrementer())
            .build()
    }

    private fun imprimeOlaStep(): Step {
        return stepBuilderFactory["imprimeOlaStep"]
            .tasklet(imprimeOlaTasklet())
            .build()
    }

    @Bean
    @StepScope // Precisa estar no escopo da step para usar o Value do jobParameters
    fun imprimeOlaTasklet(@Value("#{jobParameters['nome']}") name: String? = null): Tasklet {
        return Tasklet { _, _ ->
            println("Ola, $name")
            RepeatStatus.FINISHED
        }
    }

}