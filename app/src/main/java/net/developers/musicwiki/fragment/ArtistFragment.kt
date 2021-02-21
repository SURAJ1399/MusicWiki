package net.developers.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.rvtutorial.ArtistAdapter
import dagger.hilt.android.AndroidEntryPoint
import net.developers.api.tagalbum.Album
import net.developers.api.tagartist.Artist
import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.FragmentArtistBinding

import net.developers.musicwiki.viewmodel.GetTagArtistViewModel

@AndroidEntryPoint
class ArtistFragment : Fragment() {

val getTagArtistViewModel:GetTagArtistViewModel by activityViewModels()
    var _binding:FragmentArtistBinding?=null
    
lateinit var ArtistAdapter:ArtistAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //  viewModel= ViewModelProvider(this).get(FeedViewModel::class.java)
        getTagArtistViewModel.fetchTagArtist()
        ArtistAdapter = ArtistAdapter()
        _binding= FragmentArtistBinding.inflate(inflater
            ,container,false)
        _binding?.artistRecyclerView?.layoutManager = GridLayoutManager(context,2)
        _binding?.artistRecyclerView?.adapter = ArtistAdapter
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTagArtistViewModel.tagartist.observe({lifecycle})
        {
            Log.i("tagalbum",it.toString())
            ArtistAdapter.updatealb(it as ArrayList<Artist>)

 }

    }

    override fun onDestroyView() {
        super.onDestroyView()
          _binding=null
    }
}