package com.akshay.demo.demoapp.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.akshay.demo.demoapp.R;

/**
 * Created by akshay on 16/1/18.
 */

public class MyFragment1 extends Fragment {
    static final String TAG = MyFragment1.class.getName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_1_layout, container, false);
        Log.e(TAG, "onCreate() called");

        ((Button) view.findViewById(R.id.buttonNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                //fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new MyFragment2(), "frag2").addToBackStack("frag2").commit();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate() called");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach() called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated() called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach() called");
    }
}
