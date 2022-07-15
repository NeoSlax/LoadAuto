package ru.neoslax.loadauto.data.remote

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import ru.neoslax.loadauto.data.remote.model.DeviceResponseDto

interface ApiService {
    @GET("")
    fun getDeviceList(): Observable<DeviceResponseDto>
}