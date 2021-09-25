package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FuelCheckActivity extends AppCompatActivity implements View.OnClickListener {


    EditText TotalFuelEdit, TopLineEdit,BottomLineEdit,TopLineAnswer, BottomLineAnswer;
    Button CalcFuelBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_check);

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

    }
}