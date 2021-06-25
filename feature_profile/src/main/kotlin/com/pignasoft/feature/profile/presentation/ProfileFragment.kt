package com.pignasoft.feature.profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pignasoft.dotasks.base.delegate.viewBinding
import com.pignasoft.dotasks.feature.profile.R
import com.pignasoft.dotasks.feature.profile.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private val binding: FragmentProfileBinding by viewBinding()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
