package com.example.wild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button a,w,f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=findViewById(R.id.button);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(ali);
            }
        });
        w=findViewById(R.id.button2);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wild = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(wild);
            }
        });
        f=findViewById(R.id.favorite_btn);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fav = new Intent(MainActivity.this, FavoriteActivity.class);
                startActivity(fav);
            }
        });

    }

}