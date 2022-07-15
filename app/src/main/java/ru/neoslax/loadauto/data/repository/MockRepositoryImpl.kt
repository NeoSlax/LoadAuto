package ru.neoslax.loadauto.data.repository

import android.app.Application
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.rxjava3.core.Observable
import ru.neoslax.loadauto.R
import ru.neoslax.loadauto.data.mappers.toEntityList
import ru.neoslax.loadauto.data.remote.model.DeviceResponseDto
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.repository.CarRepository
import javax.inject.Inject

class MockRepositoryImpl @Inject constructor(
    private val application: Application
): CarRepository  {

    override fun loadData(): Observable<List<DeviceEntity>> {
        val inputStream = application.resources.openRawResource(R.raw.json_mock_data)
        val text = inputStream.bufferedReader().use {
            it.readText()
        }
        val itemType = object : TypeToken<DeviceResponseDto>() {}.type
        val data = Gson().fromJson<DeviceResponseDto>(text, itemType)


        return Observable.just(data.toEntityList())

    }
}