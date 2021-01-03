package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DASHBOARD extends AppCompatActivity {

    Button btn_frames, btn_track, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); // hide the title bar
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_a_s_h_b_o_a_r_d);

        btn_frames = (Button) findViewById(R.id.dbframe);
        btn_track= (Button)findViewById(R.id.track);
        btn_login=(Button)findViewById(R.id.backlogin) ;


        btn_frames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DASHBOARD.this, "Anomaly Frames", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),History.class));
            }
        });

        btn_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DASHBOARD.this, "Track the Anomaly", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DASHBOARD.this, "EXIT APP", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LogIn.class));
            }
        });
    }


}

