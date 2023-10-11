package kz.just_code.recyclerview.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.recyclerview.ContinentDto
import kz.just_code.recyclerview.CountryListDto

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BaseCountryViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, CountryListDto>(binding)

abstract class BaseContinentViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, ContinentDto>(binding)