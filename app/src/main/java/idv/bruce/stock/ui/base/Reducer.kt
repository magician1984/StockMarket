package idv.bruce.stock.ui.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S : UiState, E : UiEvent>(initial : S) {
    private val _state : MutableStateFlow<S> = MutableStateFlow(initial)

    val state : StateFlow<S>
        get() = _state
}