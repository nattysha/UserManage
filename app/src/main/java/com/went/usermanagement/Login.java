package com.went.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    SharedConfig sharedPreferences;

    Button login;
 TextView create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        username=findViewById ( R.id.username );
        password=findViewById ( R.id.password );
        sharedPreferences = new SharedConfig ( getApplicationContext());

     //   if(sharedPreferences.readLogInStatus()){

      //      Intent intent =new Intent ( getApplicationContext (),MainActivity.class );
        //    startActivity ( intent );
       // }
        login=findViewById (R.id.login);
        create=findViewById ( R.id.create );
        login.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                        DatabaseHelper databaseHelper=new DatabaseHelper ( getApplicationContext () );
                        if(databaseHelper.getForLogin ( username.getText ().toString () )) {
                            Intent intent = new Intent ( getApplicationContext ( ),MainActivity.class );
                            startActivity ( intent );
                        }
                        else {
                            Toast.makeText ( getApplicationContext (),"wrong",Toast.LENGTH_SHORT ).show ();
                        }

            }}
         );

        create.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),SignUp.class);
                startActivity (intent);
            }
        } );
            }}
