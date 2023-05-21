package com.github.hugovallada.primeiroprojetospringbatch.config.batch.step

import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ImprimeOlaStepConfig(private val stepBuilderFactory: StepBuilderFactory) {

    @Bean
    fun imprimeOlaStep(imprimeOlaTasklet: Tasklet): Step {
        return stepBuilderFactory["imprimeOlaStep"]
            .tasklet(imprimeOlaTasklet)
            .build()
    }
}