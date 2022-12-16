package learn.app.quotes.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import learn.app.quotes.data.models.domain.QuoteDomain
import learn.app.quotes.data.repository.quotes.QuoteRepository
import learn.app.quotes.utils.enums.DataSource
import learn.app.quotes.utils.network.DataStatus
import javax.inject.Inject

class QuoteViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    val randomQuote: LiveData<DataStatus<QuoteDomain>>
        get() = repository.randomQuote


    fun getRandomQuote(source: DataSource = DataSource.NETWORK) {
        viewModelScope.launch { repository.getRandomQuote(source) }
    }
}