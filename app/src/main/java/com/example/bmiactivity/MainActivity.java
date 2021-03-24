package com.example.bmiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText mWeight;
    EditText mHeight;
    RadioGroup mSex;
    Button mCount;
    TextView mBMI;
    TextView mResult;
    String Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        init();

        mCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = mHeight.getText().toString();
                String weight = mWeight.getText().toString();
                double bmi = Double.parseDouble(weight)/(Double.parseDouble(height)*Double.parseDouble(height));
                int checkedRadioButtonId = mSex.getCheckedRadioButtonId();
                if(checkedRadioButtonId==R.id.rbMale){
                    if (bmi<20)
                    {
                        Result="体重过轻";
                    }
                    else if(bmi>=20&&bmi<25){
                        Result="体重正常";
                    }
                    else if(bmi>=25&&bmi<27){
                        Result="体重超重";
                    }
                    else if(bmi>=27&&bmi<30){
                        Result="轻度肥胖";
                    }
                    else if(bmi>=30&&bmi<35){
                        Result="中度肥胖";
                    }
                    else if(bmi>=35){
                        Result="重度肥胖";
                    }
                }
                else {
                    if (bmi<19)
                    {
                        Result="体重过轻";
                    }
                    else if(bmi>=19&&bmi<24){
                        Result="体重正常";
                    }
                    else if(bmi>=24&&bmi<26){
                        Result="体重超重";
                    }
                    else if(bmi>=26&&bmi<29){
                        Result="轻度肥胖";
                    }
                    else if(bmi>=29&&bmi<34){
                        Result="中度肥胖";
                    }
                    else if(bmi>=34){
                        Result="重度肥胖";
                    }
                }
                mBMI.setText(String.format("%.2f",bmi)+"");
                mResult.setText(Result);
            }
        });

        

    }

    private void init() {
        mWeight = findViewById(R.id.etWeight);
        mHeight = findViewById(R.id.etHeight);
        mSex = findViewById(R.id.rgSex);
        mCount = findViewById(R.id.btnCount);
        mBMI = findViewById(R.id.tvBMI);
        mResult = findViewById(R.id.tvResult);
    }
}