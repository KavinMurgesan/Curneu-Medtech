package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button gettic,addsta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      gettic = (Button)findViewById(R.id.button);
      addsta= (Button)findViewById(R.id.button3);

      //to navigate to "get ticket" screen
      gettic.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(MainActivity.this,getticket.class);
              startActivity(i);
          }
      });

        //to navigate to "add station" screen
        addsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,addstation.class);
                startActivity(in);
            }
        });

    }

}
