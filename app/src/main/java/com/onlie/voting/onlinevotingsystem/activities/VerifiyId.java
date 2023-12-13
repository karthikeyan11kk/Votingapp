package com.onlie.voting.onlinevotingsystem.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.onlie.voting.onlinevotingsystem.Model.Users;
import com.onlie.voting.onlinevotingsystem.R;

public class VerifiyId extends AppCompatActivity {

    String Phone;
    EditText Id;
    Button IdButton;
    private DatabaseReference mref;

    private TextView userName, userPhNo;

    String myId, myAge, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifiy_age);
        Intent i = getIntent();
        Phone = i.getStringExtra("phone");
        userName = (TextView) findViewById(R.id.userName);
        userPhNo = (TextView) findViewById(R.id.userPhoneNumber);
        getUserData(Phone);
        Id = (EditText) findViewById(R.id.idproof);
        IdButton = (Button) findViewById(R.id.verifyagebutton);
        mref = FirebaseDatabase.getInstance().getReference();

        IdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(Id.getText().toString())) {
                    Toast.makeText(VerifiyId.this, "Please Enter you id..",
                            Toast.LENGTH_LONG).show();
                } else if (Id.getText().toString().length() <= 8) {
                    Toast.makeText(VerifiyId.this,
                            "Please enter a valid ID number, it should more than 8 digits.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    mref.child("Users").child(Phone).child("ID").setValue(Id.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Intent i = new Intent(VerifiyId.this,
                                            CameraActivity.class);
                                    i.putExtra("phone", Phone);
                                    startActivity(i);
                                }
                            });
                }
            }
        });
    }

    private void getUserData(String Phone) {
        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("Users");
        mRef.child(Phone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    Users users = snapshot.getValue(Users.class);
                    userName.setText(users.getName());
                    userPhNo.setText(users.getPhone());
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}