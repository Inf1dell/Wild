package com.example.wild;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AliActivity extends AppCompatActivity {

    Button btb1,btb2,btb3,btb4,btb5,btb6,btb7,btb8,btb9,btb10,btb11,btb12,btb13,btb14,btb15,btb16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btb1=findViewById(R.id.button3);
        btb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000001/food.html?spm=a2g2w.productlist.categorylist.1.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb2=findViewById(R.id.button4);
        btb3=findViewById(R.id.button5);
        btb4=findViewById(R.id.button6);
        btb5=findViewById(R.id.button7);
        btb6=findViewById(R.id.button8);
        btb7=findViewById(R.id.button9);
        btb8=findViewById(R.id.button10);
        btb9=findViewById(R.id.button11);
        btb10=findViewById(R.id.button12);
        btb11=findViewById(R.id.button13);
        btb12=findViewById(R.id.button14);
        btb13=findViewById(R.id.button15);
        btb14=findViewById(R.id.button16);
        btb15=findViewById(R.id.button17);
        btb16=findViewById(R.id.button18);

        btb2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                    ali.putExtra("url", "https://aliexpress.ru/category/202000005/home-appliances.html?spm=a2g2w.productlist.categorylist.2.456e4aa6IyySEp");
                    startActivity(ali);
                }
        });
        btb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000006/computer-office.html?spm=a2g2w.productlist.categorylist.3.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000007/home-improvement.html?spm=a2g2w.productlist.categorylist.4.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000008/home-garden.html?spm=a2g2w.productlist.categorylist.5.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000010/sports-entertainment.html?spm=a2g2w.productlist.categorylist.6.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000011/education-office-supplies.html?spm=a2g2w.productlist.categorylist.7.456e4aa6IyySEp");
                startActivity(ali);
            }
        });
        btb8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000014/security-protection.html?spm=a2g2w.productlist.categorylist.9.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000015/automobiles-motorcycles.html?spm=a2g2w.productlist.categorylist.10.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000020/consumer-electronics.html?spm=a2g2w.productlist.categorylist.12.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000054/cellphones-telecommunications.html?spm=a2g2w.productlist.categorylist.16.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000186/tools.html?spm=a2g2w.productlist.categorylist.17.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000216/furniture.html?spm=a2g2w.productlist.categorylist.19.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000051/electronic-components-supplies.html?spm=a2g2w.productlist.categorylist.15.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/202000016/lights-lighting.html?spm=a2g2w.productlist.categorylist.11.456e4aa6IyySEp");
                startActivity(ali);
            }});
        btb16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ali = new Intent(AliActivity.this, FirstActivity.class);
                ali.putExtra("url", "https://aliexpress.ru/category/205964502/virtual-goods.html?spm=a2g2w.productlist.categorylist.30.456e4aa6IyySEp");
                startActivity(ali);
            }});


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}