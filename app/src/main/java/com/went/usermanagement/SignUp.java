package com.went.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText editText2,editText3,editText4,editText5,editText6,editText7;
    RadioButton r1;
    RadioButton r2;
    Button button2;
    USER u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sign_up );
        editText2 = findViewById ( R.id.editText3 );
        editText3 = findViewById ( R.id.editText4 );
        editText4 = findViewById ( R.id.editText5 );
        editText5 = findViewById ( R.id.editText6 );
        editText6 = findViewById ( R.id.editText7 );
        String f1=editText2.getText ().toString ();
        String f2=editText3.getText ().toString ();
        String f3=editText4.getText ().toString ();
        String f4=editText5.getText ().toString ();
        String f5="male";
        String f6=editText6.getText ().toString ();
        r1 = findViewById ( R.id.male );
        r2=findViewById ( R.id.female );
        button2=findViewById ( R.id.button2 );
       u=new USER (f1,f2,f3,f4,f5,f6);
        button2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                DatabaseHelper databaseHelper=new DatabaseHelper ( getApplicationContext () );
                long insert = databaseHelper.insert ( u );
                if(insert>0) {
                    Intent intent = new Intent ( getApplicationContext ( ),MainActivity.class );
                    startActivity ( intent );
                }
                else {
                    Toast.makeText ( getApplicationContext (),"not inserted",Toast.LENGTH_SHORT ).show ();
                }
            }
        } );



    }
}
