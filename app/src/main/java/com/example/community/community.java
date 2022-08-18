package com.example.community;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class community extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        ImageButton ib_writing = (ImageButton) findViewById(R.id.ib_writing);
        ib_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), community_writing.class);
                startActivity(intent);
            }
        });
        ImageButton ib_community_search = (ImageButton) findViewById(R.id.ib_community_search);
        ib_community_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), community_content_list.class);
                startActivity(intent);
            }
        });
        };
    }

