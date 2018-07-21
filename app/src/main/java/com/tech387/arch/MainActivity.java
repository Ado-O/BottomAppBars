package com.tech387.arch;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tech387.arch.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private BottomAppBar mBottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        //Finding views
        mToolbar = findViewById(R.id.toolbar);
        mBottomAppBar = findViewById(R.id.bar);

        //Setup
        setupToolbar();
        setupFragment();
    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle(R.string.app_name);
        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * OnClickListener for the toolbar back button
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Setting up the listView & its adapter
     */
    private void setupFragment() {

        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(),
                MainOneFragment.newInstance(),
                R.id.container
        );

        mBottomAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.replaceFragmentInActivity(
                        getSupportFragmentManager(),
                        MainTwoFragment.newInstance(),
                        R.id.container
                );
            }
        });

    }
}
