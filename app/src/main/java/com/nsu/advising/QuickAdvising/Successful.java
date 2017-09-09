package com.nsu.advising.QuickAdvising;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nsu.advising.advising.R;

public class Successful extends AppCompatActivity {

    private TextView txtName;
    private String buyer_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);
        txtName = (TextView)findViewById(R.id.buyer_name);
        buyer_name = getIntent().getStringExtra("name");
        txtName.setText(buyer_name);
    }
}
