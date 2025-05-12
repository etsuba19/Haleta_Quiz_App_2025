package com.webbed.haletaquizapp.ui.screens.pronouns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class PronounItem(
    val amharic: String,
    val translation: String
)

class PronounsViewModel : ViewModel() {

    private val _pronouns = MutableStateFlow(
        listOf(
            PronounItem("እነ", "እኔ"),
            PronounItem("ንሕነ", " እኛ"),
            PronounItem("አንተ", "አንተ"),
            PronounItem("አንትሙ", "እናንተ"),
            PronounItem("እነቲ", "አንቺ"),
            PronounItem("አንትን", "እናነተ"),
            PronounItem("ውእቱ", " እሱ "),
            PronounItem("ውእቶሙ/እሙንቱ/", "እነርሱ"),
            PronounItem("ይእቲ", "እሷ"),
            PronounItem("ውእቶን/እማንቱ/", "እነርሱ")
        )
    )
    val pronouns: StateFlow<List<PronounItem>> = _pronouns
}
