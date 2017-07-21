package com.nsu.advising.QuickAdvising;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nsu.advising.QuickAdvising.adapter.SellerAdapter;
import com.nsu.advising.QuickAdvising.modal.SellerBook;
import com.nsu.advising.advising.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SellerBookList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SellerBook> arrayList = new ArrayList<>();
    private ProgressBar progressBar;
    private LinearLayout layoutProgress;
    private Spinner spnDept;
    private String[] dept;
    private String department;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_book_list);
        recyclerView = (RecyclerView)findViewById(R.id.sellerRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        progressBar = (ProgressBar)findViewById(R.id.progressBarForSeller);
        layoutProgress = (LinearLayout)findViewById(R.id.layoutProgressForSeller);
        spnDept = (Spinner) findViewById(R.id.spinnerDept);
        dept = getResources().getStringArray(R.array.depertment);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sellerBookList();

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,R.layout.spn_row_layout,R.id.txtDeptRow,dept);
        spnDept.setAdapter(stringArrayAdapter);

        spnDept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                department = spnDept.getSelectedItem().toString();
                sellerBookListWithCategory(department);
                //Toast.makeText(getApplicationContext(),department,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void sellerBookList(){
        String url = getResources().getString(R.string.getSellerBookList);
        arrayList.clear();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                layoutProgress.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);

                try {

                    for(int i = response.length() - 1 ; i >= 0 ; i--){

                        JSONObject object = (JSONObject) response.get(i);

                        String bname = object.getString("book_name");
                        String bedition = object.getString("book_edition");
                        String bprice = object.getString("book_price");
                        String bnumber = object.getString("phn_number");
                        String bauthor =  object.getString("author");

                        if(!bname.equalsIgnoreCase("") && !bedition.equalsIgnoreCase("") &&
                                !bprice.equalsIgnoreCase("") && !bnumber.equalsIgnoreCase("")) {
                            SellerBook sellerBook = new SellerBook(
                                    bname,
                                    bedition,
                                    bprice,
                                    bnumber,
                                    bauthor,
                                    object.getString("date")
                            );
                            //Toast.makeText(getApplicationContext(),object.getString("book_name"),Toast.LENGTH_SHORT).show();
                            arrayList.add(sellerBook);
                        }
                    }

                    adapter = new SellerAdapter(arrayList);
                    recyclerView.setAdapter(adapter);

                    layoutProgress.setVisibility(View.GONE);
                    progressBar.setIndeterminate(false);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }


    private void sellerBookListWithCategory(final String dept){
        String url = getResources().getString(R.string.getSellerBookList);
        arrayList.clear();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                layoutProgress.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);

                try {

                    for(int i = response.length() - 1 ; i >= 0 ; i--){

                        JSONObject object = (JSONObject) response.get(i);

                        String bname = object.getString("book_name");
                        String bedition = object.getString("book_edition");
                        String bprice = object.getString("book_price");
                        String bnumber = object.getString("phn_number");
                        String bauthor =  object.getString("author");
                        String bcatecogy =  object.getString("category");

                        if(!bname.equalsIgnoreCase("") && !bedition.equalsIgnoreCase("") &&
                                !bprice.equalsIgnoreCase("") && !bnumber.equalsIgnoreCase("")) {
                            if (bcatecogy.equalsIgnoreCase(dept)) {
                                SellerBook sellerBook = new SellerBook(
                                        bname,
                                        bedition,
                                        bprice,
                                        bnumber,
                                        bauthor,
                                        object.getString("date")
                                );
                                //Toast.makeText(getApplicationContext(),object.getString("book_name"),Toast.LENGTH_SHORT).show();
                                arrayList.add(sellerBook);
                            }else if (dept.equalsIgnoreCase("Select your department")){
                               sellerBookList();
                                i = 0;
                            }
                        }
                    }

                    adapter = new SellerAdapter(arrayList);
                    recyclerView.setAdapter(adapter);

                    layoutProgress.setVisibility(View.GONE);
                    progressBar.setIndeterminate(false);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }


}
