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
        }else if(v.getId() == R.id.clearButton){
            resString = "";
            Log.i("msg", "cleared");
        }else if(v.getId() == R.id.changeSign){
            Double d = Double.parseDouble(currText) * -1;
            resString = d + "";
        }else if(v.getId() == R.id.decimalButton){
            resString = currText + ".";
        }else if(v.getId() == R.id.multiplyButton){
            operation = "multiply";
            if(!equation){
                equation = true;
                var1 = currText;
                resString = "";
            }
        }else if(v.getId() == R.id.divideButton){
            operation = "divide";if(!equation){
                equation = true;
                var1 = currText;
                resString = "";
            }
        }else if(v.getId() == R.id.plusButton){
            operation = "add";
            if(!equation){
                equation = true;
                var1 = currText;
                resString = "";
            }
        } else if(v.getId() == R.id.minusButton){
            operation = "subtract";
            if(!equation){
                equation = true;
                var1 = currText;
                resString = "";
            }
        } else if(v.getId() == R.id.equalsButton){
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
        double var1 = Double.parseDouble(v1);
        double var2 = Double.parseDouble(v2);
        double numResult = 0.0;
        String result = "";
        Log.i("msg", "Var1: " + var1 + ", Var 2: " + var2 + ", Opeartor: " + operation);
        if(operation.equals("multiply")){
            numResult = Math.floor((var1 * var2) * 1000) / 1000;
            Log.i("msg", "Result: " + numResult);
        }
        else if(operation.equals("divide")){
            numResult = Math.floor((var1 / var2) * 1000) / 1000;
        }
        else if(operation.equals("add")){
            numResult = var1 + var2;
        }
        else if(operation.equals("subtract")){
            numResult = var1 - var2;
        }
        if(numResult % 1 == 0){
            result = (int)(numResult) + "";
            Log.i("msg", "Int: " + numResult);
        }else{
            result = numResult + "";
        }
        return result;
    }
}