package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.adapters.TrashAdapter;
import com.bilalzaman.advancecallvideorecorder.models.TrashModel;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrashFragment extends Fragment {


    private Context context;
    private RecyclerView recyclerView;
    private TrashAdapter trashAdapter;
    private TextView txtTitle;
    private ImageButton imgBack;
    private ArrayList<TrashModel> data = new ArrayList<>();
    Unbinder unbinder;

    public TrashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trash, container, false);;
        context = container.getContext();
        unbinder = ButterKnife.bind(this,view);
        txtTitle = view.findViewById(R.id.txtTitle);
        imgBack = view.findViewById(R.id.imgBack);

        txtTitle.setText("Trash Recording");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);
        recyclerView = view.findViewById(R.id.recyclerView);
        trashAdapter = new TrashAdapter(context, data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(trashAdapter);

        return view;
    }

}
