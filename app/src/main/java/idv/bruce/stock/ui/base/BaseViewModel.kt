package idv.bruce.stock.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S : UiState, E : UiEvent, F : UiEffect>(application : Application) :
    AndroidViewModel(application) {
    protected abstract val initialState : S
}