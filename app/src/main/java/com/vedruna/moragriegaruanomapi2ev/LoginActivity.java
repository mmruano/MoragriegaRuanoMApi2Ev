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

public class LoginActivity extends AppCompatActivity {

    private EditText usernameText, passwordText;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiCRUD apiCRUD = retrofit.create(ApiCRUD.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
    }

    public void login(View view) {
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        LoginRequest loginRequest = new LoginRequest(username, password);

        Call<LoginResponse> call = apiCRUD.login(loginRequest);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;

                    Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Incorrect username or password.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed connection to server.", Toast.LENGTH_LONG).show();
                Log.e("Throw err: ", Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}