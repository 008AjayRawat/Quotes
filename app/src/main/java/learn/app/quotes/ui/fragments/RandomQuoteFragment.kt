package learn.app.quotes.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import learn.app.quotes.R
import learn.app.quotes.di.component.QuotesComponent.Companion.appComponent
import learn.app.quotes.di.ViewModelFactory
import learn.app.quotes.ui.viewmodel.QuoteViewModel
import learn.app.quotes.utils.network.Error
import learn.app.quotes.utils.network.Loading
import learn.app.quotes.utils.network.Success
import javax.inject.Inject


class RandomQuoteFragment : Fragment(R.layout.fragment_random_quote) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val quoteViewModel: QuoteViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[QuoteViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().application.appComponent.inject(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quoteViewModel.randomQuote.observe(viewLifecycleOwner) { status ->
            when (status) {
                is Error -> {}
                is Loading -> {}
                is Success -> {
                    view.findViewById<TextView>(R.id.tv_quote).text = "\" ${status.data?.content ?: ""} \""
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        quoteViewModel.getRandomQuote()
    }

}