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
        setContentView(R.layout.community);
        ImageButton ib_writing=(ImageButton) findViewById(R.id.ib_writing);
        ib_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(community.this,community_writing.class);
                startActivity(intent);
            }
        });
    }
}