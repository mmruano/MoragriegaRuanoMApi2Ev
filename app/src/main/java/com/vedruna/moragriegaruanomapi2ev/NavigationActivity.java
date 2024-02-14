package com.vedruna.moragriegaruanomapi2ev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        /**
         * Configuración del BottomNavigationView
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigator_view);
        bottomNavigationView.setSelectedItemId(R.id.homeFragment);
        bottomNavigationView.setSelectedItemId(R.id.navigation_create);
        bottomNavigationView.setSelectedItemId(R.id.navigation_edit);
        bottomNavigationView.setSelectedItemId(R.id.navigation_delete);

        /**
         * Obtener el NavController del NavHostFragment
         */
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        /**
         * Configuración del listener para el BottomNavigationView
         */
        bottomNavigationView.setOnItemSelectedListener(item -> {
            /**
             * Navegar a los fragmentos correspondientes según el ítem seleccionado
             */
            if (item.getItemId() == R.id.navigation_home) {
                navController.navigate(R.id.homeFragment);
            } else if (item.getItemId() == R.id.navigation_create) {
                navController.navigate(R.id.createFragment);
            } else if (item.getItemId() == R.id.navigation_edit) {
                navController.navigate(R.id.editFragment);
            } else if (item.getItemId() == R.id.navigation_delete) {
                navController.navigate(R.id.deleteFragment);
            } else if (item.getItemId() == R.id.navigation_exit) {
                /**
                 * Navegar a la pantalla de inicio de sesión cuando se selecciona la opción de salir
                 */
                Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
            return true;
        });
    }
}