package com.example.getdata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textshow = findViewById(R.id.textcview);
        database = FirebaseDatabase.getInstance();
        database.getReference().child("dept data").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.getValue().toString();
                textshow.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MainActivity.this, "failed data get", Toast.LENGTH_SHORT).show();
            }
        });
    }
}