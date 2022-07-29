package com.example.ka_lesson32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ka_lesson32.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,    //здесь мы уже получили layoutInflater
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBlank2Binding.inflate(inflater)   //3. Создаем binding: только передаем не layoutInflater, а inflater, так как а этой функции приходит inflater
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}