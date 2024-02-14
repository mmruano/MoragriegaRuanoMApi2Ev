package com.vedruna.moragriegaruanomapi2ev.API.Security;

/**
 * Clase que representa la respuesta de una solicitud de inicio de sesión en la API.
 */
public class LoginResponse {
    private boolean success;  // Indica si la solicitud de inicio de sesión fue exitosa o no
    private String message;    // Mensaje asociado con la respuesta, proporciona información adicional

    /**
     * Constructor por defecto de la clase `LoginResponse`.
     */
    public LoginResponse() {
    }

    /**
     * Constructor de la clase `LoginResponse` con parámetros.
     *
     * @param success Indica si la solicitud de inicio de sesión fue exitosa.
     * @param message Mensaje asociado con la respuesta.
     */
    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    /**
     * Verifica si la solicitud de inicio de sesión fue exitosa.
     *
     * @return `true` si la solicitud fue exitosa, `false` de lo contrario.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Establece si la solicitud de inicio de sesión fue exitosa.
     *
     * @param success Valor a establecer (`true` si es exitosa, `false` de lo contrario).
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Obtiene el mensaje asociado con la respuesta.
     *
     * @return Mensaje asociado con la respuesta.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Establece el mensaje asociado con la respuesta.
     *
     * @param message Mensaje a establecer.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}