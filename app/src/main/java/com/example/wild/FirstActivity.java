package com.example.wild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> listHref = new ArrayList<String>();
    private ListView listView;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        listView = findViewById(R.id.listView);
        pd = new ProgressDialog(FirstActivity.this);
        pd.setMessage("Please wait");
        pd.setCancelable(false);
        pd.show();
        getHtmlFromWeb();
    }
    private void getHtmlFromWeb() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder stringBuilder = new StringBuilder();


//                final String[] mas = new String[] {};



                try {
                    Document doc = Jsoup.connect("https://aliexpress.ru/category/202000013/toys-hobbies.html").get();
                    stringBuilder.append("!\n");
                    String title = doc.title();
                    Elements links = doc.select("div.product-snippet_ProductSnippet__description__1ettdy > a");
//                    stringBuilder.append(title).append("\n");
                    for (Element link : links) {
                        if(link.text()!="" && link.text() !=" ") {
                            stringBuilder.append("\n").append("Text : ").append(link.text());
                            Log.e("App",link.text().toString()+" ");
                            list.add(""+link.select("div.product-snippet_ProductSnippet__name__1ettdy").text());
                            listHref.add("https://aliexpress.ru/"+link.attr("href"));
                        }
                    }


                } catch (IOException e) {
                    Log.e("App","eroror");
//                    stringBuilder.append("Error : ").append(e.getMessage()).append("\n");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pd.isShowing()){
                            pd.dismiss();
                        }
//                        textView.setText(stringBuilder.toString());
                        Log.e("App",stringBuilder.toString()+" ");
//                        ArrayAdapter<String> adapter = new ArrayAdapter(this,
//                                android.R.layout.simple_list_item_1, catNames);
                        ArrayAdapter<String> adapter = new ArrayAdapter(FirstActivity.this,
                                android.R.layout.simple_list_item_1, list);

                        listView.setAdapter(adapter);


                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                                Toast.makeText(getApplicationContext(), listHref.get(position)+"", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(listHref.get(position)));
                                startActivity(intent);
                            }
                        });

                    }
                });
            }
        }).start();
    }
}