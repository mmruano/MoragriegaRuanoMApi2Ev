package com.vedruna.moragriegaruanomapi2ev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vedruna.moragriegaruanomapi2ev.API.Constants.Constants;
import com.vedruna.moragriegaruanomapi2ev.API.DTO.PostDTO;
import com.vedruna.moragriegaruanomapi2ev.API.Interface.ApiCRUD;

import java.io.IOException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fragmento que permite al usuario crear una nueva publicación.
 */
public class CreateFragment extends Fragment {

    private EditText createPostText;  // Campo de texto para la nueva publicación
    private ApiCRUD apiCRUD;          // Instancia de la interfaz ApiCRUD para realizar operaciones en la API
    private Button createPostButton;  // Botón para enviar la solicitud de creación de la publicación

    /**
     * Constructor por defecto de la clase `CreateFragment`.
     */
    public CreateFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    /**
     * Crea y devuelve la vista asociada al fragmento.
     *
     * @param inflater           Inflador que infla la vista.
     * @param container          Contenedor de la vista.
     * @param savedInstanceState Estado previamente guardado de la instancia.
     * @return Vista asociada al fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);
        createPostText = rootView.findViewById(R.id.createPostText);
        createPostButton = rootView.findViewById(R.id.editPostButton);
        createPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost(v);
            }
        });
        return rootView;
    }

    /**
     * Método que se ejecuta cuando el usuario hace clic en el botón para crear una nueva publicación.
     *
     * @param view Vista asociada al botón.
     */
    public void createPost(View view) {

        String text = createPostText.getText().toString();
        PostDTO postDTO = new PostDTO();
        postDTO.setText(text);

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiCRUD = retrofit.create(ApiCRUD.class);
        Call<String> call = apiCRUD.createPost(Constants.userId, postDTO);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    String responseBody = response.body();
                    if (responseBody != null && responseBody.equals("Post created successfully")) {
                        // Si la respuesta es exitosa, mostrar el Toast de éxito
                        Toast.makeText(getActivity(), "Post created!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    // Si la respuesta no es exitosa, mostrar el mensaje de error del servidor
                    Log.e("Response err: ", response.message());
                    Toast.makeText(getActivity(), "Failed request to server.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, Throwable t) {
                if (t instanceof IOException) {
                    // Problema de conexión
                    Toast.makeText(getActivity(), "Network error. Please check your connection.", Toast.LENGTH_LONG).show();
                } else {
                    // Otro tipo de error
                    Log.e("Throw err: ", Objects.requireNonNull(t.getMessage()));
                    Toast.makeText(getActivity(), "Post created!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}