package ru.neoslax.loadauto.domain.repository

import io.reactivex.rxjava3.core.Observable
import ru.neoslax.loadauto.domain.entity.DeviceEntity

interface CarRepository {

    fun loadData(): Observable<List<DeviceEntity>>
}