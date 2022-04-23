package com.example.tr_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tr_view.databinding.ActivityBerandaBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BerandaActivity extends AppCompatActivity {

    ActivityBerandaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBerandaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.Home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.Profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.Asset:
                    replaceFragment(new AssetFragment());
                    break;

            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.constraint_layout,fragment);
        ft.commit();
    }
}