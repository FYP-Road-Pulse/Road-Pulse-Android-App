package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); // hide the title bar

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        FirebaseFirestore db = FirebaseFirestore.getInstance();


        db.collection("Crash")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int counter = 1;

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("mera data", document.getId() + " => " + document.getData());//just checking weather data is coming or not

                                JSONObject crash = new JSONObject();//OBJECT
                                try {
                                    crash.put("Type", document.getString("Type"));
                                    crash.put("Name", document.getString("Name"));
                                    crash.put("Timestamp", document.getString("Timestamp"));
                                    crash.put("Image_Url", document.getString("Image_Url"));

                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }

                                if (counter==1) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv1)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image1);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack1)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame1)).setText("Frame 1");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==2) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv2)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image2);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack2)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame2)).setText("Frame 2");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==3) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv3)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image3);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack3)).setText("TAB TO TRACK");

                                        ((TextView)findViewById(R.id.frame3)).setText("Frame 3");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==4) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv4)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image4);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack4)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame4)).setText("Frame 4");


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==5) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv5)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image5);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack5)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame5)).setText("Frame 5");

                                   } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==6) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv6)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image6);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack6)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame6)).setText("Frame 6");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==7) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv7)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image7);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack7)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame7)).setText("Frame 7");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==8) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv8)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image8);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack8)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame8)).setText("Frame 8");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }

                                if (counter==9) {

                                    try {
//                                        ((TextView) findViewById(R.id.typetv1)).setText(crash.getString("Type"));     //print type
                                        ((TextView) findViewById(R.id.nametv9)).setText(crash.getString("Name"));     //print name
//                                        ((TextView) findViewById(R.id.timetv1)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image9);
                                        Picasso.get().load(imageUri).into(ivBasicImage);
                                        ((TextView)findViewById(R.id.fortrack9)).setText("TAB TO TRACK");
                                        ((TextView)findViewById(R.id.frame9)).setText("Frame 9");

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }


                                counter++;

                            }



                        } else {
                            Log.w("error tag", "Error getting documents.", task.getException());
                        }
                    }
                });



    }


    public void btn_gototrack(View view) {
        startActivity(new Intent(getApplicationContext(),Home.class));
    }
}