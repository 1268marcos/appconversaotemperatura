// seq-Junho-006 - INF2-PRA2-15.06.2020-22.06.2020-app-conversao-temperatura-mainactivity-java.pdf

package com.example.conversortemperaturacf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextValue;

    private TextView mTextViewResult;

    private Button mButtonCalculate;

    private void newCalculate(){
        //  Fórmula
        //(0 °C × 9/5) + 32 = 32 °F

        if(TextUtils.isEmpty(mEditTextValue.getText().toString())) {
            Toast.makeText(this, "Informe o valor da temperatura em graus celsius", Toast.LENGTH_SHORT).show();
            return;
        } else {
            double tempC = Double.parseDouble(mEditTextValue.getText().toString());
            double tempF = (tempC * 9/5) + 32;
            mTextViewResult.setText(Double.toString(tempF));
        }
    }

    public class NewCalculateClick implements View.OnClickListener{
        @Override
        public void onClick(View view){
            newCalculate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextValue = findViewById(R.id.editText_Value);

        mTextViewResult = findViewById(R.id.textView_Result);

        mButtonCalculate = findViewById(R.id.button_Calculate);

        mButtonCalculate.setOnClickListener(new NewCalculateClick());
    }
}
