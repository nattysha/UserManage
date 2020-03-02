package com.went.usermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private EditText password, username;
FrameLayout frameLayout;
List userList;
ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        frameLayout=findViewById ( R.id.frame );
        FragmentManager fragmentManager=getSupportFragmentManager ();
        listFragment=new ListFragment (getApplicationContext ());
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction ();
        fragmentTransaction.replace ( R.id.frame,listFragment );
        fragmentTransaction.commit ();

    }
}
