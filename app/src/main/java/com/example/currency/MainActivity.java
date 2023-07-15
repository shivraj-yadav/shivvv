package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button button;
    Spinner s1,s2;
    String check1,check2;
    ArrayAdapter<String> adapter1,adapter2;
    String c1[]={"india","USA"};
    String c2[]={"india","USA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        button=findViewById(R.id.button);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);

        adapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,c1);
        s1.setAdapter(adapter1);

        adapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,c2);
        s2.setAdapter(adapter2);


        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                check1=c1[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 check2=c2[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check1.equals("india") && check2.equals("USA"))
                {
                    float e= (float) 82.08;
                    float n= Float.parseFloat((e1.getText().toString()));
                    float res=n/e;
                    e2.setText(String.valueOf(res));
                }
                if(check1.equals("india") && check2.equals("india"))
                {
                    int n=Integer.parseInt(e1.getText().toString());
                    e2.setText(String.valueOf(n));
                }
                if(check1.equals("USA") && check2.equals("india"))
                {
                    float e= (float) 82.08;
                    float n= Float.parseFloat((e1.getText().toString()));
                    float res=n*e;
                    e2.setText(String.valueOf(res));
                }
                if(check1.equals("USA") && check2.equals("USA"))
                {
                    int n=Integer.parseInt(e1.getText().toString());
                    e2.setText(String.valueOf(n));
                }

            }
        });


    }
}