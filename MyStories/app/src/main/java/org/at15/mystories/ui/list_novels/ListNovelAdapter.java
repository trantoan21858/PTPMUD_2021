package org.at15.mystories.ui.list_novels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.at15.mystories.R;

import java.util.Random;

public class ListNovelAdapter extends RecyclerView.Adapter<ListNovelAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;

        private  final  TextView mAuthor;

        private final  TextView mCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mAuthor = itemView.findViewById(R.id.author);
            mCategory = itemView.findViewById(R.id.category);
        }

        public TextView getTitle() {
            return mTitle;
        }

        public TextView getAuthor() {
            return mAuthor;
        }

        public TextView getCategory() {
            return mCategory;
        }
    }

    @NonNull
    @Override
    public ListNovelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.novel_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListNovelAdapter.ViewHolder holder, int position) {
        Random random = new Random();
        holder.getTitle().setText("Novel " + random.nextInt(100));
        holder.getCategory().setText("Thể loại: " + random.nextInt(10));
        holder.getAuthor().setText("Tác giả: author " + random.nextInt(10));
    }

    @Override
    public int getItemCount() {
        return 100;
//        return mListData == null ? 0 : mListData.size();
    }
}
