package learn.app.quotes.data.repository.quotes.source

import learn.app.quotes.data.api.QuotesService
import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.dto.mapper.toDomain
import learn.app.quotes.data.repository.quotes.contracts.IQuoteNetworkContract
import learn.app.quotes.utils.network.DataStatus
import learn.app.quotes.utils.network.Error
import learn.app.quotes.utils.network.Success
import javax.inject.Inject

class QuoteNetworkSource @Inject constructor(
    private val quotesService: QuotesService,
) : IQuoteNetworkContract {

    override suspend fun getRandomQuote(): DataStatus<QuoteDomain> {
        //Fetch Response..
        val response = quotesService.getRandomQuote()
        if (response.isSuccessful) {
            response.body()?.let { data ->
                return Success(data.toDomain())
            }
        }

        return Error(response.errorBody().toString())
    }
}