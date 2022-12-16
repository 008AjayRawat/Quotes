package learn.app.quotes.data.repository.quotes.source

import learn.app.quotes.data.database.dao.QuotesDao
import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.dto.mapper.toDomain
import learn.app.quotes.data.models.local.QuotesLocal
import learn.app.quotes.data.repository.quotes.contracts.IQuoteLocalContract
import learn.app.quotes.utils.network.DataStatus
import learn.app.quotes.utils.network.Error
import learn.app.quotes.utils.network.Success
import javax.inject.Inject

class QuoteLocalSource @Inject constructor(
    private val quotesDao: QuotesDao
) : IQuoteLocalContract {

    override suspend fun getRandomQuote(): DataStatus<QuoteDomain> {
        val data = quotesDao.getRandomQuote()
        data?.let {
            return Success(data.toDomain())
        }
        return Error("No Data Available")
    }

    override suspend fun addQuote(quotesLocal: QuotesLocal) {
        quotesDao.addQuote(quotesLocal)
    }
}