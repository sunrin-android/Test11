package com.example.test11;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    ListView listView;
    String city1;
    String[] city2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView = findViewById(R.id.list_detail);

        Intent intent = getIntent();
        int position = intent.getIntExtra("city1", 0);
        if (position == 0) {
            city1 = "서울특별시";
            city2 = new String[]{"종로구", "강남구", "송파구"};
        }
        else {
            city1 = "경기도";
            city2 = new String[]{"성남시", "수원시", "용인시"};
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent();
                intent1.putExtra("city1", city1);
                intent1.putExtra("city2", city2[position]);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK){
            Toast.makeText(this, ""+data.getExtras().get("city"), Toast.LENGTH_SHORT).show();
        }
    }
}
