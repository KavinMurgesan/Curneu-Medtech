package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class addstation extends AppCompatActivity {
    Button registerStation;

    ListView listViewstation;
    DatabaseReference databaseReference;
    EditText sname,sno;
    String stname,stno;
    List<ticket> stationlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstation);
        databaseReference = FirebaseDatabase.getInstance().getReference("stations");
        listViewstation = (ListView)findViewById(R.id.liststation);
        sname=(EditText)findViewById(R.id.editText);
        sno=(EditText)findViewById(R.id.editText2);
        registerStation= (Button)findViewById(R.id.button4);
        stationlists=new ArrayList<>();

    // to register a station
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

    //to get list of station to help admin to check the list of stations already added
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stationlists.clear();
                for(DataSnapshot stationsnapshot:dataSnapshot.getChildren()){
                    ticket ticket=stationsnapshot.getValue(com.example.kavin.curneu.ticket.class);

                    stationlists.add(ticket);


                }

                stationList adapter = new stationList(addstation.this,stationlists);
                listViewstation.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
