package learn.app.data.api.retrofit

import com.skydoves.sandwich.ApiResponse
import learn.app.data.model.network.QuoteApiModel
import retrofit2.Call
import retrofit2.http.GET

interface QuoteService {

    @GET("/random")
    suspend fun getRandomQuote(): ApiResponse<QuoteApiModel>

//    //TODO add below request parameters..
//    @GET("/random?tags=technology,famous-quotes")
//    suspend fun getRandomQuotesByTag(): Response<QuoteApiModel>

}