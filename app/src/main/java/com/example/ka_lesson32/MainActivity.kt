package com.example.ka_lesson32

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ka_lesson32.databinding.ActivityMainBinding

/*Как можно обмениватся данными между фрагментами и активити? Для этого мы будем использовать ViewModel и lifeData
ViewModel - это специальный класс который переживает цикл жизни activity
Внутри ViewModel будем хранить LifeData - это специальный класс, который позволяет передать туда какой-нибудь объект, и этот объект обновляется
согласно циклу жизни activity. То-есть нам самим уже не нужно следить за циклом жизни активити.
Для этого необходимо добавить зависимости в build.gradle(Module):

implementation 'androidx.fragment:fragment-ktx:1.5.1'
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
 */
//4.Для того чтобы передавать данные(объекты типа String) между фрагментами и активити будем использовать ViewModel, для этого создадим класс DataModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()    //6. Добавляем DataModel. Создали инстанцию нашего класса

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(BlankFragment.newInstance(), R.id.place_holder)    //2. Вызвали фрагмент 1
        openFrag(BlankFragment2.newInstance(), R.id.place_holder2)  //3. Вызвали фрагмент 2

        dataModel.messageForActivity.observe(this, { name->    //7*в observe() передаем того,у кого мы будем следить за циклом жизни. Name - это переименованная переменная it
                binding.textView.text = name//8. Здесь мы обновляем userInterface
        })
    }

    private fun openFrag(f: Fragment, idHolder: Int) {    //1.Создали функцию для создания фрагмента
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

}

//7. Тепер создаем observe - это наблюдатель который наблюдает, когда нужно обновить данные. Как только мы отправим данные, они не мгновенно появятся
// в textView, а наблюдатель будет смотреть за циклом жизни активити и обновит данные в textView когда это можно будет сделать