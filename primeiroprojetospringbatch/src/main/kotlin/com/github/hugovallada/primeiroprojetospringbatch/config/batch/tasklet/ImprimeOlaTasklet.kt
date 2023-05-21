package com.github.hugovallada.primeiroprojetospringbatch.config.batch.tasklet

import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class ImprimeOlaTasklet : Tasklet {

    override fun execute(p0: StepContribution, p1: ChunkContext): RepeatStatus? {
        println("Ola mundo")
        return RepeatStatus.FINISHED
    }
}