package com.kavyakanaja.di

import android.content.Context
import androidx.room.Room
import com.kavyakanaja.ai.AiLiteratureClient
import com.kavyakanaja.ai.LocalAiLiteratureClient
import com.kavyakanaja.data.database.KavyakanajaDatabase
import com.kavyakanaja.data.repository.KavyaRepository
import com.kavyakanaja.data.repository.OfflineFirstKavyaRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    @Singleton
    abstract fun bindRepository(repository: OfflineFirstKavyaRepository): KavyaRepository

    @Binds
    @Singleton
    abstract fun bindAiClient(client: LocalAiLiteratureClient): AiLiteratureClient
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): KavyakanajaDatabase =
        Room.databaseBuilder(context, KavyakanajaDatabase::class.java, "kavya_kanaja.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides fun providePoemDao(database: KavyakanajaDatabase) = database.poemDao()
    @Provides fun providePoetDao(database: KavyakanajaDatabase) = database.poetDao()
    @Provides fun provideFavoriteDao(database: KavyakanajaDatabase) = database.favoriteDao()
    @Provides fun provideHistoryDao(database: KavyakanajaDatabase) = database.readingHistoryDao()

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
