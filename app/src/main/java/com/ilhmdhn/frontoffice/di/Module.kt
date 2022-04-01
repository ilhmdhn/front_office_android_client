package com.ilhmdhn.frontoffice.di
import androidx.room.Room
import com.ilhmdhn.frontoffice.data.Repository
import com.ilhmdhn.frontoffice.data.source.local.LocalDataSource
import com.ilhmdhn.frontoffice.data.source.local.room.Database
import com.ilhmdhn.frontoffice.data.source.remote.RemoteDataSource
import com.ilhmdhn.frontoffice.data.source.remote.network.ApiService
import com.ilhmdhn.frontoffice.domain.repository.IRepository
import com.ilhmdhn.frontoffice.domain.usecase.Interactor
import com.ilhmdhn.frontoffice.domain.usecase.UseCase
import com.ilhmdhn.frontoffice.ui.LoginViewModel
import com.ilhmdhn.frontoffice.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module{
    factory { get<Database>().ihpDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java, "ihp.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single{
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single{
        val retrofit = Retrofit.Builder()
            .baseUrl("192.168.1.137:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module{
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IRepository>{
        Repository(
            get(),
            get(),
            get()
        )
    }
}

val useCaseModule = module{
    factory<UseCase> { Interactor(get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}