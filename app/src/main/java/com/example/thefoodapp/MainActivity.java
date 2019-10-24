package com.example.thefoodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends AppCompatActivity {

    private Document doc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url);
            Document doc = connection.get();
            String searchWord = "test";
            this.doc = doc;

            System.out.println("Searching for the word " + searchWord + "...");
            String bodyText = this.doc.body().text();
            return bodyText.toLowerCase().contains(searchWord.toLowerCase());
        }
        catch(IOException ex)
        {
            return false;
        }


    }
}
