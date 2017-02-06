package com.autosearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by mii-android2 on 9/11/16.
 */

public class AutoSearchListActivity extends AppCompatActivity {

    SearchView autocomplete_places;
    ArrayList<String> listdata;
    RecyclerView recyclerView;
    AutoSearchAdapter adapter;
    // ImageView img_pro_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_list_layout);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // img_pro_back = (ImageView) findViewById(img_pro_back);
        LinearLayoutManager layoutManager = new LinearLayoutManager(AutoSearchListActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        autocomplete_places = (SearchView) findViewById(R.id.autocomplete_places);

        listdata = new ArrayList<>();
        listdata.add("Dell Inspiron");
        listdata.add("HTC One X");
        listdata.add("HTC Wildfire S");
        listdata.add("HTC Sense");
        listdata.add("HTC Sensation XE");
        listdata.add("iPhone 4S");
        listdata.add("Samsung Galaxy Note 800");
        listdata.add("Samsung Galaxy S3");
        listdata.add("MacBook Air");
        listdata.add("Mac Mini");
        listdata.add("MacBook Pro");

        autocomplete_places.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });


        adapter = new AutoSearchAdapter(AutoSearchListActivity.this, listdata);
        recyclerView.setAdapter(adapter);
    }



}