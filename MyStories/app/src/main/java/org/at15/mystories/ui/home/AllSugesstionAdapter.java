package org.at15.mystories.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.at15.mystories.R;
import org.at15.mystories.data.model.NovelModel;

import java.util.ArrayList;
import java.util.List;

public class AllSugesstionAdapter extends RecyclerView.Adapter<AllSugesstionAdapter.ViewHolder> implements SugesstionAdapter.ItemListener{

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mHeaderTitle;

        private TextView mTitleView;

        private RecyclerView mListDataView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleView = itemView.findViewById(R.id.title);
            mListDataView = itemView.findViewById(R.id.list_suggestion);
            mHeaderTitle = itemView.findViewById(R.id.header_title);
        }

        public TextView getTitleView() {
            return mTitleView;
        }

        public RecyclerView getListDataView() {
            return mListDataView;
        }

        public View getHeaderTitle() {
            return mHeaderTitle;
        }
    }

    public static class SuggesstionGroup {
        private String mTitle;
        private List<NovelModel> mListNovels;

        public String getTitle() {
            return mTitle;
        }

        public List<NovelModel> getListNovels() {
            return mListNovels;
        }

        public SuggesstionGroup(String title, List<NovelModel> listNovel) {
            this.mTitle = title;
            this.mListNovels = listNovel;
        }
    }

    public interface ItemListener {
        void onGroupClick(SuggesstionGroup group);
        void onNovelClick(NovelModel novel);
    }

    private List<SuggesstionGroup> mListData;
    private ItemListener mCallback;

    public AllSugesstionAdapter(ItemListener callback) {
        this.mCallback = callback;
        mListData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.sugesstion_item,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTitleView.setText(mListData.get(position).getTitle());
        holder.getHeaderTitle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onGroupClick(mListData.get(holder.getAdapterPosition()));
            }
        });
        SugesstionAdapter adapter = new SugesstionAdapter(this,mListData.get(position).getListNovels());
        holder.getListDataView().setAdapter(adapter);
        holder.getListDataView().setLayoutManager(new LinearLayoutManager(
                holder.mTitleView.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        ));
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    @Override
    public void onItemClick(NovelModel novel) {
        mCallback.onNovelClick(novel);
    }

    public void setData(List<SuggesstionGroup> data) {
        this.mListData = data;
        notifyDataSetChanged();
    }
}
