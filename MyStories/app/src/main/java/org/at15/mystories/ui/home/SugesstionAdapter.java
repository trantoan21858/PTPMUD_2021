package org.at15.mystories.ui.home;

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

import java.util.List;

public class SugesstionAdapter extends RecyclerView.Adapter<SugesstionAdapter.ViewHolder> {

    private ItemListener mCallback;
    private List<NovelModel> mListData;

    public SugesstionAdapter(ItemListener callback, List<NovelModel> data) {
        this.mCallback = callback;
        mListData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(mListData.get(position).getName());
        Glide.with(holder.mImageView).load(mListData.get(position).getImageUrl()).into(holder.getImageView());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onItemClick(mListData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        private TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mImageView = itemView.findViewById(R.id.image);
            this.mTextView = itemView.findViewById(R.id.title);
        }

        public ImageView getImageView() {
            return mImageView;
        }

        public TextView getTextView() {
            return mTextView;
        }
    }

    interface ItemListener {
        void onItemClick(NovelModel novel);
    }
}
