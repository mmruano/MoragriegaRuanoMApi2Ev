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

/**
 * Interfaz que define las operaciones CRUD (Create, Read, Update, Delete) para la API.
 */
public interface ApiCRUD {

    /**
     * Realiza una solicitud de inicio de sesión.
     *
     * @param request Objeto de solicitud de inicio de sesión.
     * @return Objeto de respuesta de inicio de sesión encapsulado en un objeto Call.
     */
    @POST("api/v1/users/login")
    Call<LoginResponse> login(@Body LoginRequest request);

    /**
     * Obtiene la lista de publicaciones por ID de usuario.
     *
     * @param userId ID del usuario para el cual se obtienen las publicaciones.
     * @return Lista de objetos PostDTO encapsulada en un objeto Call.
     */
    @GET("api/v1/posts/postsByUserId/{userId}")
    Call<List<PostDTO>> postByUserId(@Path("userId") Long userId);

    /**
     * Crea una nueva publicación para un usuario específico.
     *
     * @param userId     ID del usuario que realiza la publicación.
     * @param requestDTO Objeto PostDTO que contiene la información de la publicación.
     * @return Mensaje de confirmación encapsulado en un objeto Call.
     */
    @POST("api/v1/posts/createPost/{userId}")
    Call<String> createPost(@Path("userId") Long userId, @Body PostDTO requestDTO);

    /**
     * Edita una publicación existente.
     *
     * @param postId     ID de la publicación que se va a editar.
     * @param requestDTO Objeto PostDTO que contiene la información actualizada de la publicación.
     * @return Mensaje de confirmación encapsulado en un objeto Call.
     */
    @PUT("api/v1/posts/updatePost/{postId}")
    Call<String> editPost(@Path("postId") Long postId, @Body PostDTO requestDTO);

    /**
     * Elimina una publicación existente por su ID.
     *
     * @param postId ID de la publicación que se va a eliminar.
     * @return Mensaje de confirmación encapsulado en un objeto Call.
     */
    @DELETE("api/v1/posts/deletePost/{postId}")
    Call<String> deletePost(@Path("postId") Long postId);
}