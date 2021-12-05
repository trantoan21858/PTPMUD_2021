package org.at15.mystories.ui.list_novels;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.at15.mystories.R;
import org.at15.mystories.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListNovelFragment extends Fragment {

    private ListNovelViewModel mViewModel;

    private ListNovelFragment(){

    }

    public static ListNovelFragment newInstance() {
        return new ListNovelFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        requireActivity().setTitle("adssadsd");
        View root=  inflater.inflate(R.layout.list_novel_fragment, container, false);
//        final RecyclerView recyclerView= root.findViewById(R.id.list_story);
//        recyclerView.setAdapter(new ListNovelAdapter(new ArrayList<Story>(),this));
//        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
//        recyclerView.addItemDecoration(
//                new DividerItemDecoration(
//                        requireContext(),
//                        DividerItemDecoration.VERTICAL
//                ));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListNovelViewModel.class);
        // TODO: Use the ViewModel
    }
}