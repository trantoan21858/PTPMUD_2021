package org.at15.mystories.ui.personal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.at15.mystories.ui.category.CategoryFragment;

public class PersonalViewPagerAdapter extends FragmentStateAdapter {

    public PersonalViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new CategoryFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
