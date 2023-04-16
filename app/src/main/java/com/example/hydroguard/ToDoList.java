package com.example.hydroguard;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hydroguard.adapter.TodolistAdapter;
import com.example.hydroguard.model.Todolist;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ToDoList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToDoList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TodolistAdapter adapter;

    ArrayList<Todolist> arrayoftodo;

    public ToDoList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToDoList.
     */
    // TODO: Rename and change types and number of parameters
    public static ToDoList newInstance(String param1, String param2) {
        ToDoList fragment = new ToDoList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "aaa");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the fragment's layout
        View rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false);

        FloatingActionButton btnTambah = (FloatingActionButton) rootView.findViewById(R.id.btnTambahh);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), tambahToDolist.class);
                startActivity(intent);
            }
        });


        // Find the ListView by ID in the inflated layout
        ListView listView = rootView.findViewById(R.id.listviewtodolist);

        // Retrieve data from Realm
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Todolist> toDoList = realm.where(Todolist.class).findAll();

        arrayoftodo = new ArrayList<Todolist>();
        arrayoftodo.addAll(realm.copyFromRealm(toDoList));
        realm.close();

        // Create and set the adapter for the ListView
        TodolistAdapter todolistAdapter = new TodolistAdapter(getContext(), arrayoftodo);
        listView.setAdapter(todolistAdapter);

        return rootView;
    }
}