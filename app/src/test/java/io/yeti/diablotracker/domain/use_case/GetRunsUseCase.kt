package io.yeti.diablotracker.domain.use_case

import io.yeti.diablotracker.domain.repository.FakeRunRepository
import org.junit.Before

class GetRunsUseCase {


    //private lateinit var getRuns: GetRuns
    private lateinit var fakeRepository: FakeRunRepository

    @Before
    fun setUp (){
        fakeRepository = FakeRunRepository()

    }

}