package learn.app.quotes.data.api

import learn.app.quotes.data.models.dto.remote.QuoteNetwork
import retrofit2.Response
import retrofit2.http.GET


interface QuotesService {

    @GET("random")
    suspend fun getRandomQuote(): Response<QuoteNetwork>
}