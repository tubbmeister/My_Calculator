package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.text.SpannableStringBuilder;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mycalculator.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    Button ZeroBtn;
    EditText EditTextCalculator;
    TextView previousCalcTxt,textView3;
    boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previousCalcTxt=findViewById(R.id.previousCalcTxt);
        textView3=findViewById(R.id.textView3);
        EditTextCalculator = findViewById(R.id.EditTextCalculator);
        EditTextCalculator.setShowSoftInputOnFocus(false);
        EditTextCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(EditTextCalculator.getText().toString())) {

                    EditTextCalculator.setText("");
                }

            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = EditTextCalculator.getText().toString();
        int cursorPos = EditTextCalculator.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr =oldStr.substring(cursorPos);


            EditTextCalculator.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            EditTextCalculator.setSelection(cursorPos+strToAdd.length());


    }
    public void FuelCheckMessage (View view) {

        Intent intent = new Intent(this, FuelCheckActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
       // String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);



    }

    public void zero_BTN_click(View v){
        //stuff
        //  EditTextCalculator.setText("Hello");
        updateText("0");
    }
    public void One_BTN(View v){
        updateText("1");

    }
    public void Point_BTN(View v){
        updateText(".");

    }
    public void Two_BTN(View v){
        updateText("2");
    }
    public void Three_BTN(View v){
        updateText("3");
    }
    public void Four_BTN(View v){
        updateText("4");
    }
    public void Five_BTN(View v){
        updateText("5");
    }
    public void Six_BTN(View v){
        updateText("6");
    }
    public void Seven_BTN(View v){
        updateText("7");
    }
    public void Eight_BTN(View v){
        updateText("8");
    }
    public void Nine_BTN(View v){
        updateText("9");
    }
    public void Multiply_BTN(View v){
        updateText("×");

    }
    public void Exponent_BTN(View v){
        updateText("^");

    }
    public void PlusMin_BTN(View v){
        updateText("-");

    }
    public void ParOpenBTN(View v){
        updateText("(");

    }
    public void ParCloseBTN(View v){
        updateText(")");

    }
    public void Par_BTN(View v) {
        int cursorPos = EditTextCalculator.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = EditTextCalculator.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (EditTextCalculator.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;

            }
            if (EditTextCalculator.getText().toString().substring(i, i + 1).equals(")")) {
                closedPar += 1;
            }
        }
        if (openPar == closedPar || EditTextCalculator.getText().toString().substring(textLen - 1, textLen).equals("(")) {


            updateText("(");

        }
        else if (closedPar < openPar && !EditTextCalculator.getText().toString().substring(textLen - 1, textLen).equals("(")){
            ;


            updateText(")");

        }
        EditTextCalculator.setSelection(cursorPos + 1);
    }
    public void Divide_BTN(View v){
        updateText("÷");

    }
    public void Add_BTN(View v){
        updateText("+");

    }
    public void Subtract_BTN(View v){
        updateText("-");

    }
    public void Equals_BTN(View v){

        String userExp =EditTextCalculator.getText().toString();

        try {
            String oldAnswer = userExp;
            userExp = userExp.replaceAll("÷", "/");
            userExp = userExp.replaceAll("×", "*");
            Expression exp = new Expression(userExp);
            String result = String.valueOf(exp.calculate());



        EditTextCalculator.setText(result);
        EditTextCalculator.setSelection(result.length());
        BigDecimal improvedAnswer = new BigDecimal(result).stripTrailingZeros(); //gets rid of zeros!
        String improvedAnswerString = improvedAnswer.toPlainString();
        previousCalcTxt.setText(improvedAnswerString);
        textView3.setText(oldAnswer);
        EditTextCalculator.setText("");
        answered=true;
        if (oldAnswer.isEmpty()){
            previousCalcTxt.setText("");
            textView3.setText("");
        }
        } catch (Exception e) {
            EditTextCalculator.setText("OOPS!  Check typing..");
            textView3.setText(userExp);
            previousCalcTxt.setText("");


        }
    }
    public void Backspace_BTN(View v){
        int cursorPos=EditTextCalculator.getSelectionStart();
        int textLen=EditTextCalculator.getText().length();

        if(cursorPos !=0 && textLen !=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) EditTextCalculator.getText();
            selection.replace(cursorPos -1,cursorPos,"");
            EditTextCalculator.setText(selection);
            EditTextCalculator.setSelection(cursorPos -1);
        }

    }
    public void Clear_BTN(View v){
        //updateText("");
        EditTextCalculator.setText("");
    }
    public void trigSinBtnPush(View view){
        updateText("sin(");

    }
    public void trigCosBtnPush(View view){
        updateText("cos(");

    }
    public void trigTanBtnPush(View view){
        updateText("tan(");

    }
    public void trigArcSinBtnPush(View view){
        updateText("arcsin(");

    }
    public void trigArcCosBtnPush(View view){
        updateText("arccos(");

    }
    public void trigArcTanBtnPush(View view){
        updateText("arctan(");

    }
    public void NatLogBtnPush(View view){
        updateText("ln(");

    }
    public void PiBtnPush(View view){
        updateText("pi");

    }
    public void LogTextBtnPush(View view){
        updateText("log10(");

    }
    public void SquareRootBtnPush(View view){
        updateText("sqrt(");

    }
    public void AbsValBtnPush(View view){
        updateText("abs(");

    }
    public void ETextBtnPush(View view){
        updateText("e");

    }
    public void XSquareBtnPush(View view){
        updateText("^(2)");

    }
    public void XPowerYBtnPush(View view){
        updateText("^(");

    }
    public void IsPrimeBtnPush(View view){
        updateText("ispr(");

    }

}