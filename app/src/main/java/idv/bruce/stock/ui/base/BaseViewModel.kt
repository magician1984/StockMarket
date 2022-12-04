package idv.bruce.stock.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel< S : UiState, E : UiEvent,F : UiEffect> : ViewModel(){
    protected abstract val initialState : S
}