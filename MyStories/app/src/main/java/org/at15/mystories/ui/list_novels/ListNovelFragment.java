package org.at15.mystories.ui.list_novels;

import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.at15.mystories.ui.novel_detail.NovelDetailActivity;
import org.at15.mystories.R;
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
        Log.d("TOÀN","ListNovelFragment onCreateView");
        View root=  inflater.inflate(R.layout.fragment_list_novel, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(ListNovelViewModel.class);
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
        Intent intent = new Intent(requireActivity(), NovelDetailActivity.class);
        intent.putExtra("title",novel.getName());
        intent.putExtra("image_url",novel.getImageUrl());
        startActivity(intent);
    }
}