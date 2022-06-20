package com.generation.projetopanc.dependenceInjection

import com.generation.projetopanc.api.RetrofitObject.api
import com.generation.projetopanc.api.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module //Torna um objeto de modulo
@InstallIn(SingletonComponent::class) //todas as classes sendo um objeto único

object ServiceModule {

    @Singleton
    @Provides //Indica que pode ser injetado

    fun returnRepository(): Repository{
        return Repository()
    }
}