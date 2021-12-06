package org.at15.mystories.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.at15.mystories.ListNovelsActivity;
import org.at15.mystories.R;
import org.at15.mystories.data.DataManager;
import org.at15.mystories.data.model.NovelModel;

public class HomeFragment extends Fragment implements AllSugesstionAdapter.ItemListener{

    private HomeViewModel mHomeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModelFactory factory = new HomeViewModelFactory(DataManager.get().getNovelsRepository());
        mHomeViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel.class);
        AllSugesstionAdapter allSugesstionAdapter = new AllSugesstionAdapter(this);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mHomeViewModel.getData().observe(getViewLifecycleOwner(), allSugesstionAdapter::setData);
        RecyclerView recyclerView = root.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        );
        recyclerView.setAdapter(allSugesstionAdapter);
        mHomeViewModel.loadSuggestions();
        return root;
    }

    @Override
    public void onGroupClick(AllSugesstionAdapter.SuggesstionGroup group) {
        Intent intent = new Intent(requireContext(), ListNovelsActivity.class);
        intent.putExtra("title",group.getTitle());
        startActivity(intent);
    }

    @Override
    public void onNovelClick(NovelModel novel) {

    }
}