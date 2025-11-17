package org.breinner;

import java.util.Scanner;
import java.util.logging.Logger;
/**
 * Lo principal del programa; maneja, agrega,
 * busca y enlista usuarios.
 * @author [Breinner Imbachi]
 */

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        /**
         * Scanner que lee el texto escrito
         */
        Scanner sc = new Scanner(System.in);
        /**
         * Gestiona la lista de usuarios
         */
        AdministradorDeUsuarios manager = new AdministradorDeUsuarios();
        /**
         * Variable que guarda la opción seleccionada
         */
        int option = 0;
        /**
         * Bucle del menú. Se repite hasta que ponga 0
         */
        do {
            LOGGER.info("");
            LOGGER.info(Constantes.T1);
            LOGGER.info(Constantes.T2);
            LOGGER.info(Constantes.T3);
            LOGGER.info(Constantes.SALIR);
            LOGGER.info(Constantes.ELEGIR);
            try {
                /**
                 * Intenta convertir la entrada a número, si no, error
                 */
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                LOGGER.severe(Constantes.INVALID_INPUT);
            }
            LOGGER.info("");
            /**
             * Elejir la opcion del menú que se quiere
             */
            switch (option) {
                case 1:
                    /**
                     * Añade nuevo usuario y su email - está independiente
                     */
                    extracted(sc, manager);
                    break;
                case 2:
                    /**
                     * Busca un usuario por su nombre - está independiente
                     */
                    extracted1(sc, manager);
                    break;
                case 3:
                    /**
                     * Muestra los usuarios almacenados
                     */
                    manager.listUsers();
                    break;
                case 0:
                    /**
                     * Sale del menú
                     */
                    LOGGER.info("Bye!");
                    break;
                default:
                    /**
                     * En caso de opción no válida
                     */
                    LOGGER.severe("Invalid option.");
            }

        } while (option != 0);

        sc.close();
    }


    private static void extracted1(Scanner sc, AdministradorDeUsuarios manager) {
        LOGGER.info("Introduce el nombre de usuario: ");
        String name2 = sc.nextLine();
        manager.findUser(name2)
                .ifPresentOrElse(
                        u -> LOGGER.info ("Usuario encontrado."),
                        () -> LOGGER.severe("Usuario no encontrado")
       );
    }

    private static void extracted(Scanner sc, AdministradorDeUsuarios manager) {
        LOGGER.info("Nombre del usuario: ");
        String name = sc.nextLine();
        LOGGER.info("Email: ");
        String email = sc.nextLine();
        manager.addUser(new Usuario(name, email));
    }
}
