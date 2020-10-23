package com.example.findnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView questionText;
    Button big, lit, eq;
    int min, max, avg;
    String minStr,maxStr, line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        questionText = (TextView) findViewById(R.id.question);
        Intent i = getIntent();
        minStr = i.getStringExtra("min");
        maxStr = i.getStringExtra("max");
        min = Integer.parseInt(minStr);
        max = Integer.parseInt(maxStr);

        avg = (min + max) / 2;
        Log.d("my", "min = " + minStr + " max = "+maxStr);
        line = "Угадываем число от "+min+" до "+max+"\nВаше число больше, меньше или равно "+avg+" ?";
        questionText.setText(line);

        big = findViewById(R.id.big); //больше
        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                min = avg;
                avg = (min + max) / 2;
                String pr = "Ваше число больше, меньше или равно "+avg+" ?";
                questionText.setText(pr);
            }
        });
        lit = findViewById(R.id.lit);
        lit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                max = avg;
                avg = (min + max) / 2;
                String pr = "Ваше число больше, меньше или равно "+avg+" ?";
                questionText.setText(pr);
            }
        });
        eq = findViewById(R.id.eq);
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
