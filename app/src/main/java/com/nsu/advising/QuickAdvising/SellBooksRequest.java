package com.nsu.advising.QuickAdvising;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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

public class SellBooksRequest extends AppCompatActivity {

    private EditText etBname,etBedition,etBautor,etBprice,etBphone;
    private TextView txtClickHere;
    private Spinner spnDept;
    private String[] dept;
    private String department,date,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_books_request);
        spnDept = (Spinner) findViewById(R.id.spinnerDept);
        dept = getResources().getStringArray(R.array.depertment);
        etBname = (EditText)findViewById(R.id.etBookName);
        etBautor = (EditText)findViewById(R.id.etBookAuthor);
        etBedition = (EditText)findViewById(R.id.etBookEdition);
        etBprice = (EditText)findViewById(R.id.etBookPrice);
        etBphone = (EditText)findViewById(R.id.etBookPhone);
        txtClickHere=(TextView)findViewById(R.id.clickhere);
        url = getResources().getString(R.string.sellerBookReq);

        //post date
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        date = dateFormat.format(Calendar.getInstance().getTime());
        //Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();

        txtClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellBooksRequest.this,BuyerBookActivity.class));
            }
        });

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.spn_row_layout,R.id.txtDeptRow,dept);
        spnDept.setAdapter(stringArrayAdapter);

        spnDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = spnDept.getSelectedItem().toString();
//                Toast.makeText(getApplicationContext(),department,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void postRequest(final String category, final String bookName, final String bookAuthor, final String bookEdition, final String bookPrice,
                             final String bookPhn){


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

                Map<String,String> map = new HashMap<>();
                map.put("bname",bookName);
                map.put("bcat",category);
                map.put("bauthor",bookAuthor);
                map.put("bedition",bookEdition);
                map.put("bprice",bookPrice);
                map.put("bphn",bookPhn);
                map.put("bdate", date);

                return map;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void sentReq(View view) {

        String bookName = etBname.getText().toString();
        String bookEdition = etBedition.getText().toString();
        String bookPrice = etBprice.getText().toString();
        String bookPhone = etBphone.getText().toString();
        String bookAuthor = etBautor.getText().toString();

        if (!department.equalsIgnoreCase("Select your department")){

            if (!bookName.equalsIgnoreCase("") && !bookAuthor.equalsIgnoreCase("") && !bookEdition.equalsIgnoreCase("") && !bookPhone.equalsIgnoreCase("") &&
                    !bookPrice.equalsIgnoreCase("")){

                postRequest(department,bookName,bookAuthor,bookEdition,bookPrice,bookPhone);
                startActivity(new Intent(SellBooksRequest.this,SellerBookList.class));
                etBname.setText("");
                etBedition.setText("");
                etBprice.setText("");
                etBphone.setText("");
                etBautor.setText("");

            }
        }else {
            Toast.makeText(getApplicationContext(),"Select your department!",Toast.LENGTH_SHORT).show();
        }

    }
}
