package com.vedruna.moragriegaruanomapi2ev.API.Interface;

import com.vedruna.moragriegaruanomapi2ev.API.DTO.PostDTO;
import com.vedruna.moragriegaruanomapi2ev.API.Security.LoginRequest;
import com.vedruna.moragriegaruanomapi2ev.API.Security.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiCRUD {

    @POST("api/v1/users/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET("api/v1/posts/postsByUserId/{userId}")
    Call<List<PostDTO>> postByUserId(@Path("userId") Long userId);

    @POST("api/v1/posts/createPost/{userId}")
    Call<String> createPost(@Path("userId") Long userId, @Body PostDTO requestDTO);

    @PUT("api/v1/posts/updatePost/{postId}")
    Call<String> editPost(@Path("postId") Long postId, @Body PostDTO requestDTO);

    @DELETE("api/v1/posts/deletePost/{postId}")
    Call<String> deletePost(@Path("postId") Long postId);
}
