package com.example.day2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnsign;
    private Button btnalert;
    private TextView edterror;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnsign =  findViewById(R.id.btnsign);
        btnalert = findViewById(R.id.btnalert);
        edterror = findViewById(R.id.texterror);


        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String email = edtEmail.getText().toString();
               //Toast.makeText(LoginActivity.this, email, Toast.LENGTH_SHORT).show();
                String password = edtPassword.getText().toString();
               // Toast.makeText(LoginActivity.this, email, Toast.LENGTH_SHORT).show();
                if (email.equals("kaurdeol") && password.equals("123"))
                {
                    Intent intent = new Intent(LoginActivity.this,Home2Activity.class);//navigation to next activity
                    intent.putExtra("name","gurminder"); //passing data to next Activity
                    startActivity(intent);
                }
                else
                {
                    edterror.setText("Incorrect credentials");

                }
            }
        });
        btnalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);

                // set title
                alertDialogBuilder.setTitle("Your Title");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Click yes to exit!")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                LoginActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();




            }
        });


    }
}
