package com.nsu.advising.QuickAdvising;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nsu.advising.advising.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class BuyerBookActivity extends AppCompatActivity {

    private EditText etBuyerName,etBuyerPhone,etBuyerBookName,etAurhorname,etBookEdition;
    private String url,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_book);
        etBuyerName = (EditText)findViewById(R.id.BuyerName);
        etBuyerPhone = (EditText)findViewById(R.id.BuyerNumber);
        etBuyerBookName = (EditText)findViewById(R.id.BuybookName);
        etAurhorname = (EditText)findViewById(R.id.BuybookAuthor);
        etBookEdition = (EditText)findViewById(R.id.BuybookEdition);
        url = getResources().getString(R.string.buyerBookReq);
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        date = dateFormat.format(Calendar.getInstance().getTime());
    }

    private void buyerPostRequest(final String buyerName, final String buyerPhone,final String buyerBookName, final String buyerBookAuthor,
                             final String buyerBookEdition){


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"post request successful",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"post request unsuccessful",Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<>();

                if(!buyerName.equalsIgnoreCase("") && !buyerPhone.equalsIgnoreCase("")) {
                    map.put("buyername", buyerName);
                    map.put("buyerphone", buyerPhone);
                    map.put("buyerbookname", buyerBookName);
                    map.put("buyerbookauthor", buyerBookAuthor);
                    map.put("bookedition", buyerBookEdition);
                    map.put("buyerdate", date);
                   }
                    return map;
                }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void submit(View view) {


        String BuyerName,BuyerPhone,BuyerBookName,BuyerBookEdition,BuyerBookAuthorName;
        BuyerName = etBuyerName.getText().toString();
        BuyerPhone = etBuyerPhone.getText().toString();
        BuyerBookAuthorName = etAurhorname.getText().toString();
        BuyerBookEdition = etBookEdition.getText().toString();
        BuyerBookName = etBuyerBookName.getText().toString();

            if (!BuyerName.equalsIgnoreCase("") && !BuyerPhone.equalsIgnoreCase("") && !BuyerBookName.equalsIgnoreCase("")
                    && !BuyerBookAuthorName.equalsIgnoreCase("") &&
                    !BuyerBookEdition.equalsIgnoreCase("")){

              buyerPostRequest(BuyerName,BuyerPhone,BuyerBookName,BuyerBookAuthorName,BuyerBookEdition);

                Intent intent = new Intent(BuyerBookActivity.this,Successful.class);
                intent.putExtra("name",BuyerName);
                startActivity(intent);

                etBuyerName.setText("");
                etBuyerPhone.setText("");
                etBuyerBookName.setText("");
                etAurhorname.setText("");
                etBookEdition.setText("");

        }else {
            Toast.makeText(getApplicationContext(),"fill up all the field!",Toast.LENGTH_SHORT).show();
        }

    }
}
