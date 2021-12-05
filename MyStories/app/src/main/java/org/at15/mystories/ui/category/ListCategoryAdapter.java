package org.at15.mystories.ui.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.at15.mystories.R;
import org.at15.mystories.data.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class ListCategoryAdapter extends RecyclerView.Adapter<ListCategoryAdapter.ViewHolder> {

    public interface ItemListener {
        void onClick(CategoryModel category);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;

        private  final  TextView mDesciption;

        private final ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDesciption = itemView.findViewById(R.id.description);
            mImage = itemView.findViewById(R.id.image);
        }

        public TextView getTitle() {
            return mTitle;
        }

        public TextView getDesciption() {
            return mDesciption;
        }

        public ImageView getImage() {
            return mImage;
        }
    }

    private ItemListener mCallback;
    private List<CategoryModel> mListData;

    ListCategoryAdapter(ItemListener callback) {
        this.mCallback = callback;
        mListData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListCategoryAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListCategoryAdapter.ViewHolder holder, int position) {
        holder.getTitle().setText(mListData.get(position).getTitle());
        holder.getDesciption().setText(mListData.get(position).getDescription());
        Glide.with(holder.getImage())
                .load(mListData.get(position).getImageUrl()).into(holder.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onClick(mListData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public void setData(List<CategoryModel> data) {
        this.mListData = data;
        notifyDataSetChanged();
    }
}
