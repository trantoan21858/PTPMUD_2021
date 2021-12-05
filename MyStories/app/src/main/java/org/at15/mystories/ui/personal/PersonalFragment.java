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

import org.at15.mystories.R;
import org.at15.mystories.ui.home.HomeFragment;
import org.at15.mystories.ui.list_novels.ListNovelFragment;

public class PersonalFragment extends Fragment {

    private PersonalViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(PersonalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal, container, false);
        final Button button = root.findViewById(R.id.click_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, ListNovelFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return root;
    }
}