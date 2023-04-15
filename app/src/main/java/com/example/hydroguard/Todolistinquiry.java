package com.example.hydroguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.hydroguard.adapter.TodolistAdapter;
import com.example.hydroguard.model.Todolist;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Todolistinquiry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todolistinquiry);
        //tarik data
        Realm realm = Realm.getDefaultInstance();
        //penarikan data
        RealmResults<Todolist> toDoList =
                realm.where(Todolist.class).findAll();
        //menampilkan data
//        for(User user : users){
//            Log.d("TAG","Nama :"+user.getNama()
//                    + ", Nomor Telp"+ user.getNotlp());
//        }
        ArrayList<Todolist> arrayofuser = new ArrayList<Todolist>();
        arrayofuser.addAll(realm.copyFromRealm(toDoList));
        realm.close();

        TodolistAdapter todolistadapter = new TodolistAdapter(this,arrayofuser);
        ListView listView = (ListView) findViewById(R.id.listviewtodolist);
        listView.setAdapter(todolistadapter);
    }
}