package learn.app.quotes.data.repository.quotes.contracts

import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.remote.QuoteNetwork
import learn.app.quotes.utils.network.DataStatus
import retrofit2.Response

interface IQuoteNetworkContract {
    suspend fun getRandomQuote(): DataStatus<QuoteDomain>
}