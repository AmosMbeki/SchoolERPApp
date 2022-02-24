package it.com.ke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import it.com.ke.mainui.Attendance;
import it.com.ke.mainui.Students;
import it.com.ke.mainui.Teachers;

public class Home extends AppCompatActivity {

    ImageView image_anim;
    Animation animation;

    BottomNavigationView bottomNavigationView;

    NavigationBarView.OnItemSelectedListener navigationItemSelectedListener =
            (BottomNavigationView.OnNavigationItemSelectedListener) item -> {
                switch (item.getItemId()){
                    case R.id.student:
                        Intent student = new Intent(Home.this, Students.class);
                        startActivity(student);
                        return true;

                    case R.id.teacher:
                        Intent teacher = new Intent(Home.this,
                                Teachers.class);
                        startActivity(teacher);
                        return true;

                    case R.id.attendance:
                        Intent attendance = new Intent(Home.this,
                                Attendance.class);
                        startActivity(attendance);
                        return true;

                    default:
                        return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        image_anim = findViewById(R.id.myimage);

        animation = AnimationUtils.loadAnimation(this, R.anim.from_top);

        image_anim.setAnimation(animation);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnItemSelectedListener(this.navigationItemSelectedListener);


    }


}