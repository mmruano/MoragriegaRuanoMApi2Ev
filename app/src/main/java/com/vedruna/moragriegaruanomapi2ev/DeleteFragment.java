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
import com.vedruna.moragriegaruanomapi2ev.API.Interface.ApiCRUD;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DeleteFragment extends Fragment {

    EditText postIdText;
    ApiCRUD apiCRUD;
    Button deletePostButton;

    public DeleteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);
        postIdText = rootView.findViewById(R.id.postIdText);
        deletePostButton = rootView.findViewById(R.id.deletePostButton);
        deletePostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletePost(v);
            }
        });

        return rootView;
    }

    public void deletePost(View view) {

        Long postId = Long.valueOf(postIdText.getText().toString());

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiCRUD = retrofit.create(ApiCRUD.class);
        Call<String> call = apiCRUD.deletePost(postId);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    Toast.makeText(getActivity(), "Failed request to server.", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(getActivity(), "Post deleted!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NonNull Call<String> call, Throwable t) {
                Log.e("Throw err: ", Objects.requireNonNull(t.getMessage()));
                Toast.makeText(getActivity(), "Failed connection to server.", Toast.LENGTH_LONG).show();
            }
        });
    }
}