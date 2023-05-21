package com.github.hugovallada.primeiroprojetospringbatch.config.batch.job

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.launch.support.RunIdIncrementer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
) {

    @Bean
    fun imprimeOlaJob(imprimeOlaStep: Step): Job {
        return jobBuilderFactory["imprimeOlaJob"]
            .start(imprimeOlaStep)
            .incrementer(RunIdIncrementer())
            .build()
    }

    @Bean
    fun imprimeParImparJob(imprimeParImpartStep: Step) = jobBuilderFactory["imprimeParImparJob"]
        .start(imprimeParImpartStep)
        .incrementer(RunIdIncrementer())
        .build()
}
