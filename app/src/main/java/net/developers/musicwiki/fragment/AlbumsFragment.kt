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
import com.example.android.rvtutorial.AlbumsAdapter
import dagger.hilt.android.AndroidEntryPoint
import net.developers.api.tagalbum.Album
import net.developers.musicwiki.R
import net.developers.musicwiki.databinding.FragmentAlbumsBinding
import net.developers.musicwiki.viewmodel.GetTagAlbumsViewModel

@AndroidEntryPoint
class AlbumsFragment : Fragment() {

val getTagAlbumsViewModel:GetTagAlbumsViewModel by activityViewModels()
    var _binding:FragmentAlbumsBinding?=null;
lateinit var albumsAdapter:AlbumsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         //  viewModel= ViewModelProvider(this).get(FeedViewModel::class.java)
        getTagAlbumsViewModel.fetchTagAlbum()
        albumsAdapter = AlbumsAdapter()
        _binding= FragmentAlbumsBinding.inflate(inflater
            ,container,false)
        _binding?.albumsRecyclerView?.layoutManager = GridLayoutManager(context,2)
        _binding?.albumsRecyclerView?.adapter = albumsAdapter
        return _binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTagAlbumsViewModel.tagalbum.observe({lifecycle})
        {
            Log.i("tagalbum",it.toString())
            albumsAdapter.updatealb(it as ArrayList<Album>)

 }

    }

    override fun onDestroyView() {
        super.onDestroyView()
          _binding=null
    }
}