package com.vedruna.moragriegaruanomapi2ev.API.Model;

import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase representa un usuario en el sistema.
 */
public class User {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String description;
    private LocalDate createDate;
    private List<Post> posts;
    private List<User> followers;
    private List<User> followed;
    private Role role;

    /**
     * Constructor por defecto de la clase User.
     */
    public User() {
    }

    /**
     * Constructor de la clase User.
     *
     * @param userId      el ID del usuario
     * @param username    el nombre de usuario
     * @param email       el correo electrónico del usuario
     * @param password    la contraseña del usuario
     * @param description la descripción del usuario
     * @param createDate  la fecha de creación del usuario
     * @param posts       la lista de publicaciones del usuario
     * @param followers   la lista de seguidores de este usuario
     * @param followed    la lista de usuarios seguidos por este usuario
     * @param role        el rol del usuario
     */
    public User(Long userId, String username, String email, String password, String description, LocalDate createDate, List<Post> posts, List<User> followers, List<User> followed, Role role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.createDate = createDate;
        this.posts = posts;
        this.followers = followers;
        this.followed = followed;
        this.role = role;
    }

    /**
     * Método getter para obtener el ID del usuario.
     *
     * @return el ID del usuario
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Método setter para establecer el ID del usuario.
     *
     * @param userId el ID del usuario
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Método getter para obtener el nombre de usuario.
     *
     * @return el nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método setter para establecer el nombre de usuario.
     *
     * @param username el nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método getter para obtener el email del usuario.
     *
     * @return el email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método setter para establecer el email del usuario.
     *
     * @param email el email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método getter para obtener la contraseña del usuario.
     *
     * @return la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Método setter para establecer la contraseña del usuario.
     *
     * @param password la contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método getter para obtener la descripción del usuario.
     *
     * @return la descripción del usuario
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método setter para establecer la descripción del usuario.
     *
     * @param description la descripción del usuario
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método getter para obtener la fecha de creación del usuario.
     *
     * @return la fecha de creación del usuario
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Método setter para establecer la fecha de creación del usuario.
     *
     * @param createDate la fecha de creación del usuario
     */
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    /**
     * Método getter para obtener la lista de publicaciones del usuario.
     *
     * @return la lista de publicaciones del usuario
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Método setter para establecer la lista de publicaciones del usuario.
     *
     * @param posts la lista de publicaciones del usuario
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Método getter para obtener los seguidores del usuario.
     *
     * @return la lista de seguidores del usuario
     */
    public List<User> getFollowers() {
        return followers;
    }

    /**
     * Método setter para establecer los seguidores del usuario.
     *
     * @param followers la lista de seguidores del usuario
     */
    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    /**
     * Método getter para obtener los usuarios seguidos por este usuario.
     *
     * @return la lista de usuarios seguidos por este usuario
     */
    public List<User> getFollowed() {
        return followed;
    }

    /**
     * Método setter para establecer los usuarios seguidos por este usuario.
     *
     * @param followed la lista de usuarios seguidos por este usuario
     */
    public void setFollowed(List<User> followed) {
        this.followed = followed;
    }

    /**
     * Método getter para obtener el rol del usuario.
     *
     * @return el rol del usuario
     */
    public Role getRole() {
        return role;
    }

    /**
     * Método setter para establecer el rol del usuario.
     *
     * @param role el rol del usuario
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
