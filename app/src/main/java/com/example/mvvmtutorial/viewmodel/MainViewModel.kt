package com.example.mvvmtutorial.viewmodel
import android.graphics.Insets.add
import androidx.core.view.OneShotPreDrawListener.add
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtutorial.helper.CommonService
import com.example.mvvmtutorial.model.Country
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.BackpressureHelper.add
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainViewModel : ViewModel() {
    val countries= MutableLiveData<List<Country>>()
    val countryLoadError= MutableLiveData<Boolean>()
    val loading= MutableLiveData<Boolean>()
    private val disposable= CompositeDisposable()
    private val commonService=CommonService()
  public  fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value=true

        disposable.add(
            commonService.getCountries()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<List<Country>>()
                {
                    override fun onSuccess(t: List<Country>) {
countries.value=t
                        countryLoadError.value=false
                        loading.value=false
                    }

                    override fun onError(e: Throwable) {
                        countryLoadError.value=true
                        loading.value=false
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}