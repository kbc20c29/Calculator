package com.websarva.wings.android.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var value : Int = 0

        var clear : Boolean = false

        var calc : Boolean = false

        var operator : String? = null

        /* 数字ボタン */
        val buttonZero : Button = findViewById(R.id.zero)
        val buttonOne : Button = findViewById(R.id.one)
        val buttonTwo : Button = findViewById(R.id.two)
        val buttonThree : Button = findViewById(R.id.three)
        val buttonFour : Button = findViewById(R.id.four)
        val buttonFive : Button = findViewById(R.id.five)
        val buttonSix : Button = findViewById(R.id.six)
        val buttonSeven : Button = findViewById(R.id.seven)
        val buttonEight : Button = findViewById(R.id.eight)
        val buttonNine : Button = findViewById(R.id.nine)

        /* 計算ボタン */
        val buttonAdd : Button = findViewById(R.id.add)
        val buttonMul : Button = findViewById(R.id.mul)
        val buttonSub : Button = findViewById(R.id.sub)
        val buttonDiv :Button = findViewById(R.id.div)

        /* 実行ボタン */
        val buttonEqual:Button = findViewById(R.id.equal)

        /* クリアボタン */
        val buttonClear : Button = findViewById(R.id.clear)

        /* 表示テキスト */
        val textArea : TextView = findViewById(R.id.display)

        fun numBottunAction(num : String) {
            textArea.text = if(textArea.text.toString() != "0" && clear == false){
                textArea.text.toString() + num
            } else {
                clear = false
                num
            }
            calc = true
        }

        buttonClear.setOnClickListener {
            textArea.text ="0"
            value = 0
            operator = null
            clear = false
            calc = false
        }

        buttonZero.setOnClickListener {
            numBottunAction("0");
        }

        buttonOne.setOnClickListener {
            numBottunAction("1");
        }

        buttonTwo.setOnClickListener {
            numBottunAction("2");
        }

        buttonThree.setOnClickListener {
            numBottunAction("3");
        }

        buttonFour.setOnClickListener {
            numBottunAction("4");
        }

        buttonFive.setOnClickListener {
            numBottunAction("5");
        }

        buttonSix.setOnClickListener {
            numBottunAction("6");
        }

        buttonSeven.setOnClickListener {
            numBottunAction("7");
        }

        buttonEight.setOnClickListener {
            numBottunAction("8");
        }

        buttonNine.setOnClickListener {
            numBottunAction("9");
        }

        fun calculation(op : String?) :Int {
            return if (op == "+") {
                value + textArea.text.toString().toInt()
            } else if (op == "-") {
                value - textArea.text.toString().toInt()
            } else if (op == "*") {
                value * textArea.text.toString().toInt()
            } else if (op == "/") {
                value / textArea.text.toString().toInt()
            } else {
                textArea.text.toString().toInt()
            }
        }

        fun calcBottunAction(op : String?) {

            if (calc == true) {
                value = calculation(operator)
                clear = true
                calc = false
                textArea.text = value.toString()
            }
            operator = op
        }

        buttonAdd.setOnClickListener {
            calcBottunAction("+")
        }

        buttonMul.setOnClickListener {
            calcBottunAction("*")
        }

        buttonSub.setOnClickListener {
            calcBottunAction("-")
        }

        buttonDiv.setOnClickListener {
            calcBottunAction("/")
        }

        buttonEqual.setOnClickListener {
            if (calc == true) {
                value = calculation(operator)
                calc = false
                clear = true
                textArea.text = value.toString()
                operator = null
            }
        }
    }
}