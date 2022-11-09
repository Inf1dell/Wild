package com.example.wild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class WildActivity extends AppCompatActivity {

    Button btb1,btb2,btb3,btb4,btb5,btb6,btb7,btb8,btb9,btb10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btb1=findViewById(R.id.bw1);
        btb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/electronic6/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=2872;2875");

                startActivity(ali);
            }
        });
        btb2=findViewById(R.id.bw2);
        btb3=findViewById(R.id.bw3);
        btb4=findViewById(R.id.bw4);
        btb5=findViewById(R.id.bw5);
        btb6=findViewById(R.id.bw6);
        btb7=findViewById(R.id.bw7);
        btb8=findViewById(R.id.bw8);
        btb9=findViewById(R.id.bw9);
        btb10=findViewById(R.id.bw10);

        btb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/rooms/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=1891;4340");
                startActivity(ali);
            }
        });
        btb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/appliances/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=3096;5477;6204;6536;6887;5495");
                startActivity(ali);
            }
        });
        btb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/sport1/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=2173;4154;4298;4299;4430;4433;4434;4498;5232;5251");
                startActivity(ali);
            }
        });
        btb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/books/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=1312;2018;2076;3647;3733");
                startActivity(ali);
            }
        });
        btb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/jewellery/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=606;4314");
                startActivity(ali);
            }
        });
        btb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/repair1/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=655");
                startActivity(ali);
            }
        });
        btb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/garden1/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=1233;4900");
                startActivity(ali);
            }});
        btb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/stationery1/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=469;661;662;719;720;745;746;758;1131;1132;1365;1367;1368;1369;1395;1480;1984;2133;2362;2952;2964;3181;3182;3618;3619;3802;4143;4191;4248;6359;7444");
                startActivity(ali);
            }});
        btb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(WildActivity.this, SecondActivity.class);
                ali.putExtra("url", "https://catalog.wb.ru/catalog/autoproduct2/catalog?appType=1&couponsGeo=12,7,3,6,5,18,21&curr=rub&dest=-1216601,-337422,-1114902,-1198055&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,64,83,4,38,33,70,82,69,68,86,30,40,48,1,22,66,31&spp=0&subject=846;6240");
                startActivity(ali);
            }});
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}