package com.example.ht09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
    EditText inputText;
    EditText inputText2;
    EditText inputText3;
    String date = "22.03.2021";
    int time1 = 250000;
    int time2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initializeUI();

        inputText = findViewById(R.id.editTextDate2);
        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                date = inputText.getText().toString();
            }


        });
        inputText2 = findViewById(R.id.editTextTime2);
        inputText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                time1  = Integer.parseInt((inputText2.getText().toString()).replace(":","")+"00");

            }
        });
        inputText3 = findViewById(R.id.editTextTime3);
        inputText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                time2  = Integer.parseInt((inputText3.getText().toString()).replace(":","")+"00");

            }
        });


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
                        new ArrayAdapter<Movie>(getApplicationContext(),  android.R.layout.simple_list_item_1, TL.readXML2(position,date,time1,time2));

                        listview.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}

