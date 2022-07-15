package ru.neoslax.loadauto.domain.usecases

import io.reactivex.rxjava3.core.Observable
import ru.neoslax.loadauto.di.MockData
import ru.neoslax.loadauto.di.ProdData
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.repository.CarRepository
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    @MockData private val repository: CarRepository
) {

    operator fun invoke(): Observable<List<DeviceEntity>> {
        return repository.loadData()
    }
}