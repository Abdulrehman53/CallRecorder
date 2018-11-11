package com.bilalzaman.advancecallvideorecorder.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.models.TrashModel;

import java.util.ArrayList;

/**
 * Created by BilalZaman on 11/11/2018.
 */
public class TrashAdapter extends RecyclerView.Adapter<TrashAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TrashModel> data = new ArrayList<>();

    public TrashAdapter(Context context, ArrayList<TrashModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_trash, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        // final InboxModel inboxModel = data.get(position);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }
}

