package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button clear,memPlus, memory, delete, seven,eight,nine,divide,four,five,
            six,mul,one,two,three,sub,zero,dot,equal,plus;

    TextView res,inputStr;
    boolean firstNumIn = false,firstAction = false,firstValueIn = false,afterEqualOperation = false,divideByZero = false;
    String sign = "",inputString = "";
    Double val1 = 0.0;
    Double val2 = 0.0;
    Double memAns = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputStr = findViewById(R.id.resultString);
        res = findViewById(R.id.result);
        clear = findViewById(R.id.clear);
        memPlus = findViewById(R.id.mem_plus);
        memory = findViewById(R.id.mem);
        delete = findViewById(R.id.del);
        seven = findViewById(R.id.num7);
        eight = findViewById(R.id.num8);
        nine = findViewById(R.id.num9);
        divide = findViewById(R.id.div);
        four = findViewById(R.id.num4);
        five = findViewById(R.id.num5);
        six = findViewById(R.id.num6);
        mul = findViewById(R.id.mul);
        one = findViewById(R.id.num1);
        two = findViewById(R.id.num2);
        three = findViewById(R.id.num3);
        sub = findViewById(R.id.sub);
        zero = findViewById(R.id.num0);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        plus = findViewById(R.id.add);

        res.setText("0");
        inputStr.setText("");
        firstNumIn = true;
        firstAction = true;

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber(v);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber(v);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber(v);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNumber(v);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               printNumber(v);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calculateRes(v);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               calculateRes(v);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRes(v);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRes(v);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!firstAction){
                    res.setText("0.");
                    inputString += "0."; //last change working
                    firstNumIn = false;
                }else{
                    //last changes working correctly
                    if(inputString == ""){
                        res.setText("0.");
                        inputString += "0."; //last change working
                        firstNumIn = false;
                    }else {
                        res.setText(String.format("%s%s", res.getText().toString(), "."));
                        inputString += "."; //last change working
                    }
                }
                inputStr.setText(inputString);
            }
        });
        memPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(afterEqualOperation){
                    memAns += val1;
                }
            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText(String.valueOf( new DecimalFormat("#.##").format(memAns)));
                inputString = res.getText().toString();
                inputStr.setText(inputString);
                memAns = 0.0;
                afterEqualOperation = false;
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputString += "=";
                inputStr.setText(inputString);
                if(firstAction){
                    val2 = Double.valueOf(res.getText().toString());
                    Log.d("calculator " ,"value 2 when equal pressed  "+ val2);
                    if(firstValueIn){
                        if (sign == "+")
                            val1 += val2;
                        else if(sign=="-")
                            val1 -= val2;
                        else if(sign=="*")
                            val1 *= val2;
                        else if(sign=="/"){
                            if(val2 == 0.0) {
                                Log.d("calculator " ,"value 2 when equal pressed is 0  "+ val2);
                                //res.setText("Cannot divide by 0");
                                divideByZero = true;
                            }
                            else
                                val1 /= val2;
                        }
                        Log.d("calculator " ,"final result "+ Double.toString(val1));
                        if(divideByZero){
                            res.setText(String.valueOf("Cannot divide by zero"));
                            divideByZero = false;
                        }
                        else
                            res.setText(String.valueOf( new DecimalFormat("#.##").format(val1)));
                    }else
                        res.setText(res.getText());
                }
                else
                    res.setText("Error Entering Inputs");
                firstNumIn = true;
                firstValueIn = false;
                afterEqualOperation = true;
                inputString = "";
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String resStr = res.getText().toString();
               if(resStr.length() >= 1 && resStr != "0" && inputString != "" ){
                   inputString = inputString.substring(0,inputString.length()-1);
                   inputStr.setText(inputString);
                   if(resStr.length() == 1) {
                       res.setText("0");
                   }
                   else
                       res.setText(resStr.substring(0,resStr.length()-1));
               }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.setText("0");
                inputStr.setText("");
                inputString = "";
                if(val1 != 0.0)
                    val1 = 0.0;
                firstNumIn = true;
                firstAction = true;
            }
        });
    }
    private void printNumber(View v){
        if(res.getText() == "0")
            res.setText("");
        if(firstNumIn){
            if(v == one){
                res.setText("1");
                inputString += "1";
            } else if(v == two){
                res.setText("2");
                inputString += "2";
            } else if(v == three){
                res.setText("3");
                inputString += "3";
            } else if(v == four) {
                res.setText("4");
                inputString += "4";
            } else if(v == five) {
                res.setText("5");
                inputString += "5";
            } else if(v == six) {
                res.setText("6");
                inputString += "6";
            } else if(v == seven) {
                res.setText("7");
                inputString += "7";
            } else if(v == eight) {
                res.setText("8");
                inputString += "8";
            } else if(v == nine) {
                res.setText("9");
                inputString += "9";
            } else if(v == zero) {
                res.setText("0");
                inputString += "0";
            }
            firstNumIn = false;
        }else{
            if(v == one) {
                res.setText(String.format("%s%s", res.getText().toString(), "1"));
                inputString += "1";
            }
            else if(v == two) {
                res.setText(String.format("%s%s", res.getText().toString(), "2"));
                inputString += "2";
            }
            else if(v == three) {
                res.setText(String.format("%s%s", res.getText().toString(), "3"));
                inputString += "3";
            }
            else if(v == four) {
                res.setText(String.format("%s%s", res.getText().toString(), "4"));
                inputString += "4";
            }
            else if(v == five) {
                res.setText(String.format("%s%s", res.getText().toString(), "5"));
                inputString += "5";
            }
            else if(v == six) {
                res.setText(String.format("%s%s", res.getText().toString(), "6"));
                inputString += "6";
            }
            else if(v == seven) {
                res.setText(String.format("%s%s", res.getText().toString(), "7"));
                inputString += "7";
            }
            else if(v == eight) {
                res.setText(String.format("%s%s", res.getText().toString(), "8"));
                inputString += "8";
            }
            else if(v == nine) {
                res.setText(String.format("%s%s", res.getText().toString(), "9"));
                inputString += "9";
            }
            else if(v == zero) {
                res.setText(String.format("%s%s", res.getText().toString(), "0"));
                inputString += "0";
            }
        }
        firstAction = true;
        inputStr.setText(inputString);
        afterEqualOperation = false;
    }
    private void calculateRes (View v){
        if(afterEqualOperation) {
            inputString = val1.toString();
            afterEqualOperation = false;
        }
        if(firstAction){
            firstAction = false;
            if(!firstValueIn){
                firstValueIn = true;
                val1 = Double.valueOf(res.getText().toString());
            }else{
                val2 = Double.valueOf(res.getText().toString());
                Log.d("calculator " ,"value 2 is  "+ Double.toString(val2));
                if(sign == "+"){
                    val1 += val2;
                    Log.d("calculator " ,"summation "+ Double.toString(val1));
                }
                else if(sign == "-"){
                    val1 -= val2;
                    Log.d("calculator " ,"subtraction "+ Double.toString(val1));
                }
                else if(sign == "*"){
                    val1 *= val2;
                    Log.d("calculator " ,"multiplication "+ Double.toString(val1));
                }
                else if(sign == "/"){
                    if(val2 == 0.0)
                        res.setText("Cannot Divide by 0");
                    else
                        val1 /= val2;
                    Log.d("calculator " ,"division "+ Double.toString(val1));
                }
            }
            if(v == plus){
                sign = "+";
                inputString += "+";
            }else if(v == sub){
                sign = "-";
                inputString += "-";
            }else if(v == mul){
                sign = "*";
                inputString += "*";
            }else if(v == divide){
                sign = "/";
                inputString += "/";
            }
            inputStr.setText(inputString);
        }
        res.setText(String.valueOf( new DecimalFormat("#.##").format(val1)));
        firstNumIn = true;
    }
}
