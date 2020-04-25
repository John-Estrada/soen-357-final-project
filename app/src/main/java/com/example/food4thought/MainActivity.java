package com.example.food4thought;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.food4thought.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements AddReviewDialog.AddReviewDialogListener {
    private TextView tvTest;
    private FloatingActionButton fab;
    private FloatingActionButton addFriendButton;
    private CardView profileCard;
    private CardView pastReviewsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        fab = findViewById(R.id.fab);
        addFriendButton = findViewById(R.id.button_add_friend);
        profileCard = findViewById(R.id.dummy_clickbox);
        pastReviewsCard = findViewById(R.id.dummy_clickbox2);

        tvTest = (TextView) findViewById(R.id.textview_popup_test);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
        addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddFriendDialog();
            }
        });
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyProfile();
            }
        });
        pastReviewsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyPastReviews();
            }
        });


    }

    public void openDialog(){
        AddReviewDialog addReviewDialog = new AddReviewDialog();
        addReviewDialog.show(getSupportFragmentManager(), "test dialog");
    }

    public void openAddFriendDialog(){
        AddFriendDialog addFriendDialog = new AddFriendDialog();
        addFriendDialog.show(getSupportFragmentManager(), "another dialog");
    }

    @Override
    public void applyTexts(String restaurantName) {
//        tvTest = (TextView) findViewById(R.id.textview_popup_test);
//        tvTest.setText(restaurantName);
        System.out.println("placeholder action");
    }

    public void openMyProfile(){
        Intent intent = new Intent(MainActivity.this, MyProfileActivity.class);
        startActivity(intent);
    }

    public void openMyPastReviews(){
        Intent intent = new Intent(MainActivity.this, MyPastReviews.class);
        startActivity(intent);
    }
}