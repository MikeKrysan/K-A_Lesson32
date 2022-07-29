package com.example.ka_lesson32

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ka_lesson32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //2.Создаем слушателя нажатий для второго фрагмента. Фрагмент 2 на запустится, пока не нажмешь на кнопку, так как он прикреплен к слушателю нажатий
        binding.bFrag2.setOnClickListener {
            //3. Запускаем второй фрагмент
            supportFragmentManager.beginTransaction().
            replace(R.id.place_holder, BlankFragment2.newInstance())
                .commit()
        }

        supportFragmentManager.beginTransaction().  //1.Запускаем наш фрагмент  **
        replace(R.id.place_holder, BlankFragment.newInstance())
            .commit()
    }


}

//** beginTransaction() - функция для запуска фрагмента

//  replace() - заменить тот фрагмент, который уже есть в контейнере, на новый (у нас еще нет фрагмента в контейнере, поэтому мы его пока создаем)

//  replace(R.id.place_holder, ... )  - указываем название place_holder - контейнера, который будет содержать наш фрагмент (его id)

// replace(..., BlankFragment.newInstance())... - один из двух способов запустить наш фрагмент. Если написать BlankFragment() - то инстанция фрагмента будет каждый раз создаваться
// но поскольку мы используем singlton паттерн companion object, то мы пишем: BlankFragment.newInstance()

//commit() - функция для запуска фрагмента

//Что произойдет? На то место, где находится framelayout добавится разметка фрагмента. Запустится фрагмент, начнется его цикл жизни.