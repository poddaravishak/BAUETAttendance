package com.eterces.bauetattendance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView recyclerView;
    ClassAdapter classAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClassItem> classItems=new ArrayList<>();
    EditText class_edt;
    EditText subject_edt;
  //  Button cancle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab_main);
        fab.setOnClickListener(v ->  showDialog());
        recyclerView =findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        classAdapter =new ClassAdapter(this,classItems);
        recyclerView.setAdapter(classAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }
    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.class_dialog,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        class_edt =view.findViewById(R.id.class_edit);
        subject_edt =view.findViewById(R.id.subject_edit);

        Button calcle =view.findViewById(R.id.cancel_btn);
        Button add =view.findViewById(R.id.add_btn);
        calcle.setOnClickListener(v->  dialog.dismiss());
    add.setOnClickListener(v-> {
    addClass();
    dialog.dismiss();
});

    }

    private void addClass() {
        String className =class_edt.getText().toString();
        String subjectName =subject_edt.getText().toString();
      classItems.add(new ClassItem(className,subjectName)) ;
        classAdapter.notifyDataSetChanged();
    }
}