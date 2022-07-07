package com.juniorkekos.movieapp.ui.home


import androidx.fragment.app.viewModels
import com.juniorkekos.movieapp.databinding.FragmentHomeBinding
import com.juniorkekos.movieapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(
    FragmentHomeBinding::inflate
){
    //ViewModel-Fragment bağlantısı
    override val viewModel by viewModels<HomeViewModel>()

    //onViewCreated scope çalışacak kodlar burada olacak
    override fun initUi() {
        binding.textView.text = "Home Fragment "
    }


}