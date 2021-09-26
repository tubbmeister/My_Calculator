package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class FuelCheckActivity extends AppCompatActivity implements View.OnClickListener {


    EditText TotalFuelEdit, TopLineEdit,BottomLineEdit,TopLineAnswer, BottomLineAnswer,LeftTank,CenterTank,RightTank;
    Button CalcFuelBtn,TotalBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_check);


        LeftTank=findViewById(R.id.LeftTank);
        CenterTank=findViewById(R.id.CentreTank);
        RightTank=findViewById(R.id.RightTank);

        TotalFuelEdit=findViewById(R.id.TotalFuelEdit);
        TopLineEdit=findViewById(R.id.TopLineEdit);
        BottomLineEdit=findViewById(R.id.BottomLineEdit);
        TopLineAnswer=findViewById(R.id.TopLineAnswer);
        BottomLineAnswer=findViewById(R.id.BottomLineAnswer);
        CalcFuelBtn=findViewById(R.id.CalcFuelBtn);
        TotalFuelEdit.setOnClickListener((View.OnClickListener) this);
        TopLineEdit.setOnClickListener((View.OnClickListener) this);
        BottomLineEdit.setOnClickListener((View.OnClickListener) this);
        BottomLineAnswer.setOnClickListener(this);
        LeftTank.setOnClickListener(this);
        CenterTank.setOnClickListener(this);
        RightTank.setOnClickListener(this);





    }
    public void onClick(View v){

        switch (v.getId()){
            case R.id.TotalFuelEdit:
                TotalFuelEdit.getText().clear(); //or you can use editText.setText("");
                break;
            case R.id.TopLineEdit:
                TopLineEdit.getText().clear(); //or you can use editText.setText("");
                break;
            case R.id.BottomLineEdit:
                BottomLineEdit.getText().clear(); //or you can use editText.setText("");
                break;
            case R.id.LeftTank:
                LeftTank.getText().clear(); //or you can use editText.setText("");
                break;
            case R.id.CentreTank:
                CenterTank.getText().clear(); //or you can use editText.setText("");
                break;
            case R.id.RightTank:
                RightTank.getText().clear(); //or you can use editText.setText("");
                break;

        }


    }
    public void ButtonTest(View view) {


        String TotalFuelString = TotalFuelEdit.getText().toString();
        if (TextUtils.isEmpty(TotalFuelString)) {
            TotalFuelEdit.setError("Add Fuel!");
            return;
        }
        String TopLineEditString = TopLineEdit.getText().toString();
        if (TextUtils.isEmpty(TopLineEditString)) {
            TopLineEdit.setError("Add Fuel!");
            return;
        }
        String BottomLineString = BottomLineEdit.getText().toString();
        if (TextUtils.isEmpty(BottomLineString)) {
            BottomLineEdit.setText("Add Fuel!");
            return;

        }

        int TotalFuel1 = (Integer.parseInt(TotalFuelEdit.getText().toString()));

        int TopLine1 = ((Integer.parseInt(TopLineEdit.getText().toString())));
        int BottomLine1 = (Integer.parseInt(BottomLineEdit.getText().toString()));
        int DoSums1 = (TotalFuel1 - TopLine1);
        int DoSums2 = (TotalFuel1 - BottomLine1);
        // RightTank.setText("24");

        //test.setText("Hello");
        // test.setText(String.valueOf(DoSums));
        TopLineAnswer.setText(String.valueOf(DoSums1) + " kg");
        BottomLineAnswer.setText(String.valueOf(DoSums2) + " kg");

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }
    public void FuelCheck(View view){

        String LeftFuelString = LeftTank.getText().toString();
        if (TextUtils.isEmpty(LeftFuelString)) {
            LeftTank.setError("Add Fuel!");
            return;
        }
        String CenterTankString = CenterTank.getText().toString();
        if (TextUtils.isEmpty(CenterTankString)) {
            CenterTank.setError("Add Fuel!");
            return;
        }
        String RightTankString = RightTank.getText().toString();
        if (TextUtils.isEmpty(RightTankString)) {
            RightTank.setText("Add Fuel!");
            return;

        }
        int LeftFuelInt = (Integer.parseInt(LeftTank.getText().toString()));

        int CenterTankInt = ((Integer.parseInt(CenterTank.getText().toString())));
        int RightTankInt = (Integer.parseInt(RightTank.getText().toString()));
        int DoSums3 = (LeftFuelInt+CenterTankInt+RightTankInt);
        TotalFuelEdit.setText(String.valueOf(DoSums3));
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }
}