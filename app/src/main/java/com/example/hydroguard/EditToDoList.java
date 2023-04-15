package com.example.hydroguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hydroguard.crud.todolistCRUD;

public class EditToDoList extends AppCompatActivity {

    TextView txtIdE;
    EditText edtJudulE, edtDeskripsiE;
    Button btnSimpanE;
    Integer Id;
    String Judul = "";
    String Deskripsi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_to_do_list);

        txtIdE = (TextView) findViewById(R.id.tvEditId);
        edtJudulE = (EditText) findViewById(R.id.etEditTitle);
        edtDeskripsiE = (EditText) findViewById(R.id.etEditDescription);
        btnSimpanE = (Button) findViewById(R.id.btnEditToDoList);


        txtIdE.setText(getIntent().getStringExtra("idtdl"));
        edtJudulE.setText(getIntent().getStringExtra("judul"));
        edtDeskripsiE.setText(getIntent().getStringExtra("deskripsi"));

        btnSimpanE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id = Integer.parseInt(txtIdE.getText().toString());
                Judul = edtJudulE.getText().toString();
                Deskripsi = edtDeskripsiE.getText().toString();


//               Log.d("TAG", "Nama" + Nama + "Nomor Tlp" + NoTlp);
                todolistCRUD todolistcrud = new todolistCRUD();
                todolistcrud.updateTodolist(Id, Judul, Deskripsi);
                finish();
            }
        });
    }
}