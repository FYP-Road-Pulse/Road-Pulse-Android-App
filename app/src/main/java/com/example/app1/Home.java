package com.example.app1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.Attributes;


public class Home extends AppCompatActivity {
    private StorageReference mStorageReference;

    Button btn_moreframes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final JSONArray crashArray = new JSONArray();//array


        getSupportActionBar().hide(); // hide the title bar

        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();


        db.collection("Crash")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            int counter = 0;

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

                                crashArray.put(crash);

                                counter++;
                                    try {
                                        ((TextView)findViewById(R.id.typetvheading)).setText("TYPE");
                                        ((TextView)findViewById(R.id.typetv)).setText(crash.getString("Type"));//print type
                                        ((TextView)findViewById(R.id.nametvheading)).setText("ANOMALY TYPE");
                                        ((TextView)findViewById(R.id.nametv)).setText(crash.getString("Name"));//print name
                                        ((TextView)findViewById(R.id.timetv)).setText(crash.getString("Timestamp"));    //print time
                                        String imageUri = crash.getString("Image_Url");
                                        ImageView ivBasicImage = (ImageView) findViewById(R.id.image);
                                        Picasso.get().load(imageUri).into(ivBasicImage);

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                        } else {
                            Log.w("error tag", "Error getting documents.", task.getException());
                        }
                    }
                });


// only one frame from firebase storage

//        mStorageReference = FirebaseStorage.getInstance().getReference().child("clipped/crash.jpg");
//        try {
//            final File localFile = File.createTempFile("crash", "jpg");
//            mStorageReference.getFile(localFile)
//                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                            Toast.makeText(Home.this, "Crash Anomaly Detected", Toast.LENGTH_SHORT).show();
//                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
//                            ((ImageView) findViewById(R.id.image)).setImageBitmap(bitmap);
//                        }
//                    }) .addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(Home.this, "No Update", Toast.LENGTH_SHORT).show();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();


        btn_moreframes = (Button)findViewById(R.id.button2);


        btn_moreframes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "More Frames", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),History.class));
            }
        });

    }



    public void btn_map(View view) {
       startActivity(new Intent(getApplicationContext(),MapsActivity.class));
    }

    public void btn_backdb(View view) {
        startActivity(new Intent(getApplicationContext(),DASHBOARD.class));
    }

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://flaskapp-990a1.appspot.com").child("/clipped/crash.jpg");


    public void btn_moreframes(View view) {
    }
}