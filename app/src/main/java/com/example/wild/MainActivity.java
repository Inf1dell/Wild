package com.example.wild;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnParseHTML);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHtmlFromWeb();
//                new UpdateTask().execute();
            }
        });


//        getWebsite();
//        result=findViewById(R.id.textView);
//        result.setText();
//        new UpdateTask().execute();

    }
    private void getHtmlFromWeb() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder stringBuilder = new StringBuilder();
                try {
                    Document doc = Jsoup.connect("https://aliexpress.ru/category/202000013/toys-hobbies.html").get();
                    stringBuilder.append("!\n");
                    String title = doc.title();
                    Elements links = doc.select("div.product-snippet_ProductSnippet__name__1ettdy");
//                    stringBuilder.append(title).append("\n");
                    for (Element link : links) {
                        if(link.text()!="" && link.text() !=" ") {
                            stringBuilder.append("\n").append("Text : ").append(link.text());
                            Log.e("App",link.text().toString()+" ");
                        }
                    }
                } catch (IOException e) {
                    Log.e("App","eroror");
                    stringBuilder.append("Error : ").append(e.getMessage()).append("\n");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(stringBuilder.toString());
                        Log.e("App",stringBuilder.toString()+" ");

                    }
                });
            }
        }).start();
    }
//    private class UpdateTask extends AsyncTask<String, String,String> {
//
//        @Override
//        protected void onPreExecute(){
//            textView = findViewById(R.id.textView);
//        }
//        protected String doInBackground(String... urls) {
//            final StringBuilder stringBuilder = new StringBuilder();
//            try {
//                Document doc = Jsoup.connect("https://www.dns-shop.ru/catalog/17a899cd16404e77/processory/").userAgent("Mozilla/5.0 (Linux; Android 9) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.60 Mobile Safari/537.36")
//                        .get();
//                stringBuilder.append("FIRst");
//                String title = doc.title();
//                Elements links = doc.select("span");
//                stringBuilder.append(title).append("\n");
//                for (Element link : links) {
////                        if(link.text()!="" && link.text() !=" ") {
//                    stringBuilder.append("\n").append("Text : ").append(link.text());
////                        }
//                }
//            } catch (IOException e) {
//                stringBuilder.append("Error : ").append(e.getMessage()).append("\n");
//            }
//
////            Log.e("App", builder+"");
//            return stringBuilder.toString();
//        }
//        @Override
//        protected void onPostExecute(String text2) {
//            // TODO Auto-generated method stub
//            super.onPostExecute(text2);
//            textView.setText(text2);
//
//        }
//    }
//    private void getWebsite() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final StringBuilder builder = new StringBuilder();
//
//                try {
//                    Document doc = Jsoup.connect("https://www.dns-shop.ru/catalog/aaf2b6f69b96be06/cifrovye-bloknoty/").get();
//                    String title = doc.title();
//                    Elements links = doc.select("a[href]");
//
//                    builder.append(title).append("\n");
//
//                    for (Element link : links) {
//                        builder.append("\n").append("Link : ").append(link.attr("href"))
//                                .append("\n").append("Text : ").append(link.text());
//                    }
//                } catch (IOException e) {
//                    builder.append("Error : ").append(e.getMessage()).append("\n");
//                }
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        result.setText(builder.toString());
//                    }
//                });
//            }
//        }).start();
//    }
}