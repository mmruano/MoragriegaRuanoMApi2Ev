package com.vedruna.moragriegaruanomapi2ev.API.DTO;

import com.vedruna.moragriegaruanomapi2ev.API.Model.Post;

import java.io.Serializable;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para las publicaciones.
 * Implementa la interfaz Serializable para permitir la serialización.
 */
public class PostDTO implements Serializable {
    private Long publicationId;  // ID de la publicación
    private String author;       // Nombre del autor de la publicación
    private String text;         // Contenido de la publicación

    /**
     * Constructor por defecto.
     */
    public PostDTO() {
    }

    /**
     * Constructor que crea un objeto PostDTO a partir de un objeto Post.
     *
     * @param post Objeto Post del cual se extraen los datos.
     */
    public PostDTO(Post post) {
        this.publicationId = post.getPublicationId();
        this.author = post.getAuthor().getUsername();
        this.text = post.getText();
    }

    /**
     * Obtiene el ID de la publicación.
     *
     * @return ID de la publicación.
     */
    public Long getPublicationId() {
        return publicationId;
    }

    /**
     * Establece el ID de la publicación.
     *
     * @param publicationId ID de la publicación a establecer.
     */
    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    /**
     * Obtiene el nombre del autor de la publicación.
     *
     * @return Nombre del autor de la publicación.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Establece el nombre del autor de la publicación.
     *
     * @param author Nombre del autor a establecer.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Obtiene el contenido de la publicación.
     *
     * @return Contenido de la publicación.
     */
    public String getText() {
        return text;
    }

    /**
     * Establece el contenido de la publicación.
     *
     * @param text Contenido de la publicación a establecer.
     */
    public void setText(String text) {
        this.text = text;
    }
}