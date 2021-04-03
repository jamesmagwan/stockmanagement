package com.example.hitechstockmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();

    private TableLayout table;
    EditText ed1, ed2, ed3, ed4, ed5, ed6;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.productname);
        ed2 = findViewById(R.id.Quantity);
        ed3 = findViewById(R.id.productprice);
        ed4 = findViewById(R.id.subtotal);
        ed5 = findViewById(R.id.Payments);
        ed6 = findViewById(R.id.balance);

        b1 = findViewById(R.id.ADDbutton);

        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int subtota=Integer.parseInt(ed4.getText().toString());
                int pay=Integer.parseInt(ed5.getText().toString());
                int bal= pay-subtota;

                ed6.setText(String.valueOf(bal));



            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                add();
            }
        });
    }

    public void add() {
        int total;
        String proname = ed1.getText().toString();
        int quantity = Integer.parseInt(ed2.getText().toString());
        int price = Integer.parseInt(ed3.getText().toString());
        total = quantity * price;
        data.add(proname);
        data1.add(String.valueOf(quantity));
        data2.add(String.valueOf(price));
        data3.add(String.valueOf(total));

        TableLayout table = (TableLayout) findViewById(R.id.table1);
        TableRow row = new TableRow(this);
        TextView t1 = new TextView(this);
        TextView t2 = new TextView(this);
        TextView t3 = new TextView(this);
        TextView t4 = new TextView(this);

        String tot;
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {

            String pname = data.get(i);
            String quatty = data1.get(i);
            String prc = data2.get(i);
            tot = data3.get(i);

            t1.setText(pname);
            t2.setText(quatty);
            t3.setText(prc);
            t4.setText(tot);

            sum = sum + Integer.parseInt(data3.get(i).toString());

        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);
        ed4.setText(String.valueOf(sum));
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ed1.requestFocus();

    }
}