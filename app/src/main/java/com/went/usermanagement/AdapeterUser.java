package com.went.usermanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapeterUser extends RecyclerView.Adapter<AdapeterUser.UserviewHOlder> {
    List list;
    Context context;

    public AdapeterUser(Context context,List list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public UserviewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i) {
        View view= LayoutInflater.from ( context ).inflate ( R.layout.single_user,null);

        return new UserviewHOlder ( view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserviewHOlder userviewHOlder,int i) {
        USER user=(USER)list.get (i);
        userviewHOlder.t1.setText ( user.getFull_name () );
        userviewHOlder.t2.setText ( user.getEmail () );
        userviewHOlder.t3.setText ( user.getPhone () );



    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class UserviewHOlder extends RecyclerView.ViewHolder {
      TextView t1,t2,t3,t4,t5,t6;


        public UserviewHOlder(@NonNull View itemView) {
            super ( itemView );
            System.out.println ( "user created1" );
            t1=itemView.findViewById ( R.id.textView);
            t2=itemView.findViewById ( R.id.textView2 );
            t3=itemView.findViewById ( R.id.textView3);
            itemView.setClickable ( true );
            itemView.setOnLongClickListener ( new View.OnLongClickListener ( ) {
                @Override
                public boolean onLongClick(View v) {
                    list.remove ( getAdapterPosition () );
                    notifyItemRemoved ( getAdapterPosition () );
                    return true;
                }

            });
            itemView.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                   // Toast.makeText ( context,getAdapterPosition ()+"",Toast.LENGTH_LONG ).show ();
                    Intent intent=new Intent ( context,pro.class );
                    USER user=(USER) list.get ( getAdapterPosition () );
                    String[] usr_data={user.getGender (),user.getEmail (),user.getFull_name (),user.getPhone (),user.getPassword (),user.getUsername ()};
                    intent.putExtra ( "natty", usr_data);
                    context.startActivity ( intent );
                }
            } );

        }

    }
}
