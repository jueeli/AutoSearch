package com.autosearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mii-android2 on 9/11/16.
 */

public class AutoSearchCategary extends AppCompatActivity {

    TextView txt_search;
    String textSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

        txt_search = (TextView) findViewById(R.id.txt_search);

        textSearch=getIntent().getExtras().getString("MESSAGEFROM");

        txt_search.setText(textSearch);

        txt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HandlerDemo.this, "Hi", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AutoSearchCategary.this, AutoSearchListActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                textSearch = data.getStringExtra("MESSAGEFROM");

                txt_search.setText(textSearch);

            } else if (resultCode == RESULT_CANCELED) {
                txt_search.setText(textSearch);
            }
        }
    }
}