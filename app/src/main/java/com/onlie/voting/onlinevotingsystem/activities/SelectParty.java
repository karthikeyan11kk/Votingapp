package com.onlie.voting.onlinevotingsystem.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.onlie.voting.onlinevotingsystem.R;

public class SelectParty extends AppCompatActivity {

    Button Party1,Party2,Party3, Party4;
    private DatabaseReference mref;
    private ProgressDialog LoadingBar;
    String Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_select_party);

        Party1=(Button)findViewById(R.id.party1);
        Party2=(Button)findViewById(R.id.party2);
        Party3=(Button)findViewById(R.id.party3);
        Party4=(Button)findViewById(R.id.party4);

        Intent i=getIntent();
        Phone=i.getStringExtra("phone");
        mref= FirebaseDatabase.getInstance().getReference();
        LoadingBar=new ProgressDialog(this);


        Party1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm your vote!");
                builder.setMessage("Do you want to give your vote to Narendra Modi");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();


                        mref.child("Users").child(Phone).child("Party").setValue("LOTUS").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","LOTUS");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });

                        mref.child("Users").child(Phone).child("LOTUS").setValue("1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();




            }
        });
        Party2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm your vote!");
                builder.setMessage("Do you want to give your vote to Kamal Haasan");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("TORCH").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","TORCH");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });

                        mref.child("Users").child(Phone).child("TORCH").setValue("1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        Party3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm your vote!");
                builder.setMessage("Do you want to give your vote to M. K. Stalin");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("RISING SUN").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","RISING SUN");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });


                        mref.child("Users").child(Phone).child("RISING SUN").setValue("1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });

                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        Party4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(SelectParty.this);
                builder.setTitle("Confirm your vote!");
                builder.setMessage("Do you want to give your vote to Edappadi K. Palaniswami");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        LoadingBar.setTitle("Voting Inprogress");
                        LoadingBar.setMessage("Please wait..");
                        LoadingBar.setCanceledOnTouchOutside(false);
                        LoadingBar.show();

                        mref.child("Users").child(Phone).child("Party").setValue("TWO LEAVES").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                Intent i=new Intent(SelectParty.this,FinalActivity.class);
                                i.putExtra("phone",Phone);
                                i.putExtra("partyname","TWO LEAVES");

                                startActivity(i);

                                LoadingBar.dismiss();
                                Toast.makeText(SelectParty.this, "Your Vote is Submitted to our database..", Toast.LENGTH_LONG).show();
                            }
                        });

                        mref.child("Users").child(Phone).child("TWO LEAVES").setValue("1").addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            }
                        });
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
