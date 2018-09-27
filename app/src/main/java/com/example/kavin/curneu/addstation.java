package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addstation extends AppCompatActivity {
    Button registerStation;


    DatabaseReference databaseReference;
    EditText sname,sno;
    String stname,stno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstation);
        databaseReference = FirebaseDatabase.getInstance().getReference("stations");;

        sname=(EditText)findViewById(R.id.editText);
        sno=(EditText)findViewById(R.id.editText2);
        registerStation= (Button)findViewById(R.id.button4);
        registerStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            stname=sname.getText().toString();
            stno=sno.getText().toString();
       String id=databaseReference.push().getKey();
       ticket ticket = new ticket(id,stname,stno);
       databaseReference.child(id).setValue(ticket);


                Toast.makeText(addstation.this,"station registered successfully",Toast.LENGTH_LONG).show();
            }
        });

    }

}
