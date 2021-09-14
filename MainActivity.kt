package com.example.caculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //private lateinit var content : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //分别设置监听器
        val btn_0: Button = findViewById(R.id.num0)
        val btn_1: Button = findViewById(R.id.num1)
        val btn_2: Button = findViewById(R.id.num2)
        val btn_3: Button = findViewById(R.id.num3)
        val btn_4: Button = findViewById(R.id.num4)
        val btn_5: Button = findViewById(R.id.num5)
        val btn_6: Button = findViewById(R.id.num6)
        val btn_7: Button = findViewById(R.id.num7)
        val btn_8: Button = findViewById(R.id.num8)
        val btn_9: Button = findViewById(R.id.num9)
        val btn_percent: Button = findViewById(R.id.button12)
        val btn_clear: Button = findViewById(R.id.button13)
        val btn_del: Button = findViewById(R.id.button14)
        val btn_left_bracket: Button = findViewById(R.id.button22)
        val btn_right_bracket: Button = findViewById(R.id.button23)
        val btn_divide: Button = findViewById(R.id.button24)
        val btn_multiple: Button = findViewById(R.id.button34)
        val btn_minus: Button = findViewById(R.id.button44)
        val btn_add: Button = findViewById(R.id.button54)
        val btn_plusminus:Button = findViewById(R.id.button61)
        val btn_point: Button = findViewById(R.id.button63)
        val btn_equal: Button = findViewById(R.id.button64)
        val btn_sin : Button = findViewById(R.id.sin)
        val btn_cos : Button = findViewById(R.id.cos)
        val btn_square : Button = findViewById(R.id.square)
        val btn_sqrt : Button = findViewById(R.id.sqrt)

        //实例化按钮
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_percent.setOnClickListener(this)
        btn_clear.setOnClickListener(this)
        btn_del.setOnClickListener(this)
        btn_left_bracket.setOnClickListener(this)
        btn_right_bracket.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        btn_multiple.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
        btn_add.setOnClickListener(this)
        btn_point.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_plusminus.setOnClickListener(this)
        btn_sin.setOnClickListener(this)
        btn_cos.setOnClickListener(this)
        btn_square.setOnClickListener(this)
        btn_sqrt.setOnClickListener(this)
    }
    private var firstNumber: Double = 0.00//初始化第一次的取值
    private var secondNumber: Double = 0.00//初始化第二次的取值
    private var lastOperators: String = ""//记录上次计算结果
    private var lastIsOperator: Int = -1//记录当前是否进行计算操作，默认为0，不进行，1为进行
    private var count : Int = 0//对小数点进行计数，最多只能有一个小数点
    //onclick()方法，触发onClickListener接口
    override fun onClick(view: View?) {
        var str: String = content.text.toString()//获取当前文本框的内容
        var operatorNumber: String = "" //初始化操作数为“”
        if (str.isEmpty()) {//若当前输入数为null则设置文本框为“”
            content.setText("")
        }
        operatorNumber = content.text.toString()//根据文本框的内容更改操作
        if (!lastOperators.equals("")) run {
            var index: Int = operatorNumber.lastIndexOf(lastOperators)
            operatorNumber = operatorNumber.substring(index + 1)
        }

        //分别获取按钮的内容到文本编辑框
        if (view!=null){
            when (view) {
                num0 -> {
                    content.setText(str + "0")
                    lastIsOperator = 0
                }
                num1 -> {
                    content.setText(str + "1")
                    lastIsOperator = 0
                }
                num2 -> {
                    content.setText(str + "2")
                    lastIsOperator = 0
                }
                num3 -> {
                    content.setText(str + "3")
                    lastIsOperator = 0
                }
                num4 -> {
                    content.setText(str + "4")
                    lastIsOperator = 0
                }
                num5 -> {
                    content.setText(str + "5")
                    lastIsOperator = 0
                }
                num6 -> {
                    content.setText(str + "6")
                    lastIsOperator = 0
                }
                num7 -> {
                    content.setText(str + "7")
                    lastIsOperator = 0
                }
                num8 -> {
                    content.setText(str + "8")
                    lastIsOperator = 0
                }
                num9 -> {
                    content.setText(str + "9")
                    lastIsOperator = 0
                }
                button12 -> {

                    lastIsOperator = 1
                    secondNumber = 0.0
                    lastOperators = "%"
                    opratorCalc(operatorNumber, "%")
                    content.setText(firstNumber.toString())

                }
                button22 -> {
                    content.setText(str + "(")
                    lastIsOperator = 0
                    lastOperators = "("
                }
                button23 -> {
                    content.setText(str + ")")
                    lastIsOperator = 0
                    lastOperators = ")"
                }
                button24 -> {
                    opratorCalc(operatorNumber, "÷")
                    content.setText(str + "÷")
                    lastIsOperator = 1
                    lastOperators = "÷"

                }
                button34 -> {
                    opratorCalc(operatorNumber, "×")
                    content.setText(str + "×")
                    lastIsOperator = 1
                    lastOperators = "×"

                }
                button44 -> {
                    opratorCalc(operatorNumber, "-")
                    content.setText(str + "-")
                    lastIsOperator = 1
                    lastOperators = "-"
                }
                button54 -> {
                    opratorCalc(operatorNumber, "+")
                    content.setText(str + "+")
                    lastIsOperator = 1
                    lastOperators = "+"
                }
                //+/-
                button61 -> {
                        content.setText("${-str.toDouble()}")
                }
                //小数点
                button63 -> {
                    if(str != "" && count == 0){
                    content.setText(str + ".")
                        count=1
                    }
                    else{content.setText("ERROR")
                            return}
                    lastIsOperator = 0
                    //lastOperators = "."
                }
                //等于按钮
                button64 -> {
                    if (TextUtils.isEmpty(lastOperators)) {
                        return
                    }
                    opratorResult(operatorNumber)
//                    opratorCalc(operatorNumber, "=")
                    secondNumber = 0.0
                    lastOperators = "="
                    lastIsOperator = 1
                    content.setText(str + "=\n" + firstNumber)

                }
                //清空按钮
                button13 -> {
                    content.setText("")
                    lastIsOperator = 0
                    firstNumber = 0.0
                    secondNumber = 0.0
                    lastOperators = ""
                    count=0
                }
                //后退按钮
                button14 -> {
                    if (TextUtils.isEmpty((content.text))) {
                        return
                    }
                    content.setText(str.substring(0, str.length - 1))

                    lastIsOperator = 0
                }
                //函数
                sin ->{
                    lastIsOperator = 1
                    secondNumber = 0.0
                    lastOperators = "sin"
                    opratorCalc(operatorNumber, "sin")
                    content.setText(firstNumber.toString())
                }
                cos ->{
                    lastIsOperator = 1
                    secondNumber = 0.0
                    lastOperators = "cos"
                    opratorCalc(operatorNumber, "cos")
                    content.setText(firstNumber.toString())
                }
                square ->{
                    lastIsOperator = 1
                    secondNumber = 0.0
                    lastOperators = "square"
                    opratorCalc(operatorNumber, "square")
                    content.setText(firstNumber.toString())
                }
                sqrt ->{
                    lastIsOperator = 1
                    secondNumber = 0.0
                    lastOperators = "sqrt"
                    opratorCalc(operatorNumber, "sqrt")
                    content.setText(firstNumber.toString())
                }

            }
        }
    }


    //运算函数
    private fun operate(operatorNumber: String) {
        if (secondNumber?.equals(0.0)) {//第二个数不为零
            if (lastOperators.equals("+")) {
                secondNumber = operatorNumber.toDouble()
                firstNumber += secondNumber
            } else if (lastOperators == "-") {
                secondNumber = operatorNumber.toDouble()
                firstNumber -= secondNumber
            } else if (lastOperators == "×") {
                secondNumber = operatorNumber.toDouble()
                firstNumber *= secondNumber
            } else if (lastOperators == "÷") {
                secondNumber = operatorNumber.toDouble()
                firstNumber /= secondNumber
            }
        } else {//第二个数为零
            if (lastOperators == "+") {
                firstNumber += operatorNumber.toDouble()
            }
            else if (lastOperators == "-") {
                firstNumber -= operatorNumber.toDouble()
            }
            else if (lastOperators == "×") {
                firstNumber *= operatorNumber.toDouble()
            }
            else if (lastOperators == "÷") {
                firstNumber /= operatorNumber.toDouble()
            }
            else if (lastOperators == "=") {
                firstNumber = operatorNumber.toDouble()
            }
//            else if (lastOperators == "%"){
//                firstNumber = operatorNumber.toDouble()*0.01
//            }
//            else if (lastOperators == "sin"){
//                firstNumber = Math.sin(operatorNumber.toDouble())
//            }
//            else if (lastOperators == "cos"){
//                firstNumber = Math.cos(operatorNumber.toDouble())
//            }
        }
    }

    //返回计算结果
    private fun opratorResult(operatorNumber: String) {
        operate(operatorNumber)
    }

    //按当前计算结果进行下一次的数据输入及计算
    fun opratorCalc(operatorNumber: String, currentOprator: String) {
        if (TextUtils.isEmpty(lastOperators)) {
            firstNumber = operatorNumber.toDouble()
            return
        }
        if(lastOperators.equals(currentOprator)){
            if(lastOperators == "÷"){
                firstNumber /= operatorNumber.toDouble()
            }
            else if(lastOperators == "×"){
                firstNumber *= operatorNumber.toDouble()
            }
            else if(lastOperators == "+"){
                firstNumber += operatorNumber.toDouble()
            }
            else if(lastOperators == "-"){
                firstNumber -= operatorNumber.toDouble()
            }
            else if (lastOperators == "%"){
                firstNumber = operatorNumber.toDouble()*0.01
            }
            else if (lastOperators == "sin"){
                firstNumber = Math.sin(operatorNumber.toDouble())
            }
            else if (lastOperators == "cos"){
                firstNumber = Math.cos(operatorNumber.toDouble())
            }
            else if (lastOperators == "square"){
                firstNumber = operatorNumber.toDouble()*operatorNumber.toDouble();
            }
            else if (lastOperators == "sqrt"){
                firstNumber = Math.sqrt(operatorNumber.toDouble())
            }
            return
        }
        operate(operatorNumber)
    }
}



