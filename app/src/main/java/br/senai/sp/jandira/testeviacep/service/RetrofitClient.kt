package br.senai.sp.jandira.testeviacep.service


import br.senai.sp.jandira.testeviacep.model.EnderecoResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface ViaCepApi {
    @GET("{cep}/json/")
    fun buscarEndereco(@Path("cep") cep: String): Call<EnderecoResponse>
}

object RetrofitClient {
    val api: ViaCepApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViaCepApi::class.java)
    }
}