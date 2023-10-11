package kz.just_code.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.just_code.recyclerview.base.BaseContinentViewHolder
import kz.just_code.recyclerview.databinding.ItemContinentBinding

class ContinentAdapter :
    ListAdapter<ContinentDto, BaseContinentViewHolder<*>>(ContinentDiffUtils()) {

    class ContinentDiffUtils : DiffUtil.ItemCallback<ContinentDto>() {
        override fun areItemsTheSame(oldItem: ContinentDto, newItem: ContinentDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContinentDto, newItem: ContinentDto): Boolean {
            return oldItem == newItem
        }
    }

    class ContinentViewHolder(binding: ItemContinentBinding) :
        BaseContinentViewHolder<ItemContinentBinding>(binding) {
        override fun bindView(item: ContinentDto) {
            with(binding) {
                image.setImageResource(item.image)
                title.text = itemView.context.getString(item.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseContinentViewHolder<*> {
        return ContinentViewHolder(
            ItemContinentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseContinentViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}

data class ContinentDto(
    val id: Int,
    @StringRes
    val name: Int,
    @DrawableRes
    val image: Int,
    val type: ContinentViewType
)

enum class ContinentViewType {
    CONTINENT, SPACER
}