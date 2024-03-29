package com.vedruna.moragriegaruanomapi2ev;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.vedruna.moragriegaruanomapi2ev.API.Adapters.PostsAdapter;
import com.vedruna.moragriegaruanomapi2ev.API.Constants.Constants;
import com.vedruna.moragriegaruanomapi2ev.API.DTO.PostDTO;
import com.vedruna.moragriegaruanomapi2ev.API.Interface.ApiCRUD;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fragmento que muestra las publicaciones del usuario en la interfaz de inicio.
 */
public class HomeFragment extends Fragment {

    private List<PostDTO> postDTOList;    // Lista de publicaciones del usuario
    private ApiCRUD apiCRUD;               // Instancia de la interfaz ApiCRUD para realizar operaciones en la API
    private ListView postListView;         // Vista de lista para mostrar las publicaciones

    /**
     * Constructor por defecto de la clase `HomeFragment`.
     */
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        postListView = rootView.findViewById(R.id.postListView);
        getAll();
        return rootView;
    }

    /**
     * Obtiene todas las publicaciones del usuario desde el servidor.
     */
    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiCRUD = retrofit.create(ApiCRUD.class);
        Call<List<PostDTO>> call = apiCRUD.postByUserId(Constants.userId);
        call.enqueue(new Callback<List<PostDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostDTO>> call, @NonNull Response<List<PostDTO>> response) {
                if(!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    Toast.makeText(getActivity(), "Failed request to server.", Toast.LENGTH_LONG).show();
                    return;
                }
                postDTOList = response.body();
                PostsAdapter postsAdapter = new PostsAdapter(postDTOList, requireActivity().getApplicationContext());
                postListView.setAdapter(postsAdapter);
                postDTOList.forEach(p -> Log.i("Posts: ", p.toString()));
                Toast.makeText(getActivity(), "Showing posts.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NonNull Call<List<PostDTO>> call, @NonNull Throwable t) {
                Log.e("Throw err: ", Objects.requireNonNull(t.getMessage()));
                Toast.makeText(getActivity(), "Failed connection to server.", Toast.LENGTH_LONG).show();
            }
        });
    }
}