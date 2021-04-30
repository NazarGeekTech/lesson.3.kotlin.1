package com.example.lesson3kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.lesson3kotlin1.adapter.ViewPagerAdapter
import com.example.lesson3kotlin1.databinding.ActivityMainBinding
import com.example.lesson3kotlin1.fragments.HistoryFrag
import com.example.lesson3kotlin1.fragments.OperationsFrag
import com.example.lesson3kotlin1.fragments.ResultFrag

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val listOfFrag: ArrayList<Fragment> =
        arrayListOf(OperationsFrag(), ResultFrag(), HistoryFrag())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        setPageSelected()
    }

    private fun setPageSelected() {
        binding.viewPagering.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottonNavigationn.menu.findItem(R.id.home_nav).isChecked = true
                    1 -> binding.bottonNavigationn.menu.findItem(R.id.notification_nav).isChecked =
                        true
                    2 -> binding.bottonNavigationn.menu.findItem(R.id.profile_nav).isChecked = true
                }
            }
        })
    }

    private fun init() {
        binding.viewPagering.adapter =
            ViewPagerAdapter(listOfFrag, supportFragmentManager, lifecycle)



        binding.bottonNavigationn.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_nav -> {
                    binding.viewPagering.currentItem = 0
                }
                R.id.notification_nav -> {
                    binding.viewPagering.currentItem = 1
                }
                R.id.profile_nav -> {
                    binding.viewPagering.currentItem = 2
                }
            }
            true
        }
    }
}
