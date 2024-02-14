package com.vedruna.moragriegaruanomapi2ev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vedruna.moragriegaruanomapi2ev.API.Constants.Constants;
import com.vedruna.moragriegaruanomapi2ev.API.Interface.ApiCRUD;
import com.vedruna.moragriegaruanomapi2ev.API.Security.LoginRequest;
import com.vedruna.moragriegaruanomapi2ev.API.Security.LoginResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Actividad que maneja la autenticación y el inicio de sesión de los usuarios.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText usernameText, passwordText;  // Campos de texto para ingresar el nombre de usuario y la contraseña

    // Instancia de Retrofit para realizar operaciones en la API
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // Instancia de la interfaz ApiCRUD para realizar operaciones en la API
    ApiCRUD apiCRUD = retrofit.create(ApiCRUD.class);

    /**
     * Método llamado cuando se crea la actividad.
     *
     * @param savedInstanceState Estado previamente guardado de la instancia.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar los campos de texto
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
    }

    /**
     * Método que maneja el evento de inicio de sesión cuando se presiona el botón de inicio de sesión.
     *
     * @param view Vista que activa el evento.
     */
    public void login(View view) {
        // Obtener el nombre de usuario y la contraseña ingresados por el usuario
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        // Crear una solicitud de inicio de sesión con el nombre de usuario y la contraseña
        LoginRequest loginRequest = new LoginRequest(username, password);

        // Realizar la llamada a la API para autenticar al usuario
        Call<LoginResponse> call = apiCRUD.login(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    // Mostrar un mensaje de inicio de sesión exitoso
                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_LONG).show();

                    // Redirigir a la actividad de navegación después de un inicio de sesión exitoso
                    Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                    startActivity(intent);
                } else {
                    // Mostrar un mensaje de error si las credenciales son incorrectas
                    Toast.makeText(LoginActivity.this, "Incorrect username or password.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                // Mostrar un mensaje de error si la conexión con el servidor falla
                Toast.makeText(LoginActivity.this, "Failed connection to server.", Toast.LENGTH_LONG).show();
                Log.e("Throw err: ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}