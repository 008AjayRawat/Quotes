package learn.app.data.datasource

import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import learn.app.data.api.retrofit.QuoteService
import learn.app.data.model.network.QuoteApiModel
import javax.inject.Inject

class QuoteRemoteDataSource @Inject constructor(
    private val quoteService: QuoteService,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun fetchRandomQuote(): ApiResponse<QuoteApiModel> =
        withContext(ioDispatcher) {
            quoteService.getRandomQuote()
        }

}