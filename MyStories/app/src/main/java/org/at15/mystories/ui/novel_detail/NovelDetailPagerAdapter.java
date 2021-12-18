package org.at15.mystories.ui.novel_detail;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class NovelDetailPagerAdapter extends FragmentStateAdapter {

    public NovelDetailPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new IntroFragment();

            case 1:
                return new ListChapterFragment();
            default:
                return new IntroFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
