package kz.just_code.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import kz.just_code.recyclerview.databinding.ActivityMainBinding
import kz.just_code.recyclerview.decoration.HeaderDecoration
import kz.just_code.recyclerview.decoration.OffsetDecoration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countries = getTransformedList()
        val countryAdapter = CountryListAdapter(countries)
        val continentAdapter = ContinentAdapter()

        with(binding) {
            listView.adapter = countryAdapter
            listView.addItemDecoration(OffsetDecoration(start = 16, top = 0, end = 16, bottom = 4))
            listView.addItemDecoration(HeaderDecoration())
            listView.layoutManager = LinearLayoutManager(this@MainActivity)
            listView.swipeToDelete {
                countryAdapter.notifyItemRemoved(it)
                Toast.makeText(this@MainActivity, countries[it].name, Toast.LENGTH_SHORT).show()
            }

            continentView.adapter = continentAdapter
            continentView.addItemDecoration(
                OffsetDecoration(
                    start = 4,
                    top = 16,
                    end = 4,
                    bottom = 8
                )
            )
            continentView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            LinearSnapHelper().attachToRecyclerView(continentView)
        }

        continentAdapter.submitList(getContinentList())
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
        list.add(CountryListDto(CountryListType.SPACING_VIEW, ""))

        return list
    }

    private fun getContinentList(): List<ContinentDto> {
        return listOf(
            ContinentDto(0, R.string.eurasia, R.drawable.ic_eurasia, ContinentViewType.CONTINENT),
            ContinentDto(1, R.string.africa, R.drawable.ic_africa, ContinentViewType.CONTINENT),
            ContinentDto(
                2,
                R.string.north_america,
                R.drawable.ic_north_america,
                ContinentViewType.CONTINENT
            ),
            ContinentDto(
                3,
                R.string.south_america,
                R.drawable.ic_south_america,
                ContinentViewType.CONTINENT
            ),
            ContinentDto(
                4,
                R.string.australia,
                R.drawable.ic_australia,
                ContinentViewType.CONTINENT
            ),
            ContinentDto(
                5,
                R.string.antarctica,
                R.drawable.ic_antarctida,
                ContinentViewType.CONTINENT
            )
        )
    }
}