package com.example.composeandxml.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.composeandxml.FragmentOneView
import com.example.composeandxml.R
import com.example.composeandxml.databinding.OneFragementBinding

class FragmentOne : Fragment() {

    private var _binding: OneFragementBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OneFragementBinding.inflate(inflater, container, false)

        val view = binding.root
        binding.one.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                MaterialTheme {
                    FragmentOneView(onClick = {
                        val direction = FragmentOneDirections.actionFragmentOneToFragmentTwo(it)
                        findNavController().navigate(direction)
                    })
                }
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}