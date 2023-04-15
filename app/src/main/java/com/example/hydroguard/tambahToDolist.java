package com.example.hydroguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hydroguard.model.Todolist;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class tambahToDolist extends AppCompatActivity {


    EditText edtId, edtJudul, edtDeskripsi;
    Button btnSimpan;
    Integer id;
    String Judul = "";
    String Deskripsi = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_to_dolist);

        edtId = (EditText) findViewById(R.id.etAddId);
        edtJudul = (EditText) findViewById(R.id.etAddTitle);
        edtDeskripsi = (EditText) findViewById(R.id.etAddDescription);

        btnSimpan = (Button) findViewById(R.id.btnAddToDoList);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = Integer.parseInt(edtId.getText().toString());
                Judul = edtJudul.getText().toString();
                Deskripsi = edtDeskripsi.getText().toString();

                tambahTodolist(id, Judul, Deskripsi);
            }
        });

    }
    public void tambahTodolist(Integer id, String Judul, String Deskripsi) {

        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "ID " + id + "Judul" + Judul + "Deskripsi" + Deskripsi);
                    Todolist user1 = realm.createObject(Todolist.class, id);
                    user1.setJudul(Judul);
                    user1.setDeskripsi(Deskripsi);
                    finish();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}