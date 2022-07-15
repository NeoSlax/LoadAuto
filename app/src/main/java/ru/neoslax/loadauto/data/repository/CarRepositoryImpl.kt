package ru.neoslax.loadauto.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.neoslax.loadauto.data.mappers.toEntityList
import ru.neoslax.loadauto.data.remote.ApiService
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(val apiService: ApiService) : CarRepository {


    override fun loadData(): Observable<List<DeviceEntity>> {
        return apiService.getDeviceList().map { it.toEntityList() }
    }
}