package com.example.caculate

import android.content.Context
import android.content.pm.ActivityInfo
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.res.Configuration


class MainActivity : AppCompatActivity(), View.OnClickListener {

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
        val btn_percent: Button = findViewById(R.id.button_percent)
        val btn_clear: Button = findViewById(R.id.button_clear)
        val btn_del: Button = findViewById(R.id.button_del)
        val btn_left_bracket: Button = findViewById(R.id.button_left)
        val btn_right_bracket: Button = findViewById(R.id.button_right)
        val btn_divide: Button = findViewById(R.id.button_div)
        val btn_multiple: Button = findViewById(R.id.button_mul)
        val btn_minus: Button = findViewById(R.id.button_sub)
        val btn_add: Button = findViewById(R.id.button_add)
        val btn_point: Button = findViewById(R.id.button_point)
        val btn_equal: Button = findViewById(R.id.button_equal)

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
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //横屏
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val btn_PI:Button = findViewById(R.id.button_PI)
            val btn_square:Button=findViewById(R.id.button_square)
            val btn_cube:Button=findViewById(R.id.button_cube)
            val btn_genhao:Button=findViewById(R.id.button_genhao)
            val btn_sin:Button=findViewById(R.id.button_sin)
            val btn_cos:Button=findViewById(R.id.button_cos)
            val btn_tan:Button=findViewById(R.id.button_tan)
            val btn_ln:Button=findViewById(R.id.button_ln)
            val btn_log: Button = findViewById(R.id.button_log)
            btn_PI.setOnClickListener(this)
            btn_square.setOnClickListener(this)
            btn_cube.setOnClickListener(this)
            btn_genhao.setOnClickListener(this)
            btn_sin.setOnClickListener(this)
            btn_cos.setOnClickListener(this)
            btn_tan.setOnClickListener(this)
            btn_ln.setOnClickListener(this)
            btn_log.setOnClickListener(this)

        }
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
                button_percent -> {
                    content.setText(str + "%")

                }
                button_left -> {
                    content.setText(str + "(")

                }
                button_right -> {
                    content.setText(str + ")")

                }
                button_div -> {
                    content.setText(str + "/")
                    count = 0
                }
                button_mul -> {
                    content.setText(str + "*")
                    count = 0
                }
                button_sub -> {
                    content.setText(str + "-")
                    count = 0
                }
                button_add -> {
                    content.setText(str + "+")
                    count = 0
                }
                button_PI -> {
                    content.setText(str + "∏")
                }
                button_genhao -> {
                    content.setText(str + "√(")
                }
                button_square -> {
                    content.setText(str + "²")
                }
                button_cube -> {
                    content.setText(str + "³")
                }
                button_ln -> {
                    content.setText(str + "㏑(")
                }
                button_log -> {
                    content.setText(str + "㏒(")

                }
                button_sin ->{
                    content.setText(str + "sin(")
                }
                button_cos ->{
                    content.setText(str + "cos(")
                }
                button_tan ->{
                    content.setText(str + "tan(")
                }
                //小数点
                button_point -> {
                    if (str != "" && count == 0) {
                        content.setText(str + ".")
                        count = 1
                    } else {
                        content.setText("ERROR")
                        return
                    }
                }
                //等于按钮
                button_equal -> {
                    var calculator: Calculator = Calculator()
                    var result: Double = calculator.Eval(content.text.toString())
                    content.setText(result.toString())

                }
                //清空按钮
                button_clear -> {
                    content.setText("")
                    count = 0
                }
                //后退按钮
                button_del -> {
                    if (TextUtils.isEmpty((content.text))) {
                        return
                    }
                    content.setText(str.substring(0, str.length - 1))
                    count = 0
                }
            }
        }
    }

    //创建菜单，加载menu_main.xml文件
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_exit -> {
                finish()
                return true
            }
            R.id.menu_help -> {
                Toast.makeText(this, "这是帮助文档", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }



}



