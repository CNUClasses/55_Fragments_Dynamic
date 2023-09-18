package com.example.a55_fragments_dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment2Radio extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //KP DO NOT FORGET THE FALSE
        return inflater.inflate(R.layout.myfrag2radio, container,false);
    }

}