package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1:android.widget.Button
    lateinit var button2:android.widget.Button
    lateinit var button3:android.widget.Button
    lateinit var button4:android.widget.Button
    lateinit var button5:android.widget.Button
    lateinit var button6:android.widget.Button
    lateinit var button7:android.widget.Button
    lateinit var button8:android.widget.Button
    lateinit var button9:android.widget.Button
    lateinit var button0:android.widget.Button
    lateinit var button00:android.widget.Button
    lateinit var buttonpercentage:android.widget.Button
    lateinit var buttonclear:android.widget.Button
    lateinit var buttondot:android.widget.Button
    lateinit var buttonequal:android.widget.Button
    lateinit var buttonplus:android.widget.Button
    lateinit var buttonminus:android.widget.Button
    lateinit var buttonmultiply:android.widget.Button
    lateinit var buttondivide:android.widget.Button
    lateinit var buttonbackspace:android.widget.Button
    lateinit var inputtext:EditText
    lateinit var resulttext:EditText
    var check=0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0=findViewById(R.id.button0)
        button1=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        button3=findViewById(R.id.button3)
        button4=findViewById(R.id.button4)
        button5=findViewById(R.id.button5)
        button6=findViewById(R.id.button6)
        button7=findViewById(R.id.button7)
        button8=findViewById(R.id.button8)
        button9=findViewById(R.id.button9)
        button0=findViewById(R.id.button0)
        button00=findViewById(R.id.button00)
        buttonpercentage=findViewById(R.id.buttonpercentage)
        buttonclear=findViewById(R.id.buttonclear)
        buttondot=findViewById(R.id.buttondot)
        buttonequal=findViewById(R.id.buttonequal)
        buttonplus=findViewById(R.id.buttonplus)
        buttonminus=findViewById(R.id.buttonminus)
        buttonmultiply=findViewById(R.id.buttonmultiply)
        buttondivide=findViewById(R.id.buttondivide)
        buttonbackspace=findViewById(R.id.buttonbackspace)
        inputtext=findViewById(R.id.inputnumber)
        resulttext=findViewById(R.id.result)
        inputtext.movementMethod=ScrollingMovementMethod()
        inputtext.isActivated = true
        inputtext.setPressed(true)

        var text: String
        button1.setOnClickListener {
            text=inputtext.text.toString()+"1"
            inputtext.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text=inputtext.text.toString()+"2"
            inputtext.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text=inputtext.text.toString()+"3"
            inputtext.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text=inputtext.text.toString()+"4"
            inputtext.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text=inputtext.text.toString()+"5"
            inputtext.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text=inputtext.text.toString()+"6"
            inputtext.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text=inputtext.text.toString()+"7"
            inputtext.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text=inputtext.text.toString()+"8"
            inputtext.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text=inputtext.text.toString()+"9"
            inputtext.setText(text)
            result(text)
        }
        button00.setOnClickListener {
            text=inputtext.text.toString()+"00"
            inputtext.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text=inputtext.text.toString()+"0"
            inputtext.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text=inputtext.text.toString()+"."
            inputtext.setText(text)
            result(text)
        }

        buttonplus.setOnClickListener {
            text=inputtext.text.toString()+"+"
            inputtext.setText(text)
            check=check+1
        }
        buttonminus.setOnClickListener {
            text=inputtext.text.toString()+"-"
            inputtext.setText(text)
            check=check+1
        }
        buttonmultiply.setOnClickListener {
            text=inputtext.text.toString()+"*"
            inputtext.setText(text)
            check=check+1
        }
        buttondivide.setOnClickListener {
            text=inputtext.text.toString()+"/"
            inputtext.setText(text)
            check=check+1
        }
        buttonpercentage.setOnClickListener {
            text=inputtext.text.toString()+"%"
            inputtext.setText(text)
            check=check+1
        }
        buttonequal.setOnClickListener {
            text=resulttext.text.toString()
            inputtext.setText(text)
            resulttext.setText(null)

        }
        buttonclear.setOnClickListener {
            inputtext.setText(null)
            resulttext.setText(null)
        }

        buttonbackspace.setOnClickListener {
            var backspace:String?=null

              if(inputtext.text.length>0){
                  val stringBuilder:StringBuilder= StringBuilder(inputtext.text)
                  val find=inputtext.text.toString()
                  val find2=find.last()

                   if(find2.equals('+')||find2.equals('-')||find2.equals('/')||find2.equals('*')||find2.equals('%')){
                       check=check-1
                   }
                  stringBuilder.deleteCharAt(inputtext.text.length-1)
                  backspace=stringBuilder.toString()
                  inputtext.setText(backspace)
              }
        }
















    }

    private fun result(text: String) {

        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any=engine.eval(text)
            var mainr=result.toString()
            if(check==0){
                resulttext.setText(null)
            }
            else{
                resulttext.setText(mainr)
            }
        }
        catch(e:ScriptException){
            Log.d("TAG","Error")
        }

    }


}
