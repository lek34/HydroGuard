package com.example.hydroguard.crud;

import android.util.Log;

import com.example.hydroguard.model.Todolist;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class todolistCRUD {
    public void updateTodolist(Integer id, String judul, String deskripsi) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Todolist user1 = realm.where(Todolist.class).equalTo("idtdl", id).findFirst();
                    user1.setJudul(judul);
                    user1.setDeskripsi(deskripsi);
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
    public void deleteDataUser(Integer id) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Log.d("TAG", "ID Buku" + id);
                    Todolist user1 = realm.where(Todolist.class).equalTo("idtdl", id).findFirst();
                    user1.deleteFromRealm();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}
