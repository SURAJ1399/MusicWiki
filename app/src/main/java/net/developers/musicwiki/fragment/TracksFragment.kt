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
import com.example.android.rvtutorial.TrackAdapter
import dagger.hilt.android.AndroidEntryPoint
import net.developers.api.tagalbum.Album

import net.developers.api.tagtracks.Track

import net.developers.musicwiki.databinding.FragmentTracksBinding

import net.developers.musicwiki.viewmodel.GetTagTracksViewModel

@AndroidEntryPoint
class TracksFragment : Fragment() {

val getTagTrackViewModel: GetTagTracksViewModel by activityViewModels()
    var _binding: FragmentTracksBinding?=null
    
lateinit var TrackAdapter:TrackAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //  viewModel= ViewModelProvider(this).get(FeedViewModel::class.java)
        getTagTrackViewModel.fetchTagTracks()
        TrackAdapter = TrackAdapter()
        _binding= FragmentTracksBinding.inflate(inflater
            ,container,false)
        _binding?.TrackRecyclerView?.layoutManager = GridLayoutManager(context,2)
        _binding?.TrackRecyclerView?.adapter = TrackAdapter
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTagTrackViewModel.tagtracks.observe({lifecycle})
        {
            Log.i("tagalbum",it.toString())
            TrackAdapter.updatealb(it as ArrayList<Track>)

 }

    }

    override fun onDestroyView() {
        super.onDestroyView()
          _binding=null
    }
}