package com.went.usermanagement;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
RecyclerView recyclerView;
List list;
Context context;
    public ListFragment(Context context) {
        // Required empty public constructor
        this.context=context;
        this.list=list;
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate ( R.layout.fragment_list,container,false );
        recyclerView=view.findViewById ( R.id.recyclerView );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( getContext ()));
        list = new ArrayList (  );
        list=(new DatabaseHelper ( getContext () )).getAllData ();
        for (Object i : list)
        {
            System.out.println ( ((USER)i).getEmail () );
            System.out.println ( ((USER)i).getFull_name () );
            System.out.println ( ((USER)i).getPassword () );
        }
        //recyclerView.addItemDecoration ( dividerItemDecoration );
        AdapeterUser adapeter=new AdapeterUser (getContext (),list );
        recyclerView.setAdapter ( adapeter);
        return view;
    }

}
