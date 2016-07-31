package com.lalitsonawane.admin.shaadiapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    DatabaseReference mRootRef=FirebaseDatabase.getInstance().getReference();
    DatabaseReference mMessageRef = mRootRef.child("message");
    EditText b,g;
    Button r;
    String b_edit,g_edit;
    String bg1,bg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b=(EditText) findViewById(R.id.editText);
        g=(EditText) findViewById(R.id.editText2);
r=(Button)findViewById(R.id.reg);

    }

    @Override
    protected void onStart() {
        super.onStart();
 mMessageRef.addValueEventListener(new ValueEventListener() {
     @Override
     public void onDataChange(DataSnapshot dataSnapshot) {
         String text=dataSnapshot.getValue(String.class);
Toast t= Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG);
         t.show();

 }

     @Override
     public void onCancelled(DatabaseError databaseError) {

     }
 });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b_edit=b.getText().toString();

                g_edit=g.getText().toString();
                mMessageRef.setValue(b_edit+g_edit);
            }
        });
    }
}
