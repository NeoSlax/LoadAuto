package ru.neoslax.loadauto.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.neoslax.loadauto.domain.entity.DeviceEntity

class CarListDiffCallback : DiffUtil.ItemCallback<DeviceEntity>() {

    override fun areItemsTheSame(oldItem: DeviceEntity, newItem: DeviceEntity): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: DeviceEntity, newItem: DeviceEntity): Boolean {
        return oldItem == newItem
    }
}