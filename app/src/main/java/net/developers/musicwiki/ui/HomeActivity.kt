package net.developers.musicwiki.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*
import net.developers.musicwiki.fragment.AlbumsFragment
import net.developers.musicwiki.R
import net.developers.musicwiki.fragment.ArtistFragment
import net.developers.musicwiki.fragment.TracksFragment
import net.developers.musicwiki.util.SharedPref
import net.developers.musicwiki.viewmodel.GetTagInfoModel
import java.util.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var getTagInfoModel: GetTagInfoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)
        val sharedPref= SharedPref(this)
        toolbar.setTitle(sharedPref.getValue("tagname","tagname"))
        getTagInfoModel = ViewModelProvider(this)
            .get(GetTagInfoModel::class.java)

        getTagInfoModel.fetchTagsInfo(sharedPref.getValue("tagname",
        "tagname"))



        getTagInfoModel.tagInfo.observe({ lifecycle }) {
            genre_desc.text = it.wiki.summary
            Log.i("tagdesc", it.wiki.summary)
        }



            val adapter = ViewPagerAdapter( supportFragmentManager)
            adapter.addFragment(AlbumsFragment(),"Albums")
           adapter.addFragment(ArtistFragment(),"Artist")
         adapter.addFragment(TracksFragment(),"Tracks")

            viewPager!!.adapter = adapter

             tabLayout.setupWithViewPager(viewPager)


        }

    }

    internal class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val mFragmentList =
            ArrayList<Fragment>()
        private val mFragmentTitleList =
            ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }


        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(i: Int): CharSequence? {
            return mFragmentTitleList[i]
        }
    }


