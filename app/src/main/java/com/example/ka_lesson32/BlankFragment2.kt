package com.example.ka_lesson32

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.ka_lesson32.databinding.Fragment2Binding


class BlankFragment2 : Fragment() {

    private val dataModel: DataModel by activityViewModels()    //13. Добавляем DataModel на фрагмент 2
    lateinit var binding: Fragment2Binding  //15. Создали binding для фрагмента 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }


    //14. Создали функцию
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //16. Добавляем обсервера, который будет следить за своими данными:
        dataModel.messageForFrag2.observe(activity as LifecycleOwner, {
            binding.tvMessage.text = it   //17. Пишем то что мы будем обновлять
        })
        binding.bSendToFrag1.setOnClickListener {
            dataModel.messageForFrag1.value =  "Hello from fragment 2"
        }
        binding.bSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 2"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment2()
    }
}