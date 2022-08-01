package com.example.ka_lesson32

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy {  //5. Создаем LifeData. by lazy - указываем для того, чтобы лямбда(что указано в квадратных
        // скобках запустилось один раз) и когда в следующий раз обращаться к классу DataModel, то уже берется то что есть,
        // не создается заново экземляр класса LiveData. LiveData будет обновлятся в нужный момент, в зависимости от цикла жизни активити или фрагмента
        //LiveData обновит userInterface когда это можно сделать, когда userInterface доступен
        MutableLiveData<String>()
    }

    //18. Как делать так, чтобы передавать данные отдельно на активити и на фрагмент?
    //Для этого нужно создать две разные переменные для фрагментов и одну для активити(вверху)
    val messageForFrag1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForFrag2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
