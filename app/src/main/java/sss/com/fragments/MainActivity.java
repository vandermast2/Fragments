package sss.com.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private FrameLayout containerLay;

    private boolean isActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "ON_CREATE");
        containerLay = findViewById(R.id.containerLay);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(containerLay.getId(), new MondayFragment(),"Monday");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeCycle", "ON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        isActive = true;
        Log.d("LifeCycle", "ON_Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "ON_Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActive=false;
        Log.d("LifeCycle", "ON_Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "ON_Destroy");
    }
}