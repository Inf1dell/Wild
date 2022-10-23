package com.example.wild;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> listHref = new ArrayList<String>();
    private ListView listView;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = findViewById(R.id.listS);


        new JsonTask().execute("https://catalog.wb.ru/catalog/sport3/catalog?appType=1&couponsGeo=12,3,18,15,21,101&curr=rub&dest=-1029256,-51490,-184002,123586067&emp=0&ext=10240;10241;10242;10243;26824;26831;26832;26843;26851;26853;26879;29755;117238;117239;119255;119266;119267;202838&lang=ru&locale=ru&pricemarginCoeff=1.0&reg=0&regions=80,68,64,83,4,38,33,70,82,69,86,75,30,40,48,1,22,66,31,71&spp=0&subject=50;104;105;128;129;138;212;218;240;247;248;249;252;274;288;384;386;392;393;414;442;459;460;462;475;489;541;564;569;861;862;863;866;1048;1075;1123;1302;1334;1342;1361;1509;1572;1573;1574;1575;1576;1577;1578;1592;1910;2021;2043;2230;2287;2525;2860;3197;3821;4390;4654;4853;5213;5214;5217;5265;5267;6022;6057;6058");
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
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

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

//            JSONObject jsonObject = null;
            try {
//                jsonObject = new JSONObject(result);
//                JSONObject jsonResponse = jsonObject.getJSONObject("data").getJSONObject("products");
//                String team = jsonResponse.getString("name");

                JSONObject jObj = new JSONObject(result);
                JSONArray jsonArry = jObj.getJSONObject("data").getJSONArray("products");
                for(int i=0;i<jsonArry.length();i++){
//                    HashMap<String,String> user = new HashMap<>();
                    JSONObject obj = jsonArry.getJSONObject(i);
                    list.add(obj.getString("name"));
//                    user.put("name",obj.getString("name"));
//                    userList.add(user);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter(SecondActivity.this,
                        android.R.layout.simple_list_item_1, list);

                listView.setAdapter(adapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                        Toast.makeText(getApplicationContext(), list.get(position)+"", Toast.LENGTH_SHORT).show();
//                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(listHref.get(position)));
//                        startActivity(intent);
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            txtJson.setText(result);
        }
    }
}