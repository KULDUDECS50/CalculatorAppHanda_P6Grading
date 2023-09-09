package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numInp = 0;
    private String var1 = "";
    private String var2 = "";
    private String operation = "";
    private Boolean equation = false;
    private String resString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void numSelected(View v){

        TextView resultView = findViewById(R.id.resultText);
        String currText = resultView.getText().toString();
        if(currText.equals("0")){
            currText = "";
        }
        //multiplication:
        if(v.getId() == R.id.oneButton){
            resString = currText + 1;
        }else if(v.getId() == R.id.twoButton){
            resString = currText + 2;
        }else if(v.getId() == R.id.threeButton){
            resString = currText + 3;
        }else if(v.getId() == R.id.fourButton){
            resString = currText + 4;
        }else if(v.getId() == R.id.fiveButton){
            resString = currText + 5;
        }else if(v.getId() == R.id.sixButton){
            resString = currText + 6;
        }else if(v.getId() == R.id.sevenButton){
            resString = currText + 7;
        }else if(v.getId() == R.id.eightButton){
            resString = currText + 8;
        }else if(v.getId() == R.id.nineButton){
            resString = currText + 9;
        }else if(v.getId() == R.id.zeroButton){
            resString = currText + 0;
        } else if(v.getId() == R.id.piButton){
            resString = currText + "π";
        }else if(v.getId() == R.id.clearButton){
            resString = "";
            Log.i("msg", "cleared");
        }else if(v.getId() == R.id.changeSign){
            double d = Double.parseDouble(currText) * -1;
            if(d % 1 == 0) resString = (int)d + "";
            else resString = d + "";
        }else if(v.getId() == R.id.decimalButton){
            if(!currText.contains(".")){
                if(currText.equals("")) resString = currText + "0.";
                else resString = currText + ".";
            }
        }else{
            if(!equation){
                equation = true;
                var1 = currText;
                resString = "";
            }
            if(v.getId() == R.id.multiplyButton){
                operation = "multiply";
            }else if(v.getId() == R.id.divideButton){
                operation = "divide";
            }else if(v.getId() == R.id.plusButton){
                operation = "add";
            } else if(v.getId() == R.id.minusButton) {
                    operation = "subtract";
            }else if(v.getId() == R.id.percentButton) {
                operation = "modulo";
            }
        }
        if(v.getId() == R.id.equalsButton){
            if(equation){
                var2 = currText;
                Log.i("msg", "Var1: " + var1 + ", Var 2: " + var2 + ", Opeartor: " + operation);
                resString = equate(var1, var2, operation);
                equation = false;
            }
        }
        //set var 1 and var 2
        //on equals press or different operator press return result
        resultView.setText(resString);
    }
    public String equate (String v1, String v2, String operation){
        if(v1.equals("") || v2.equals("") || operation.equals("")) return v1;
        if(v1.contains("π")){
            double num = Double.parseDouble(v1.replace("π", ""));
            v1 = num * Math.PI + "";
        }
        if(v2.equals("π")){
            double num = Double.parseDouble(v2.replace("π", ""));
            v2 = num * Math.PI + "";
        }
        double var1 = Double.parseDouble(v1);
        double var2 = Double.parseDouble(v2);
        double numResult = 0.0;
        String result = "";
        Log.i("msg", "Var1: " + var1 + ", Var 2: " + var2 + ", Opeartor: " + operation);
        if(operation.equals("multiply")){
            numResult = var1 * var2;
            Log.i("msg", "Result: " + numResult);
        }
        else if(operation.equals("divide")){
            numResult = var1 / var2;
        }
        else if(operation.equals("add")){
            numResult = var1 + var2;
        }
        else if(operation.equals("subtract")){
            numResult = var1 - var2;
        }
        else if(operation.equals("modulo")){
            numResult = var1 % var2;
            Log.i("msg", "DoubleRes: " + 6 % 5);
        }
        numResult = Math.floor(numResult * 100000) / 100000;
        if(numResult % 1 == 0){
            result = (int)(numResult) + "";
            Log.i("msg", "Int: " + numResult);
        }else{
            result = numResult + "";
        }
        return result;
    }
}