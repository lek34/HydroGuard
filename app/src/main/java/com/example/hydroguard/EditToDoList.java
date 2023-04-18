package com.example.hydroguard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        txtIdE = (TextView) findViewById(R.id.tvEditId);
        edtJudulE = (EditText) findViewById(R.id.etEditTitle);
        edtDeskripsiE = (EditText) findViewById(R.id.etEditDescription);
        btnSimpanE = (Button) findViewById(R.id.btnEditToDoList);

        edtJudulE.setText(getIntent().getStringExtra("judul"));
        String idString = getIntent().getStringExtra("idtdl");
        edtDeskripsiE.setText(getIntent().getStringExtra("deskripsi"));

        btnSimpanE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = edtDeskripsiE.getText().toString().toLowerCase();
                if (description.contains("ph") || description.contains("nutrition") || description.contains("temp") || description.contains("plant") || description.contains("fan")) {
                    // the description is valid
                    Id = Integer.parseInt(idString);

                    Judul = edtJudulE.getText().toString();
                    Deskripsi = edtDeskripsiE.getText().toString();
                    todolistCRUD todolistcrud = new todolistCRUD();
                    todolistcrud.updateTodolist(Id, Judul, Deskripsi);
                    finish();
                } else {
                    // the description is invalid
                    Toast.makeText(getApplicationContext(), "Invalid Description", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}