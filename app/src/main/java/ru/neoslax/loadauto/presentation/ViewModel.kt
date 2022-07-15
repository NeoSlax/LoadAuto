package ru.neoslax.loadauto.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.neoslax.loadauto.data.repository.MockRepositoryImpl
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.usecases.LoadDataUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    init {
        loadData()
    }

    private val _carList = MutableLiveData<List<DeviceEntity>>()
    val carList: LiveData<List<DeviceEntity>> = _carList

    private fun loadData() {
        loadDataUseCase().subscribeOn(Schedulers.io())
            .subscribe {
                Log.d("MAIN", it.toString())
                _carList.postValue(it)
            }
    }


}