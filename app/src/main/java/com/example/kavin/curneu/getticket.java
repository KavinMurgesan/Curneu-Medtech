package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class getticket extends AppCompatActivity {
    Button getTicket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getticket);
        getTicket = (Button)findViewById(R.id.button2);
        getTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getticket.this,"total fare is: ",Toast.LENGTH_LONG).show();
            }
        });

    }

}
