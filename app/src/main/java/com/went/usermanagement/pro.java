package com.went.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pro extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_pro );
        String[] data=getIntent ().getStringArrayExtra ( "natty");
        t1=findViewById ( R.id.textView8 );
        t2=findViewById ( R.id.textView7 );
        t3=findViewById ( R.id.textView9 );
        t4=findViewById ( R.id.textView10);
        t5=findViewById ( R.id.textView11);
        t6=findViewById ( R.id.textView12);
button=findViewById ( R.id.button );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (getApplicationContext (),Login.class);
                startActivity (intent);
            }
        } );

        t1.setText (  data[0]);
        t2.setText (  data[1]);
        t3.setText (  data[2]);
        t4.setText (  data[3]);
        t5.setText (  data[4]);
        t6.setText (  data[5]);



            }}