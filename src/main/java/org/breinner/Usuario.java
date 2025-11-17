package org.breinner;
/**
 * Esto representa al usuario conteniendo información
 * como nombre, correo y edad
 * @author [Breinner Imbachi]
 */
public class Usuario {
    /**
     * Nombre de la compañía
     */
    public static String COMPANY_NAME = "OpenAI";
    /**
     * Nombre del usuario
     */
    private String NombreUsuario;
    /**
     * Correo del usuario
     */
    private String correo;
    /**
     * Edad del usuario
     */
    private int edad;

    public Usuario(String NombreUsuario, String correo) {
        this.NombreUsuario = NombreUsuario;
        this.correo = correo;
    }
    /**
     * Devuelve el nombre del usuario
     */
    public String getUsername(){
        return NombreUsuario;
    }
    /**
     * Devuelve el email del usuario
     */
    public String getemail() {
        return correo;
    }
    /**
     * Devuelve la edad del usuario
     */
    public String toString(){
        return "User: " + NombreUsuario + " (" + correo + ")";
    }
}
