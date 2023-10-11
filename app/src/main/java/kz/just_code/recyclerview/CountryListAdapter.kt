package kz.just_code.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.just_code.recyclerview.base.BaseCountryViewHolder
import kz.just_code.recyclerview.databinding.ItemCountryBinding
import kz.just_code.recyclerview.databinding.ItemRegisonBinding
import kz.just_code.recyclerview.databinding.ItemSpacingBinding

class CountryListAdapter(
    private val items: List<CountryListDto>
) : RecyclerView.Adapter<BaseCountryViewHolder<*>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseCountryViewHolder<*> {
        return when (viewType) {
            CountryListType.REGION_VIEW.ordinal -> HeaderViewHolder(
                ItemRegisonBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            CountryListType.COUNTRY_VIEW.ordinal -> CountryViewHolder(
                ItemCountryBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> SpacingViewHolder(
                ItemSpacingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ), 16
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseCountryViewHolder<*>, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.ordinal
    }

    class CountryViewHolder(override val binding: ItemCountryBinding) :
        BaseCountryViewHolder<ItemCountryBinding>(binding) {

        override fun bindView(item: CountryListDto) {
            binding.title.text = item.name
        }
    }

    class HeaderViewHolder(override val binding: ItemRegisonBinding) :
        BaseCountryViewHolder<ItemRegisonBinding,>(binding) {

        override fun bindView(item: CountryListDto) {
            binding.root.text = item.name

            binding.root.setOnClickListener {

            }
        }
    }
}

enum class CountryListType {
    REGION_VIEW, COUNTRY_VIEW, SPACING_VIEW
}

data class CountryListDto(
    val viewType: CountryListType,
    val name: String
)