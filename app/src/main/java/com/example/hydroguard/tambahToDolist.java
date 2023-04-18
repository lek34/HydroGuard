package com.example.hydroguard;

import static io.realm.Realm.getApplicationContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hydroguard.model.Todolist;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class tambahToDolist extends AppCompatActivity {


    EditText edtId, edtJudul, edtDeskripsi;
    Button btnSimpan;
    Integer id;
    String Judul = "";
    String Deskripsi = "";

    long nextId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_to_dolist);

//      edtId = (EditText) findViewById(R.id.etAddId);
        edtJudul = (EditText) findViewById(R.id.etAddTitle);
        edtDeskripsi = (EditText) findViewById(R.id.etAddDescription);
        btnSimpan = (Button) findViewById(R.id.btnAddToDoList);
        String description = edtDeskripsi.getText().toString().toLowerCase();
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = edtDeskripsi.getText().toString().toLowerCase();
                if (description.contains("ph") || description.contains("nutrition") || description.contains("temp") || description.contains("plant") || description.contains("fan")) {
                    // the description is valid
                    Judul = edtJudul.getText().toString();
                    Deskripsi = edtDeskripsi.getText().toString();
                    tambahTodolist(Judul, Deskripsi);
                } else {
                    // the description is invalid
                    Toast.makeText(getApplicationContext(), "Invalid Description", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void tambahTodolist(String Judul, String Deskripsi) {

        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
//                    Log.d("TAG", "ID " + id + "Judul" + Judul + "Deskripsi" + Deskripsi);
                    // increment index
                    Number maxId = realm.where(Todolist.class).max("idtdl");
                    nextId = (maxId != null) ? (maxId.longValue() + 1) : 1;
                    Todolist user1 = realm.createObject(Todolist.class, nextId);
                    user1.setJudul(Judul);
                    user1.setDeskripsi(Deskripsi);
                    finish();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Toast.makeText(getApplicationContext(),"ID telah terdaftar! Mohon gunakan ID lain!",Toast.LENGTH_LONG).show();
                }
            }
        });
        realm.close();
    }
}