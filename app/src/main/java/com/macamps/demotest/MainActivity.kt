package com.macamps.demotest

import android.opengl.Visibility
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.macamps.demotest.adapter.ImageSliderAdapter
import com.macamps.demotest.adapter.RecyclerListAdapter
import com.macamps.demotest.database.DatabaseModule
import com.macamps.demotest.databinding.ActivityMainBinding
import com.macamps.demotest.model.DataModel
import com.macamps.demotest.utils.setShowSideItems
import java.util.*

class MainActivity : AppCompatActivity() {

    // binding to get the type cast UI with ids and use properties of the layout xml in kt file
    lateinit var binding: ActivityMainBinding
    private lateinit var imageViewPagerAdapter: ImageSliderAdapter
    private lateinit var labelAdapter: RecyclerListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.root.apply { setContentView(this) }
        supportActionBar?.hide()
        imageViewPagerAdapter = ImageSliderAdapter(DatabaseModule.imageResList)

        setUpViewPager()
        setRecyclerView()
//        collapseViewOnScroll(binding.viewPager, binding.scrollView2)

        onSearch()
    }

    private fun onSearch() {
        binding.searchBarEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
                if (s?.isEmpty() == true) {
                    labelAdapter.filterList(DatabaseModule.getMoviesList())
                   // binding.notFound.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun setRecyclerView() {
        labelAdapter = RecyclerListAdapter(DatabaseModule.getMoviesList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            isNestedScrollingEnabled = true
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = labelAdapter
        }

    }

    private fun setUpViewPager() {

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.pagerOffset)

        binding.viewPager.apply {
            //set the orientation of the viewpager using ViewPager2.orientation
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            binding.viewPager.setShowSideItems(pageMarginPx, offsetPx)

            //select any page you want as your starting page
            val currentPageIndex = 1
            currentItem = currentPageIndex
            adapter = imageViewPagerAdapter
            // Set auto-scroll
//            val autoScroller = AutoScroller(binding.viewPager)
//            autoScroller.setInterval(5000) // 1 second
//            autoScroller.start()
        }

        // registering for page change callback
        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    //update the image number textview
//                    binding.viewPager.text = "${position + 1} / 4"
                }
            }
        )


    }


    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<DataModel> = ArrayList<DataModel>()

        // running a for loop to compare elements.
        for (item in DatabaseModule.getMoviesList()) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.labelText.lowercase().contains(text.lowercase(Locale.getDefault()))) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            binding.notFound.visibility = View.VISIBLE
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
            labelAdapter.filterList(arrayListOf())


        } else {
            binding.notFound.visibility = View.GONE
            // at last we are passing that filtered
            // list to our adapter class.
            labelAdapter.filterList(filteredlist)
        }
    }


}