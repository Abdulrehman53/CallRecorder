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
import com.bilalzaman.advancecallvideorecorder.adapters.FavouriteAdapter;
import com.bilalzaman.advancecallvideorecorder.models.FavouriteModel;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {

    private TextView txtTitle;
    private ImageButton imgBack;
    private Context context;

    private RecyclerView recyclerView;
    private FavouriteAdapter favouriteAdapter;
    private ArrayList<FavouriteModel> data = new ArrayList<>();
    Unbinder unbinder;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        context = container.getContext();
        unbinder = ButterKnife.bind(this,view);
        txtTitle = view.findViewById(R.id.txtTitle);
        imgBack = view.findViewById(R.id.imgBack);
        txtTitle.setText("Favourite Recording");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);

        recyclerView = view.findViewById(R.id.recyclerView);
        favouriteAdapter = new FavouriteAdapter(context, data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(favouriteAdapter);
        return view;

    }

}
