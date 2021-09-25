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
        val btn_percent: Button = findViewById(R.id.button51)
        val btn_clear: Button = findViewById(R.id.button11)
        val btn_del: Button = findViewById(R.id.button14)
        val btn_left_bracket: Button = findViewById(R.id.button12)
        val btn_right_bracket: Button = findViewById(R.id.button13)
        val btn_divide: Button = findViewById(R.id.button54)
        val btn_multiple: Button = findViewById(R.id.button44)
        val btn_minus: Button = findViewById(R.id.button34)
        val btn_add: Button = findViewById(R.id.button24)
        val btn_point: Button = findViewById(R.id.button53)
        val btn_equal: Button = findViewById(R.id.button64)


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

    }

    private var count: Int = 0//对小数点进行计数，最多只能有一个小数点

    //onclick()方法，触发onClickListener接口
    override fun onClick(view: View?) {
        var str: String = content.text.toString()//获取当前文本框的内容

        //分别获取按钮的内容到文本编辑框
        if (view != null) {
            when (view) {
                num0 -> {
                    content.setText(str + "0")
                }
                num1 -> {
                    content.setText(str + "1")

                }
                num2 -> {
                    content.setText(str + "2")

                }
                num3 -> {
                    content.setText(str + "3")

                }
                num4 -> {
                    content.setText(str + "4")

                }
                num5 -> {
                    content.setText(str + "5")

                }
                num6 -> {
                    content.setText(str + "6")

                }
                num7 -> {
                    content.setText(str + "7")

                }
                num8 -> {
                    content.setText(str + "8")

                }
                num9 -> {
                    content.setText(str + "9")

                }
                // %
                button51 -> {
                    content.setText(str + "%")

                }
                button12 -> {
                    content.setText(str + "(")

                }
                button13 -> {
                    content.setText(str + ")")

                }
                button54 -> {
                    content.setText(str + "/")
                    count = 0
                }
                button44 -> {
                    content.setText(str + "*")
                    count = 0
                }
                button34 -> {
                    content.setText(str + "-")
                    count = 0
                }
                button24 -> {
                    content.setText(str + "+")
                    count = 0
                }

                //小数点
                button53 -> {
                    if (str != "" && count == 0) {
                        content.setText(str + ".")
                        count = 1
                    } else {
                        content.setText("ERROR")
                        return
                    }
                }
                //等于按钮
                button64 -> {
                    var calculator: Calculator = Calculator()
                    var result: Double = calculator.Eval(content.text.toString())
                    content.setText(result.toString())

                }
                //清空按钮
                button11 -> {
                    content.setText("")
                    count = 0
                }
                //后退按钮
                button14 -> {
                    if (TextUtils.isEmpty((content.text))) {
                        return
                    }
                    content.setText(str.substring(0, str.length - 1))
                    count = 0
                }


            }
        }
    }
}



