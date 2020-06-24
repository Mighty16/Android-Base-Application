package com.vv.app.di

import android.content.Context
import com.vv.data.ReposProvider
import com.vv.domain.items.ItemsInteractor
import com.vv.domain.items.ItemsInteractorContract
import com.vv.domain.items.ItemsRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ItemsModule {

    @Provides
    @Singleton
    fun provideReposProvider(@ApplicationContext context: Context): ReposProvider {
        return ReposProvider(context, "items_db")
    }

    @Provides
    @Singleton
    fun provideItemsRepository(provider: ReposProvider): ItemsRepositoryContract {
        return provider.provideItemsRepository()
    }

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepositoryContract): ItemsInteractorContract {
        return ItemsInteractor(itemsRepository)
    }

}