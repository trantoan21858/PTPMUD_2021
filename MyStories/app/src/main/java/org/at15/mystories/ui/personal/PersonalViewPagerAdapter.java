package org.at15.mystories.ui.personal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.at15.mystories.ui.list_novels.ListNovelFragment;

public class PersonalViewPagerAdapter extends FragmentStateAdapter {

    public PersonalViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ListNovelFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
