package com.example.calulatorapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAC, btnPercent, btnDelete,
                   btnDivide,btnMul, btnAdd, btnSub, btnEqual,
                   btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot;
    private TextView txtContent, txtResult;
    private long lastClickTime = 0;
    private final char ADDTION = '+';
    private final char SUBTION = '-';
    private final char DIVTION = '/';
    private final char MULTION = 'x';
    private final char EQU = 0;

    private double value1 = Double.NaN;
    private  double value2;

    private char ACTION;

    private ArrayList<String> arrayNumber;
    private ArrayList<String> arrayOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btnAC = findViewById(R.id.btn_AC);
        btnPercent = findViewById(R.id.btn_percent);
        btnDelete = findViewById(R.id.btn_rightAC);
        btnAdd = findViewById(R.id.btn_add);
        btnDivide = findViewById(R.id.btn_divide);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnDot = findViewById(R.id.btn_dot);
        btnEqual = findViewById(R.id.btn_equal);
        txtContent = findViewById(R.id.txt_input);
        txtResult = findViewById(R.id.txt_output);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);



        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDivide.setOnClickListener(this);

        btnAC.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_0:
                txtContent.append("0");
//
                break;
            case R.id.btn_1:
                txtContent.append("1");
                break;
            case R.id.btn_2:
                txtContent.append("2");
                break;
            case R.id.btn_3:
                txtContent.append("3");
                break;
            case R.id.btn_4:
                txtContent.append("4");
                break;
            case R.id.btn_5:
                txtContent.append("5");
                break;
            case R.id.btn_6:
                txtContent.append("6");
                break;
            case R.id.btn_7:
                txtContent.append("7");
                break;
            case R.id.btn_8:
                txtContent.append("8");
                break;
            case R.id.btn_9:
                txtContent.append("9");
                break;
            case R.id.btn_dot:
                txtContent.append(".");
                break;
            case R.id.btn_add:
                 compute();
                 ACTION = ADDTION;
                 txtResult.setText(String.valueOf(value1));
                 txtContent.setText(null);
                 break;


            case R.id.btn_sub:
                compute();
                ACTION = SUBTION;
                txtResult.setText(String.valueOf(value1));
                txtContent.setText(null);

                break;
            case R.id.btn_mul:
                compute();
                ACTION = MULTION;
                txtResult.setText(String.valueOf(value1));
                txtContent.setText(null);
                break;
            case R.id.btn_divide:
                compute();
                ACTION = DIVTION;
                txtResult.setText(String.valueOf(value1));
                txtContent.setText(null);

                break;
            case R.id.btn_equal:
                compute();
                ACTION = EQU;
                txtResult.setText( String.valueOf(value1));
                value2 = value1;
                txtContent.setText(null);
                txtContent.setText("0");

                break;
            case R.id.btn_AC:

                   value1 = Double.NaN;
                   value2 = Double.NaN;
                   txtContent.setText(null);
                   txtResult.setText(null);
                   break;
            case R.id.btn_rightAC:
                if (txtContent.getText().length()>0){
                        String name = txtContent.getText().toString();
                        txtContent.setText(name.substring(0,name.length()-1));
                }
                break;

        }
    }

    public void compute(){
        if (!Double.isNaN(value1)){
//            if (txtContent.getText() != "") {
                value2 = Double.parseDouble(txtContent.getText().toString());
//            }else{
//                value2 = Double.parseDouble(txtResult.getText().toString());
//            }
            switch (ACTION){
                case ADDTION:
                    value1 = value1 + value2;
                    break;
                case SUBTION:
                    value1 = value1 - value2;
                    break;
                case MULTION:
                    value1 = value1 * value2;
                    break;
                case DIVTION:
                    value1 = value1 / value2;
                    break;
                case EQU:
                    break;

            }
        }
        else {
            value1 = Double.parseDouble(txtContent.getText().toString());
        }
    }







}
