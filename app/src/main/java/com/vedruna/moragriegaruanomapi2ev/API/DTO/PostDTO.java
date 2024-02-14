package com.vedruna.moragriegaruanomapi2ev.API.DTO;

import com.vedruna.moragriegaruanomapi2ev.API.Model.Post;

import java.io.Serializable;

public class PostDTO implements Serializable {
    private Long publicationId;
    private String author;
    private String text;

    public PostDTO() {

    }

    public PostDTO(Post post) {
        this.publicationId = post.getPublicationId();
        this.author = post.getAuthor().getUsername();
        this.text = post.getText();
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
