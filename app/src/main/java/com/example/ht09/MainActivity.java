package com.example.ht09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initializeUI();


    }

    private void initializeUI() {
       TL.readXML();
       ListView listview = findViewById(R.id.listview);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<Theater> adapter =
                new ArrayAdapter<Theater>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, TL.getTheaterList());
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<Movie> adapter2 =
                        new ArrayAdapter<Movie>(getApplicationContext(),  android.R.layout.simple_list_item_1, TL.readXML2(position));

                        listview.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}

