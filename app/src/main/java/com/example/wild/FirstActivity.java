package com.example.wild;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity {

    public static final String APP_KEY = "favorite";

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> listHref = new ArrayList<String>();
    private ArrayList<String> listPrice = new ArrayList<String>();
    private ListView listView;
    ProgressDialog pd;
    SharedPreferences mSettings;


    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        listView = findViewById(R.id.listView);
        mSettings = getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);
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


                try {
                    Document doc = Jsoup.connect("https://aliexpress.ru/category/202060570/desktops.html").get();
                    stringBuilder.append("!\n");
                    String title = doc.title();



                    Elements links = doc.select("div.product-snippet_ProductSnippet__description__1ettdy > a");
                    Log.e("App",""+doc.select("script#__AER_DATA__").html());


                    for (Element link : links) {
                        if(link.text()!="" && link.text() !=" ") {
                            stringBuilder.append("\n").append("Text : ").append(link.text());

                            list.add(""+link.select("div.product-snippet_ProductSnippet__name__1ettdy").text());
                            listHref.add("https://aliexpress.ru/"+link.attr("href"));
                            listPrice.add(""+link.select("div.snow-price_SnowPrice__mainM__ugww0l").text());
                            products.add(new Product(""+link.select("div.product-snippet_ProductSnippet__name__1ettdy").text(), "Цена: "+link.select("div.snow-price_SnowPrice__mainM__18x8np").text(), R.drawable.ic_launcher_background,"https://aliexpress.ru/"+link.attr("href"),false));

                        }
                    }




                } catch (IOException e) {
                    Log.e("App","ERROR");
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pd.isShowing()){
                            pd.dismiss();
                        }
//                        Log.e("App",stringBuilder.toString()+" ");
//                        ArrayAdapter<String> adapter = new ArrayAdapter(FirstActivity.this, android.R.layout.simple_list_item_1, list);
                        boxAdapter = new BoxAdapter(FirstActivity.this, products);
                        listView.setAdapter(boxAdapter);
                        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                            @Override
                            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(listHref.get(i)));
                                startActivity(intent);
                                return false;
                            }
                        });
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
//

                                Toast.makeText(getApplicationContext(), "Добавлено в сравнить", Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putString("aliN",list.get(position)+"");
                                editor.putString("aliP",listPrice.get(position)+"");
                                editor.apply();
                            }
                        });

                    }
                });
            }
        }).start();
    }
}