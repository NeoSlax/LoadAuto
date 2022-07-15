package ru.neoslax.loadauto.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import ru.neoslax.loadauto.R
import ru.neoslax.loadauto.databinding.ItemCarBinding
import ru.neoslax.loadauto.databinding.ItemGroupBinding
import ru.neoslax.loadauto.domain.entity.DeviceEntity
import ru.neoslax.loadauto.domain.entity.EntityType

class CarListAdapter : ListAdapter<DeviceEntity, CarViewHolder>(CarListDiffCallback()) {

    var onItemClick: ((DeviceEntity) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).entityType) {
            EntityType.GROUP -> ITEM_GROUP
            EntityType.CAR -> ITEM_CAR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val resourceLayout = when (viewType) {
            ITEM_CAR -> R.layout.item_car
            ITEM_GROUP -> R.layout.item_group
            else -> throw RuntimeException("Can't find layout with type $viewType")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            resourceLayout, parent, false
        )
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = getItem(position)
        when (val binding = holder.binding) {
            is ItemCarBinding -> {
                binding.entity = item

                binding.root.setOnClickListener {
                    onItemClick?.invoke(item)
                }

            }
            is ItemGroupBinding -> {
                binding.entity = item
            }
        }
    }

    companion object {
        private const val ITEM_GROUP = 111
        private const val ITEM_CAR = 112
    }
}