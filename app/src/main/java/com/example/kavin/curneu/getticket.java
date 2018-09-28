package com.example.kavin.curneu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class getticket extends AppCompatActivity {
    Button getTicket;
    Spinner from, to;
    int fare,stops;
    DatabaseReference databaseReference;
    List<String> stationlists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getticket);
        getTicket = (Button)findViewById(R.id.button2);
        from=(Spinner)findViewById(R.id.spinner);
        to=(Spinner)findViewById(R.id.spinner2);
        databaseReference = FirebaseDatabase.getInstance().getReference("stations");;
        stationlists=new ArrayList<>();
        getTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fromst=from.getSelectedItem().toString();
                String tost=to.getSelectedItem().toString();
                int selfrom=from.getSelectedItemPosition()+1;
                int selto=to.getSelectedItemPosition()+1;
                stops=selfrom-selto;
                if (selfrom==selto){
                    Toast.makeText(getticket.this,"choose correct destination "+fare,Toast.LENGTH_LONG).show();
                }
                else if(stops == 10){
                    fare=18;
                }
                else{

                    while(stops!=0){
                        if(stops<=3){
                            fare+=10;
                            break;
                        }
                        else{
                            stops = stops-3;
                            fare+=10;
                        }
                    }


                    Toast.makeText(getticket.this,"total fare is: "+fare,Toast.LENGTH_LONG).show();
                }

            }

        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final List<String> areas = new ArrayList<String>();
                for(DataSnapshot stationsnapshot:dataSnapshot.getChildren()){
                    ticket ticket=stationsnapshot.getValue(com.example.kavin.curneu.ticket.class);

                    stationlists.add(ticket.getStaName());


                }

                ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(getticket.this, android.R.layout.simple_spinner_item, stationlists);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                from.setAdapter(areasAdapter);
                to.setAdapter(areasAdapter);

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
