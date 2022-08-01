package com.example.ka_lesson32

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.ka_lesson32.databinding.Fragment1Binding


class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()     //9. Добавляем DataModel на фрагмент 1. by activityViewModels() - это уже фрагмент и берем из activityViewModels
        lateinit var binding:Fragment1Binding   //11. Cоздали binding для fragment1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    //10. создали функцию onViewCreated - здесь мы будем добавлять слушателя нажатий.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //19.Наблюдаем за обновлениями в messageForFrag1:
        dataModel.messageForFrag1.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it
        })
        binding.bSendToFrag2.setOnClickListener {
            dataModel.messageForFrag2.value =  "Hello from fragment 1"  //12.мы уже не выбираем observe, а value, так как нам нужно именить значение
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}