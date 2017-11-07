package org.kang.sikgoo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import org.kang.sikgoo.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DataSet> mDataset;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    public class DataSet{
        String text;
        int img;

        public DataSet(String text, int img) {
            this.text = text;
            this.img = img;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mDataset = new ArrayList<>();
        super.onViewCreated(view, savedInstanceState);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.main_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new RecyclerViewAdapter(mDataset));

        mDataset.add(new DataSet("Kasuga", R.drawable.mirai_01));
        mDataset.add(new DataSet("Mirai", R.drawable.mirai_02));
        mDataset.add(new DataSet("Kawaii", R.drawable.mirai_03));
        mDataset.add(new DataSet("Riina", R.drawable.riina_01));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
        private ArrayList<DataSet> mDataset;

        public RecyclerViewAdapter(ArrayList<DataSet> myDataSet) {
            mDataset = myDataSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset.get(position).text);
            holder.mImageView.setImageResource(mDataset.get(position).img);

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView mImageView;
            private TextView mTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                mImageView = (ImageView)itemView.findViewById(R.id.main_image);
                mTextView = (TextView)itemView.findViewById(R.id.main_textview);
            }
        }
    }
}
