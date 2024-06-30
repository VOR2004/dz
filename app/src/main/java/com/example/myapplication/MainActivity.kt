package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlin.math.max

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editText: EditText = findViewById(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val enteredData: Int = editText.text.toString().toInt()
            if(enteredData > 1) {
            gonka(enteredData)
            }
        }


    }
}

open class Automobile(var mark: String, var model: String, var color: String, var horsePower: Int) {
    open fun info() {
        println("Mark: ${this.mark}")
        println("Model: ${this.model}")
        println("Color: ${this.color}")
        println("Horse power: ${this.horsePower}")
    }
    open val koef = horsePower
}

class AutoBuilder() {
    var mark = "Lada"
    var model = "Granta"
    var color = "Red"
    var horsePower = 90

    var avgSpeed = 0;
    var passability = 0;
    var manageability = 0;
    var armored = 0;

    fun setMarkk(mark: String) {
        this.mark = mark;
    }
    fun setModell(model: String) {
        this.model = model;
    }
    fun setColorr(color: String) {
        this.color = color;
    }
    fun setHP(horsePower: Int) {
        this.horsePower = horsePower;
    }
    fun setSpeed(avgSpeed: Int) {
        this.avgSpeed = avgSpeed;
    }
    fun setPassabilityy(passability: Int) {
        this.passability = passability;
    }
    fun setManagee(manageability: Int) {
        this.manageability = manageability;
    }
    fun setArmoredd(armored: Int) {
        this.armored = armored;
    }
    fun build(): Automobile {
        val automobile = Automobile(mark, model, color, horsePower)
        if (maxOf(horsePower, avgSpeed, armored, passability, manageability) == avgSpeed) {
            return SportCar(mark, model, color, horsePower, avgSpeed)
        }
        if (maxOf(horsePower, avgSpeed, armored, passability, manageability) == armored) {
            return Tank(mark, model, color, horsePower, armored)
        }
        if (maxOf(horsePower, avgSpeed, armored, passability, manageability) == manageability) {
            return MotorCycle(mark, model, color, horsePower, manageability)
        }
        if (maxOf(horsePower, avgSpeed, armored, passability, manageability) == passability) {
            return Crossover(mark, model, color, horsePower, passability)
        }
        return automobile;
    }
}


class SportCar(mark: String, model: String, color: String, HorsePower: Int, val avgSpeed: Int) : Automobile(mark, model, color, HorsePower) {
    override fun info() {
        super.info()
        println("Average speed of sportcar: ${avgSpeed}")
    }

    override val koef = avgSpeed
}

class Crossover(mark: String, model: String, color: String, HorsePower: Int, val passability: Int) : Automobile(mark, model, color, HorsePower) {
    override fun info() {
        super.info()
        println("Ratio of 'passability' of crossover: ${passability}")
    }
    override val koef = passability
}

class MotorCycle(mark: String, model: String, color: String, HorsePower: Int, val manageability: Int) : Automobile(mark, model, color, HorsePower) {
    override fun info() {
        super.info()
        println("Ratio of 'manageability' of motorcycle: ${manageability}")
    }
    override val koef = manageability
}

class Tank(mark: String, model: String, color: String, HorsePower: Int, val armored: Int) : Automobile(mark, model, color, HorsePower) {
    override fun info() {
        super.info()
        println("Ratio of 'armored' of tank: ${armored}")
    }
    override val koef = armored
}

fun gonka(count: Int) {
    if (count < 1) {
        println("Нельзя вводить числа меньше 1")
    }
    else {


        val marks = listOf("Lada", "Nissan", "Toyota", "Jupiter", "Kamaz", "BMW")
        val colors = listOf("Red", "Green", "Blue", "Black", "White", "Gray")
        val models = listOf("Granta", "Kalina", "GT-R", "X-78", "R-7")
        var arr = ArrayList<Automobile>()
        for (i in 1..count) {
            var auto = AutoBuilder()
            auto.setMarkk(marks.random())
            auto.setColorr(colors.random())
            auto.setModell(models.random())
            auto.setHP((0..500).random())
            auto.setManagee((0..500).random())
            auto.setPassabilityy((0..500).random())
            auto.setArmoredd((0..500).random())
            auto.setSpeed((0..500).random())
            arr.add(auto.build())
        }
        gonn(arr)
    }
}
fun gonn(arr: ArrayList<Automobile>) {
    val winners = ArrayList<Automobile>()
    while (!arr.isEmpty()) {
        var ran1 = arr.random();
        arr.remove(ran1)
        if (arr.size >= 1) {
            var ran2 = arr.random();
            if (ran1.koef >= ran2.koef) {
                winners.add(ran1)
                println("In the battle between ${ran1.mark} ${ran1.model} and ${ran2.mark} ${ran2.model} the winner is ${ran1.mark} ${ran1.model}!")
                arr.remove(ran2)
            }
            else {
                winners.add(ran2)
                println("In the battle between ${ran1.mark} ${ran1.model} and ${ran2.mark} ${ran2.model} the winner is ${ran2.mark} ${ran2.model}!")
                arr.remove(ran2)
            }
        }
    }
    if (winners.size == 1) {
        println()
        println("${winners.get(0).mark} ${winners.get(0).model} WINS!!!!")
        println()
        println("All characteristics of the Winner:")
        winners.get(0).info()
    } else {
        gonn(winners)
    }
}
