package org.at15.mystories.ui.list_novels;

import androidx.lifecycle.Observer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.at15.mystories.R;
import org.at15.mystories.data.DataManager;
import org.at15.mystories.data.model.NovelModel;

import java.util.List;

public class ListNovelFragment extends Fragment implements ListNovelAdapter.ItemListener {

    private ListNovelViewModel mViewModel;

    public static ListNovelFragment newInstance() {
        return new ListNovelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root=  inflater.inflate(R.layout.fragment_list_novel, container, false);
        ListNovelViewModelFactory factory
                = new ListNovelViewModelFactory(DataManager.get().getNovelsRepository());
        mViewModel = ViewModelProviders.of(this,factory).get(ListNovelViewModel.class);
        final RecyclerView recyclerView= root.findViewById(R.id.list_story);
        ListNovelAdapter novelAdapter = new ListNovelAdapter(this);
        recyclerView.setAdapter(novelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        );
        mViewModel.getNovelListData().observe(getViewLifecycleOwner(), new Observer<List<NovelModel>>() {
            @Override
            public void onChanged(List<NovelModel> novelModels) {
                novelAdapter.setData(novelModels);
            }
        });
        mViewModel.loadNovels();
        return root;
    }

    @Override
    public void onClick(NovelModel novel) {

    }
}