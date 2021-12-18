package org.at15.mystories.ui.list_novels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import org.at15.mystories.R;
import org.at15.mystories.data.DataManager;
import org.at15.mystories.ui.list_novels.ListNovelViewModel;
import org.at15.mystories.ui.list_novels.ListNovelViewModelFactory;

public class ListNovelsActivity extends AppCompatActivity {

    private ListNovelViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_novels);
        String title = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(title);
        ListNovelViewModelFactory factory
                = new ListNovelViewModelFactory(DataManager.get().getNovelsRepository());
        mViewModel = ViewModelProviders.of(this,factory).get(ListNovelViewModel.class);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}