package learn.app.data.api

import learn.app.data.model.network.QuoteApiModel

interface QuoteApi {

    fun fetchRandomQuote(): List<QuoteApiModel>
}