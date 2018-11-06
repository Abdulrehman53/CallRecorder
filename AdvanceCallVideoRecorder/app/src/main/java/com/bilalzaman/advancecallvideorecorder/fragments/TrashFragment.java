package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrashFragment extends Fragment {

    private Context context;
    private TextView txtTitle;
    private ImageButton imgBack;


    public TrashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trash, container, false);;
        context = container.getContext();
        txtTitle = view.findViewById(R.id.txtTitle);
        imgBack = view.findViewById(R.id.imgBack);

        txtTitle.setText("Trash");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);
        return view;
    }

}
