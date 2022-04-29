package com.example.composeandxml.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.composeandxml.FragmentTwoView
import com.example.composeandxml.databinding.TwoFragmentBinding

class FragmentTwo : Fragment() {
    private var _binding: TwoFragmentBinding? = null
    private val binding get() = _binding!!

    private val args: FragmentTwoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TwoFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.two.apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // In Compose world
                MaterialTheme {
                    FragmentTwoView(name = args.name)
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