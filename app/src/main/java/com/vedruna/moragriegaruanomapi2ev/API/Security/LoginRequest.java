package com.vedruna.moragriegaruanomapi2ev.API.Security;

/**
 * Clase que representa una solicitud de inicio de sesión en la API.
 */
public class LoginRequest {
    private String username;  // Nombre de usuario proporcionado en la solicitud
    private String password;  // Contraseña proporcionada en la solicitud

    /**
     * Constructor de la clase `LoginRequest`.
     *
     * @param username Nombre de usuario proporcionado en la solicitud.
     * @param password Contraseña proporcionada en la solicitud.
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Obtiene el nombre de usuario de la solicitud.
     *
     * @return Nombre de usuario de la solicitud.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario de la solicitud.
     *
     * @param username Nombre de usuario a establecer.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña de la solicitud.
     *
     * @return Contraseña de la solicitud.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña de la solicitud.
     *
     * @param password Contraseña a establecer.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}