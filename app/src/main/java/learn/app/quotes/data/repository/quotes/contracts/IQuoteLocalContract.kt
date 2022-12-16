package learn.app.quotes.data.repository.quotes.contracts

import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.local.QuotesLocal
import learn.app.quotes.utils.network.DataStatus

interface IQuoteLocalContract {

    suspend fun getRandomQuote(): DataStatus<QuoteDomain>

    suspend fun addQuote(quotesLocal: QuotesLocal)
}