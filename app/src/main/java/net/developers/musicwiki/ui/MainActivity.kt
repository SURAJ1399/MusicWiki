package net.developers.musicwiki.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.rvtutorial.TagsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import net.developers.api.tags.Tag
import net.developers.musicwiki.R
import net.developers.musicwiki.viewmodel.GetTagViewModel

@AndroidEntryPoint
class MainActivity
    : AppCompatActivity() {
    lateinit var getTagViewModel: GetTagViewModel
   lateinit var tagsAdapter:TagsAdapter
    var isexpanded:Boolean=false
    var tags=ArrayList<Tag>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        getTagViewModel = ViewModelProvider(this).get(GetTagViewModel::class.java)
        getTagViewModel.fetchTags()
        tagsAdapter = TagsAdapter(1)


        tagsRecyclerView?.layoutManager = GridLayoutManager(this,2)
        tagsRecyclerView?.adapter = tagsAdapter
        tagsAdapter.setDisplaycount(10)
//

        getTagViewModel.tags.observe({lifecycle}){
            Log.i("tags",it.toString())
            tags= it as ArrayList<Tag>
            tagsAdapter.updatetag(tags)
        }
        btnexp.setOnClickListener(View.OnClickListener { v: View? ->
            if (isexpanded) {
                isexpanded=false
                val parms=tagsRecyclerView.layoutParams
                tagsAdapter.setDisplaycount(10)
                btnexp.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            } else {
                isexpanded=true
                tagsAdapter.setDisplaycount(10000)
                btnexp.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }
        })


    }
}