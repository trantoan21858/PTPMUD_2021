package org.at15.mystories;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListNovelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_novels);
        String title = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);
    }
}