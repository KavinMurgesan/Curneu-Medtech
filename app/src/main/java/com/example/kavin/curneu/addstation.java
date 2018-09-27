package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addstation extends AppCompatActivity {
    Button registerStation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstation);
        registerStation= (Button)findViewById(R.id.button4);
        registerStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(addstation.this,"station registered successfully",Toast.LENGTH_LONG).show();
            }
        });

    }

}
