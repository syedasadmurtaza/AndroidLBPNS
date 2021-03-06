package com.iulbpns.lbpnsandroid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Asad 15R on 11/16/2015.
 */
public class CuisineFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cuisine,container,false);


        expListView = (ExpandableListView) rootView.findViewById(R.id.lvExpanded);



        // prepare list data
        constructData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        return rootView;
    }

    private void constructData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Burger");
        listDataHeader.add("Pizza");
        listDataHeader.add("Sandwich");

        // Adding child data
        List<String> burger = new ArrayList<String>();
        burger.add("KFC");
        burger.add("McDonalds");

        List<String> pizza = new ArrayList<String>();
        pizza.add("Pizza Point");

        List<String> sandwich = new ArrayList<String>();
        sandwich.add("KFC");
        sandwich.add("McDonalds");

        listDataChild.put(listDataHeader.get(0), burger); // Header, Child data
        listDataChild.put(listDataHeader.get(1), pizza);
        listDataChild.put(listDataHeader.get(2), sandwich);
    }
}
