package org.at15.mystories.ui.personal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.at15.mystories.R;
import org.at15.mystories.ui.home.HomeFragment;
import org.at15.mystories.ui.list_novels.ListNovelFragment;

public class PersonalFragment extends Fragment {

    PersonalViewPagerAdapter demoCollectionAdapter;
    ViewPager2 viewPager;

    private PersonalViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(PersonalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(new PersonalViewPagerAdapter(this));
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    tab.setIcon(R.drawable.ic_bookmark);
                    tab.setText("Đang đọc");
                }
        ).attach();
    }
}