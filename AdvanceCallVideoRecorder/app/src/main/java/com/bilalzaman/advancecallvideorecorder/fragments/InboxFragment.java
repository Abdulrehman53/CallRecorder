package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.adapters.InboxAdapter;
import com.bilalzaman.advancecallvideorecorder.models.InboxModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;
    private InboxAdapter inboxAdapter;
    private ArrayList<InboxModel> data = new ArrayList<>();

    public InboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        context = container.getContext();
        recyclerView = view.findViewById(R.id.recyclerView);
        inboxAdapter = new InboxAdapter(context, data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(inboxAdapter);

        return view;
    }

}
