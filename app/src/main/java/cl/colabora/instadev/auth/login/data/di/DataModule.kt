package cl.colabora.instadev.auth.login.data.di

import cl.colabora.instadev.auth.login.data.repositories.LoginRepositoryImpl
import cl.colabora.instadev.auth.login.domain.repositories.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideLoginRepository(): LoginRepository{
        return LoginRepositoryImpl()
    }
}