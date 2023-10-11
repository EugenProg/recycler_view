package kz.just_code.recyclerview

import android.view.View
import android.view.ViewGroup
import kz.just_code.recyclerview.base.BaseCountryViewHolder
import kz.just_code.recyclerview.databinding.ItemSpacingBinding
import kz.just_code.recyclerview.decoration.dp

class SpacingViewHolder(override val binding: ItemSpacingBinding, private val height: Int) :
    BaseCountryViewHolder<ItemSpacingBinding>(binding) {
    override fun bindView(item: CountryListDto) {
        binding.root.setHeight(height.dp)
    }
}

fun View.setHeight(height: Int) {
    val layoutParams = this.layoutParams as ViewGroup.LayoutParams
    layoutParams.height = height
    this.layoutParams = layoutParams
}