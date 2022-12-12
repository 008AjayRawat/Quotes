package learn.app.quotes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import learn.app.quotes.data.dto.domain.RandomQuoteDomain
import learn.app.quotes.data.repository.QuoteRepository
import learn.app.quotes.utils.network.DataStatus
import javax.inject.Inject

class QuoteViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    val randomQuote: LiveData<DataStatus<RandomQuoteDomain>>
        get() = repository.randomQuote


    fun getRandomQuote() {
        viewModelScope.launch { repository.getRandomQuotes() }
    }
}