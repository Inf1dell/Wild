package com.example.wild;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public static final String APP_KEY = "favorite";

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> listHref = new ArrayList<String>();
    private ArrayList<String> listPrice = new ArrayList<String>();
    private ArrayList<String> listImg = new ArrayList<String>();
    private ListView listView;

    SharedPreferences mSettings;

    ProgressDialog pd;



    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.listS);
        mSettings = getSharedPreferences(APP_KEY, Context.MODE_PRIVATE);

        new JsonTask().execute("https://catalog.wb.ru/catalog/electronic6/catalog?appType=1&couponsGeo=12,3,18,15,21,101&curr=rub&dest=-1029256,-51490,-184002,123586067&emp=0&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&spp=0&subject=2872;2875");
    }

    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(SecondActivity.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                    Log.d("Response: ", "> " + line);

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()){
                pd.dismiss();
            }

            try {
//                tId.substring(0, Math.min(tId.length(), 4))
                JSONObject jObj = new JSONObject(result);
                JSONArray jsonArry = jObj.getJSONObject("data").getJSONArray("products");
                for(int i=0;i<jsonArry.length();i++){
                    JSONObject obj = jsonArry.getJSONObject(i);
                    list.add(obj.getString("name"));
                    listHref.add("https://www.wildberries.ru/catalog/"+obj.getString("id").toString()+"/detail.aspx?targetUrl=GP");
                    listPrice.add((obj.getInt("salePriceU")/100)+" руб");
                    listImg.add((obj.getString("id")));

                    products.add(new Product(obj.getString("name"), "Цена: "+(obj.getInt("salePriceU")/100)+" руб", R.drawable.ic_launcher_background,"https://www.wildberries.ru/catalog/"+obj.getString("id").toString()+"/detail.aspx?targetUrl=GP",false));


                }
//                ArrayAdapter<String> adapter = new ArrayAdapter(SecondActivity.this,
//                        android.R.layout.simple_list_item_1, list);
                boxAdapter = new BoxAdapter(SecondActivity.this, products);
                listView.setAdapter(boxAdapter);
//                listView.setAdapter(adapter);
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getApplicationContext(), "Добавлено в сравнить", Toast.LENGTH_SHORT).show();

                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(listHref.get(i)));
                        startActivity(intent);

                        return false;
                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Toast.makeText(getApplicationContext(), "Добавлено в сравнить", Toast.LENGTH_SHORT).show();

//                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(listHref.get(position)));
//                        startActivity(intent);

                        SharedPreferences.Editor editor = mSettings.edit();
                        editor.putString("wildN",list.get(position)+"");
                        editor.putString("wildP",listPrice.get(position)+"");
                        editor.apply();
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}