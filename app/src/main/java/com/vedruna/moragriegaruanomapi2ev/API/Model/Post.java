package com.vedruna.moragriegaruanomapi2ev.API.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Esta clase representa una publicación en el sistema.
 */
public class Post implements Serializable {
    private Long publicationId; // ID de la publicación
    private User author; // Autor de la publicación
    private String text; // Texto de la publicación
    private LocalDate createDate; // Fecha de creación de la publicación
    private LocalDate editDate; // Fecha de edición de la publicación

    /**
     * Constructor por defecto de la clase Post.
     */
    public Post() {
    }

    /**
     * Constructor de la clase Post.
     *
     * @param publicationId el ID de la publicación
     * @param author        el autor de la publicación
     * @param text          el texto de la publicación
     * @param createDate    la fecha de creación de la publicación
     * @param editDate      la fecha de edición de la publicación
     */
    public Post(Long publicationId, User author, String text, LocalDate createDate, LocalDate editDate) {
        this.publicationId = publicationId;
        this.author = author;
        this.text = text;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    /**
     * Método getter para obtener el ID de la publicación.
     *
     * @return el ID de la publicación
     */
    public Long getPublicationId() {
        return publicationId;
    }

    /**
     * Método setter para establecer el ID de la publicación.
     *
     * @param publicationId el ID de la publicación
     */
    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    /**
     * Método getter para obtener el autor de la publicación.
     *
     * @return el autor de la publicación
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Método setter para establecer el autor de la publicación.
     *
     * @param author el autor de la publicación
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Método getter para obtener el texto de la publicación.
     *
     * @return el texto de la publicación
     */
    public String getText() {
        return text;
    }

    /**
     * Método setter para establecer el texto de la publicación.
     *
     * @param text el texto de la publicación
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Método getter para obtener la fecha de creación de la publicación.
     *
     * @return la fecha de creación de la publicación
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Método setter para establecer la fecha de creación de la publicación.
     *
     * @param createDate la fecha de creación de la publicación
     */
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    /**
     * Método getter para obtener la fecha de edición de la publicación.
     *
     * @return la fecha de edición de la publicación
     */
    public LocalDate getEditDate() {
        return editDate;
    }

    /**
     * Método setter para establecer la fecha de edición de la publicación.
     *
     * @param editDate la fecha de edición de la publicación
     */
    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }
}
