package com.example.searchfilms.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.searchfilms.databinding.FragmentSettingsBinding
import com.example.searchfilms.models.ADULT_SETTINGS
import com.example.searchfilms.models.getSettings
import com.example.searchfilms.models.getSettingsSharedPref

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (getSettings(requireContext())){
            binding.settingsCbAdult.isChecked = true
        }
    }

    override fun onPause() {
        super.onPause()

        val editor = getSettingsSharedPref(requireContext()).edit()
        editor.putBoolean(ADULT_SETTINGS, binding.settingsCbAdult.isChecked).apply()
    }


    companion object {
        fun newInstance() = SettingsFragment()
    }
}