package org.breinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Optional;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
/**
 * Clase que maneja la lista de usuarios y permite añadir,
 * buscar, listar y guardar/cargar datos en JSON..
 * @author [Breinner Imbachi]
 */
public class AdministradorDeUsuarios {

    private Gson gson = new Gson();
    private List<Usuario> users = new ArrayList<>();

    public AdministradorDeUsuarios() {
        load();
    }
    /**
     * Añade un usuario a la lista y guarda
     */
    public void addUser(Usuario u) {
        if (u == null)
            return;
        users.add(u);
        save();
    }
    /**
     * Busca un usuario por su nombre
     */
    public Optional<Usuario> findUser(String username) {
        return users.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
    /**
     * Muestra todos los usuarios por consola
     */
    public void listUsers() {
        for (Usuario u : users)
            System.out.println(u);
    }
    /**
     * Guarda la lista de usuarios en un archivo JSON
     */
    private void save() {
        try (FileWriter writer = new FileWriter("users.json")) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Carga los usuarios desde el archivo JSON
     */
    private void load() {
        try (FileReader reader = new FileReader("users.json")) {
            Type listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
            users = gson.fromJson(reader, listType);
            if (users == null) users = new ArrayList<>();
        } catch (IOException e) {
            users = new ArrayList<>();
        }
    }
}
