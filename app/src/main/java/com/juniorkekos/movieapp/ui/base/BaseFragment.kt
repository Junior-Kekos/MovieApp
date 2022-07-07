package com.juniorkekos.movieapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding,VM : ViewModel>(
    private val bindingInflater : (inflater : LayoutInflater) -> VB
) : Fragment(){

    //ViewBinding-Fragment bağlantısı
    private var _binding : VB? = null
    protected val binding : VB get() = _binding as VB

    //ViewModel bağlamak için zorunlu
    protected abstract val viewModel : VM
    //OnViewCreated scope için zorunlu
    protected abstract fun initUi()

    //Zorunlu degil ihtiyac varsa
    open fun initReceivers(){}
    open fun initOnCreateView(savedInstanceState: Bundle?){}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        initOnCreateView(savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initReceivers()
    }

    //ViewBinding memory leak önlemek için
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}