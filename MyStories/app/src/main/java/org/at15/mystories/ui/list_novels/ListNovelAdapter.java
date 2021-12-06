package org.at15.mystories.ui.list_novels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.at15.mystories.R;
import org.at15.mystories.data.model.NovelModel;

import java.util.ArrayList;
import java.util.List;

public class ListNovelAdapter extends RecyclerView.Adapter<ListNovelAdapter.ViewHolder> {
    public interface ItemListener {
        void onClick(NovelModel novel);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;

        private  final  TextView mAuthor;

        private final  TextView mCategory;

        private final ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mAuthor = itemView.findViewById(R.id.author);
            mCategory = itemView.findViewById(R.id.category);
            mImageView = itemView.findViewById(R.id.image);
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

    private ItemListener mCallback;
    private List<NovelModel> mListData;

    ListNovelAdapter(ItemListener callback) {
        this.mCallback = callback;
        mListData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListNovelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.novel_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListNovelAdapter.ViewHolder holder, int position) {
        holder.getTitle().setText(mListData.get(position).getName());
        holder.getCategory().setText("Thể loại: ");
        holder.getAuthor().setText("Tác giả");
        Glide.with(holder.mImageView).load(mListData.get(position).getImageUrl()).into(holder.mImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onClick(mListData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public void setData(List<NovelModel> data) {
        this.mListData = data;
        notifyDataSetChanged();
    }
}
