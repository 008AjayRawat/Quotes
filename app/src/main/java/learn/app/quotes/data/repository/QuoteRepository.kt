package learn.app.quotes.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import learn.app.quotes.data.api.QuotesService
import learn.app.quotes.data.dto.domain.RandomQuoteDomain
import learn.app.quotes.data.dto.mapper.toDomain
import learn.app.quotes.utils.network.DataStatus
import learn.app.quotes.utils.network.Success
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quotesService: QuotesService) {

    private val _randomQuote = MutableLiveData<DataStatus<RandomQuoteDomain>>()
    val randomQuote: LiveData<DataStatus<RandomQuoteDomain>>
        get() = _randomQuote


    suspend fun getRandomQuotes() {
        val response = quotesService.getRandomQuote()
        _randomQuote.postValue(Success(response.body()?.toDomain()))
    }

}