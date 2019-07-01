package com.example.test11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DetailActivity extends AppCompatActivity {
    ListView list_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        list_detail = findViewById(R.id.list_detail);
    }
}
