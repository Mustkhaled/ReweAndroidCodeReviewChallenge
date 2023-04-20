package com.rewe.android.code.review.challenge.di

import android.content.Context
import com.rewe.android.code.review.challenge.common.MyApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Provides
    @Singleton
    fun provideContext(application: MyApp): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): MyApp {
        return app as MyApp
    }

}