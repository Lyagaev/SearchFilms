package com.example.searchfilms

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    private lateinit var textView: TextView
    lateinit var person:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        printFor()
        val person = Person("Вася", "Васечкин", 29)
        val newPerson = person.copy(age=30)

        btnStart.setOnClickListener{
            textView.text=newPerson.firstName+" "+ newPerson.lastName+ " " + newPerson.age+ " лет"
        }
    }

    private fun printFor(){
        for(i in 1..10) {
            print("Hello Kotlin! $i")
        }
        print("Второй цикл")
        for(i in 10 downTo 1 step 2) {
            print("Hello Kotlin! $i")
        }
        print("Третий цикл")
        var list : List<String> = listOf("Барсик", "Мурзик", "Васька")
        for(i in list.indices){
            print("Hello Kotlin! $list[i]")
        }

        var countList=getItemCount(list)
    }

    private fun getItemCount(list : List<String>) = list.size

    private fun initView(){
        btnStart = findViewById<Button>(R.id.btnStart)
        textView = findViewById<TextView>(R.id.textView)

    }
}
