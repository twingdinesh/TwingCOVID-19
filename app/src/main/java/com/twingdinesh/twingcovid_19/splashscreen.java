package com.twingdinesh.twingcovid_19;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class splashscreen extends AppCompatActivity {
    Button explore;
    ImageView logo;
    Animation alpha, round;
    EditText username;
    String name;
    SharedPreferences get,put;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        explore = (Button) findViewById(R.id.explore);
        logo = (ImageView) findViewById(R.id.twinglogo);
        username = (EditText) findViewById(R.id.username);
        ref = FirebaseDatabase.getInstance().getReference("names");
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
        round = AnimationUtils.loadAnimation(this, R.anim.round);
        logo.setAnimation(alpha);
        explore.setAnimation(round);
        username.setVisibility(View.GONE);
        get = getSharedPreferences("names", Context.MODE_PRIVATE);
        name = get.getString("name", "");
        if(name.isEmpty())
            username.setVisibility(View.VISIBLE);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!name.isEmpty())
                {
                    start();
                }
                else if(username.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter name to continue",Toast.LENGTH_SHORT).show();
                else
                {
                    name = username.getText().toString();
                    ref.push().setValue(name);
                    SharedPreferences.Editor edit = get.edit();
                    edit.putString("name", name);
                    edit.commit();
                    start();
                }

            }
        });
    }

    public void start() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        splashscreen.this.finish();
    }

}
