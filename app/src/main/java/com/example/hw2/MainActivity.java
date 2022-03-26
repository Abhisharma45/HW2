package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //variable declarations
    Spinner metricConverstionSpinnerSelect;
    private ArrayList metricConverstionList;
    ArrayAdapter metricConverstionSpinnerListAdapter;
    EditText displayMetrics;
    public int positionSelected = 0;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner to show conversion metrics in select list
        metricConverstionSpinnerSelect = (Spinner) findViewById(R.id.metric_list);
        displayMetrics = (EditText) findViewById(R.id.hint_input);
        submit = (Button) findViewById(R.id.submit);


        metricConverstionList = new ArrayList<>();
        //add metric conversion list in arraylist
        metricConverstionList.add(getResources().getString(R.string.metric1));

        metricConverstionList.add(getResources().getString(R.string.metric2));
        metricConverstionList.add(getResources().getString(R.string.metric3));
        metricConverstionList.add(getResources().getString(R.string.metric4));


        //adapter to fill the select list with metricConverstionList array values
        metricConverstionSpinnerListAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, metricConverstionList);
        metricConverstionSpinnerSelect.setAdapter(metricConverstionSpinnerListAdapter);

        //select list spinner listener
        metricConverstionSpinnerSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                positionSelected = i;

                //set hint based on position selected
                switch (positionSelected) {
                    case 0:
                        displayMetrics.setHint(getResources().getString(R.string.hint1));
                        break;
                    case 1:
                        displayMetrics.setHint(getResources().getString(R.string.hint2));
                        break;
                    case 2:
                        displayMetrics.setHint(getResources().getString(R.string.hint3));
                        break;
                    case 3:
                        displayMetrics.setHint(getResources().getString(R.string.hint4));
                }
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });

        //convert the value entered into appropriate metric on click of submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Please enter value to convert", Toast.LENGTH_LONG).show();
                if (displayMetrics.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter value to convert", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!displayMetrics.getText().toString().equalsIgnoreCase("")) {
                    switch (positionSelected) {
                        
                        case 0:
                            Double euro = (Double.parseDouble(displayMetrics.getText().toString())) * 0.91;
                            TextView currencyview = (TextView) findViewById(R.id.textView1);
                            currencyview.append("" + euro + "\n");
                            Double IndianRupee = (Double.parseDouble(displayMetrics.getText().toString())) * 76.29;
                            currencyview.append("" + IndianRupee + "\n");
                            Double AustralianDollar = (Double.parseDouble(displayMetrics.getText().toString())) * 1.33;
                            currencyview.append("" + AustralianDollar + "\n");
                            Double CanadianDollar  = (Double.parseDouble(displayMetrics.getText().toString())) * 1.25;
                            currencyview.append("" + CanadianDollar + "\n");
                            break;

                        case 1:
                            Double celsius = (Double.parseDouble(displayMetrics.getText().toString()) - 32) * 5.0 / 9;
                            TextView tempview= (TextView) findViewById(R.id.textView1);
                            tempview.append("" + celsius + "\n");
                            Double kelvin = (Double.parseDouble(displayMetrics.getText().toString()) - 32)  *  5.0/9 + 273.15;
                            tempview.append("" + kelvin + "\n");
                            break;

                        case 2:
                            Double kg = Double.parseDouble(displayMetrics.getText().toString()) / 2.2046;
                            TextView weightview= (TextView) findViewById(R.id.textView1);
                            weightview.append("" + kg + "\n");
                            Double g = Double.parseDouble(displayMetrics.getText().toString()) * 453.59237;
                            weightview.append("" + g + "\n");
                            Double oz = Double.parseDouble(displayMetrics.getText().toString()) * 16;
                            weightview.append("" + oz + "\n");
                            break;

                        case 3:
                            Double km = Double.parseDouble(displayMetrics.getText().toString()) / 0.62137;
                            TextView distanceview = (TextView) findViewById(R.id.textView1);
                            distanceview.append("" + km + "\n");
                            Double m = Double.parseDouble(displayMetrics.getText().toString()) * 1609;
                            distanceview.append("" + m + "\n");
                            Double ft = Double.parseDouble(displayMetrics.getText().toString()) * 5280;
                            distanceview.append("" + ft + "\n");
                            Double in = Double.parseDouble(displayMetrics.getText().toString()) * 63360;
                            distanceview.append("" + in + "\n");
                            break;

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter value to convert", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
