package com.example.wild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class FavoriteActivity extends AppCompatActivity {

    public static final String APP_KEY = "favorite";

    SharedPreferences mSettings;
    TextView name1,name2,price1,price2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);

        mSettings = getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
        if(mSettings.contains("aliN") && mSettings.contains("wildN")) {
            name1.setText(mSettings.getString("aliN",""));
            price1.setText(mSettings.getString("aliP",""));
            name2.setText(mSettings.getString("wildN",""));
            price2.setText(mSettings.getString("wildP",""));
        }
    }
}