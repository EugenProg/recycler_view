package kz.just_code.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kz.just_code.recyclerview.databinding.ActivityMainBinding
import kz.just_code.recyclerview.decoration.OffsetDecoration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = CountryListAdapter(getTransformedList())
        val offsetDecoration = OffsetDecoration(start = 16, top = 2, end = 16, bottom = 2)

        binding.listView.adapter = adapter
        binding.listView.addItemDecoration(offsetDecoration)
        binding.listView.layoutManager =
            LinearLayoutManager(this)
    }

    private fun getTransformedList(): List<CountryListDto> {
        val countryList = CountryListMaker.getCountryList(this)
        val list: MutableList<CountryListDto> = mutableListOf()

        countryList.forEachIndexed { index, item ->
            val previousItem = if (index > 0) countryList[index - 1] else null

            if (previousItem?.firstOrNull()?.lowercase() != item.firstOrNull()?.lowercase()) {
                list.add(CountryListDto(CountryListType.REGION_VIEW, item.firstOrNull().toString()))
            }
            list.add(CountryListDto(CountryListType.COUNTRY_VIEW, item))
        }

        return list
    }
}