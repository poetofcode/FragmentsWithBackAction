package ru.poetofcode.fragmentswithbackaction;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and show the first fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FirstFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        int backStackCount = getSupportFragmentManager().getBackStackEntryCount();

        // Find current fragment and call its method onBackPressed()
        if (backStackCount > 0) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (currentFragment instanceof OnBackButtonListener) {

                OnBackButtonListener backListener = (OnBackButtonListener) currentFragment;
                boolean actionResult = backListener.onBackPressed();

                if (actionResult) {
                    return;
                }
            }
        }

        super.onBackPressed();
    }
}
