package com.example.gilin;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.gilin.dain.Login;
import com.example.gilin.dain.Util.PreferenceUtil;
import com.example.gilin.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = binding.bottomNavigation;

        String loginStatus = PreferenceUtil.getLoginStatus(this);
        String userId = PreferenceUtil.getUserId(this);
        Log.d("MyActivity", "Login status: " + loginStatus);
        Log.d("MyActivity", "Login status: " + userId);

        if ("x".equals(loginStatus)) {
            transferTo(new Login());
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 파일 생성 후 변경!!
//                if (item.getItemId() == R.id.사고다발) {
//                    transferTo(new 사고다발());
//                    return true;
//                } else if (item.getItemId() == R.id.안전벨) {
//                    transferTo(new 안전벨());
//                    return true;
//                } else if (item.getItemId() == R.id.My) {
//                    transferTo(new My());
//                    return true;
//                } else if (item.getItemId() == R.id.즐겨찾기) {
//                    transferTo(new 즐겨찾기());
//                    return true;
//                } else if (item.getItemId() == R.id.신고) {
//                    transferTo(new 신고());
//                    return true;
//                }
                return false;
            }

        });
    }

    public void hideBottomNav() {
        binding.bottomNavigation.setVisibility(View.GONE);
    }

    public void showBottomNav() {
        binding.bottomNavigation.setVisibility(View.VISIBLE);
    }

    void transferTo(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}