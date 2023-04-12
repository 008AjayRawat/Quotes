package learn.app.quotes.data.repository.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import learn.app.quotes.data.api.QuotesService
import learn.app.quotes.data.database.dao.QuotesDao
import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.models.mapper.toDomain
import learn.app.quotes.data.models.mapper.toLocal
import learn.app.quotes.data.models.local.QuotesLocal
import learn.app.quotes.utils.enums.DataSource
import learn.app.quotes.utils.network.DataStatus
import learn.app.quotes.utils.network.Error
import learn.app.quotes.utils.network.Loading
import learn.app.quotes.utils.network.Success
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quotesService: QuotesService,
    private val quotesDao: QuotesDao
) {

    private val _randomQuote = MutableLiveData<DataStatus<QuoteDomain>>()
    val randomQuote: LiveData<DataStatus<QuoteDomain>>
        get() = _randomQuote


    suspend fun getRandomQuote(source: DataSource) {
        when (source) {
            DataSource.LOCAL -> getRandomQuoteFromLocal()
            DataSource.NETWORK -> getRandomQuoteFromNetwork()
        }
    }

    private suspend fun saveQuoteOnLocal(quotesLocal: QuotesLocal) {
        quotesDao.addQuote(quotesLocal)
    }

    private suspend fun getRandomQuoteFromNetwork() {
        _randomQuote.postValue(Loading())
        //Fetch Response..
        val response = quotesService.getRandomQuote()
        val body = response.body()
        if (response.isSuccessful) {
            body?.let { data ->
                //Save to Local database
                saveQuoteOnLocal(data.toLocal())
                //Post Successful Response..
                _randomQuote.postValue(Success(data.toDomain()))
                return //Return the execution...
            }
        }

        //Return Error Response..
        _randomQuote.postValue(Error(response.errorBody().toString()))
    }

    private suspend fun getRandomQuoteFromLocal() {
        _randomQuote.postValue(Loading())
        //Fetch Response..
        val quotesLocal = quotesDao.getRandomQuote()
        quotesLocal?.toDomain()?.let { domain -> _randomQuote.postValue(Success(domain));return }
        //if there is no data
        _randomQuote.postValue(Error("No Data Available")) //TODO hardcore.
    }

}