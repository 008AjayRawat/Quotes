package learn.app.quotes.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import learn.app.quotes.di.ViewModelFactory
import learn.app.quotes.di.component.DaggerQuotesComponent
import learn.app.quotes.ui.QuotesApplication
import learn.app.quotes.ui.theme.QuotesTheme
import learn.app.quotes.ui.viewmodel.QuoteViewModel
import learn.app.quotes.ui.views.compose.RandomQuotesView
import javax.inject.Inject

/**
 * Fragment Using Jetpack compose UI Building tool
 *
 * @author Ajay Rawat
 */
class ComposeRandomQuoteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val quoteViewModel: QuoteViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[QuoteViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerQuotesComponent
            .factory()
            .create(((requireActivity().application) as QuotesApplication).coreComponent)
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                QuotesTheme(false) {
                    RandomQuotesView(quoteViewModel) {
                        quoteViewModel.getRandomQuote()
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Fetch Random Quote.
        quoteViewModel.getRandomQuote()
    }

}
