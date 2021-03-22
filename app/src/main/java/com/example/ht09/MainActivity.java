package com.example.ht09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    TheaterList TL = TheaterList.getInstance();
    ArrayList<Theater> theaters = new ArrayList<Theater>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initializeUI();


    }

    private void initializeUI() {
        readTheaters();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<Theater> adapter =
                new ArrayAdapter<Theater>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, theaters);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }


    public void readTheaters(){
        TL.readXML(theaters);
    }
}

