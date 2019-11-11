package com.example.prabin_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsActivity extends AppCompatActivity {
    CircleImageView circleImageView;
    TextView name, gender, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);
        circleImageView=findViewById(R.id.imageViewImg);
        name=findViewById(R.id.textViewName);
        gender=findViewById(R.id.textViewGender);
        age=findViewById(R.id.textViewAge);

        Bundle bundle = getIntent().getExtras();


        if(bundle!=null){
            circleImageView.setImageResource(bundle.getInt("image"));
            name.setText(bundle.getString("name"));
            age.setText(bundle.getString("age"));
            gender.setText(bundle.getString("gender"));
        }
    }
}
