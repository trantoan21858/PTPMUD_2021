package org.at15.mystories.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.at15.mystories.R;
import org.at15.mystories.data.DataManager;
import org.at15.mystories.data.model.CategoryModel;

import java.util.List;

public class CategoryFragment extends Fragment implements ListCategoryAdapter.ItemListener {

    private CategoryViewModel mViewModel;

    private ListCategoryAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(
                this,
                new CategoryViewModelFactory(DataManager.get().getCategoryRepository())
        ).get(CategoryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_category, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.category_recycle_view);
        mAdapter = new ListCategoryAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mViewModel.getCategoryLiveData().observe(
                getViewLifecycleOwner(),
                categoryModels -> mAdapter.setData(categoryModels)
        );
        mViewModel.loadCategories();
        return root;
    }

    @Override
    public void onClick(CategoryModel category) {

    }
}