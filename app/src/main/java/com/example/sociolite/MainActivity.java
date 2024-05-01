package com.example.sociolite;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.sociolite.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sociolite.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Toolbar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView cameraToolbar=toolbar.findViewById(R.id.imageView2);
        cameraToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "camera is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        BottomNavigationView navView = findViewById(R.id.nav_view);

       navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               if(item.getItemId()==R.id.navigation_home){
                   HomeFragment homeFragment=new HomeFragment();
                   FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                  transaction.replace(R.id.nav_host_fragment_activity_main,homeFragment);
                  transaction.commit();
               }
               else if(item.getItemId()==R.id.navigation_search){
                   Toast.makeText(MainActivity.this, "search fragement coming soon", Toast.LENGTH_SHORT).show();
               }
               return true;
           }
       });
    }


    public void setSupportActionBar(Toolbar toolbar) {
        this.supportActionBar = toolbar;
    }


}