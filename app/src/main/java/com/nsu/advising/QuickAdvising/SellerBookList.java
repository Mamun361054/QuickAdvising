package com.nsu.advising.QuickAdvising;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_book_list);
        recyclerView = (RecyclerView)findViewById(R.id.sellerRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sellerBookList();
    }

    private void sellerBookList(){
        String url = getResources().getString(R.string.getSellerBookList);
        arrayList.clear();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    for(int i = 0 ; i < response.length() ; i++){

                        JSONObject object = (JSONObject) response.get(i);
                        SellerBook sellerBook = new SellerBook(
                                object.getString("book_name"),
                                object.getString("book_edition"),
                                object.getString("book_price"),
                                object.getString("phn_number"),
                                object.getString("author"),
                                object.getString("date")
                        );
                        //Toast.makeText(getApplicationContext(),object.getString("book_name"),Toast.LENGTH_SHORT).show();
                        arrayList.add(sellerBook);
                    }

                    adapter = new SellerAdapter(arrayList);
                    recyclerView.setAdapter(adapter);

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
