package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void numSelected(View v){
        int numInp = 0;
        TextView result = findViewById(R.id.resultText);
        String currText = result.getText().toString();
        if(v.getId() == R.id.oneButton){
            numInp = 1;
        }else if(v.getId() == R.id.twoButton){
            numInp = 2;
        }else if(v.getId() == R.id.threeButton){
            numInp = 3;
        }else if(v.getId() == R.id.fourButton){
            numInp = 4;
        }else if(v.getId() == R.id.fiveButton){
            numInp = 5;
        }else if(v.getId() == R.id.sixButton){
            numInp = 6;
        }else if(v.getId() == R.id.sevenButton){
            numInp = 7;
        }else if(v.getId() == R.id.eightButton){
            numInp = 8;
        }else if(v.getId() == R.id.nineButton){
            numInp = 9;
        }else if(v.getId() == R.id.zeroButton){
            numInp = 0;
        }else if(v.getId() == R.id.clearButton){
            result.setText("");
        }else if(v.getId() == R.id.changeSign){
            numInp *= -1;
        }
        //multiplication:
        //set var 1 and var 2
        //on equals press or different operator press return result
        result.setText(currText + numInp);
    }
}