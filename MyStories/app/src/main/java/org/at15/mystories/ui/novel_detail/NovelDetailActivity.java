package org.at15.mystories.ui.novel_detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.at15.mystories.R;
import org.at15.mystories.ui.reading.ReadingActivity;

public class NovelDetailActivity extends AppCompatActivity {

    private ImageView mImage;
    private TextView mTitle;
    private TextView mAuthor;
    private TextView mCategory;
    private TabLayout mTabLayout;
    private ViewPager2 mPager;
    private ImageView mFavorite;
    private ImageView mDownload;
    private Button mButtonRead;
    private NovelDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_detail);
        Intent intent = getIntent();

        mImage = findViewById(R.id.imv_image);
        Glide.with(mImage).load(intent.getStringExtra("image_url")).into(mImage);

        mTitle = findViewById(R.id.textview_title);
        mTitle.setText(intent.getStringExtra("title"));

        mAuthor = findViewById(R.id.textview_author);
        mAuthor.setText("Tác giả: " + intent.getStringExtra("author"));

        mCategory = findViewById(R.id.textview_category);
        mCategory.setText("Thể loại: " + intent.getStringExtra("category"));

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(new NovelDetailPagerAdapter(getSupportFragmentManager(),getLifecycle()));
        mTabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(
                mTabLayout,
                mPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("Giới thiệu");
                                break;
                            case 1:
                                tab.setText("Danh sách chương");
                                break;
                        }
                    }
                }
        ).attach();
        mFavorite = findViewById(R.id.imv_favotite);
        mDownload = findViewById(R.id.imv_dowload);
        mButtonRead = findViewById(R.id.button_read);
        mButtonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NovelDetailActivity.this, ReadingActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}