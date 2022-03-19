package montesalmacen;

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        Scanner teclado = new Scanner(System.in);
        int opcionmenu;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("         ###    #       #   #    ###     ####   #####   #   #");
        System.out.println("        #   #   #       ## ##   #   #   #       #       ##  #");
        System.out.println("        #####   #       # # #   #####   #       ###     # # #");
        System.out.println("        #   #   #       #   #   #   #   #       #       #  ##");
        System.out.println("        #   #   #####   #   #   #   #    ####   #####   #   #");
        System.out.println("----------------------------------------------------------------------");
        almacen.cargarColeccion();
        System.out.println("----------------------------------------------------------------------");
        do {
            System.out.println("Menú de opciones:");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("1. Visualizar artículos del almacén ordenados por código");
            System.out.println("2. Cargar un artículo");
            System.out.println("3. Pedidos necesarios de realizar");
            System.out.println("4. Cantidad de artículos distintos en el almacén");
            System.out.println("5. Total de artículos en el almacén contando el número de existencias");
            System.out.println("6. Modificar número de existencias de un artículo");
            System.out.println("7. Borrar un artículo");
            System.out.println("8. Borrar el almacén y salir");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Selecciona una opción: ");
            try {
                opcionmenu = teclado.nextInt();
            } catch (Exception e) {
                opcionmenu = 0;
                teclado.nextLine();
            }
            switch (opcionmenu) {
                case 1:
                    almacen.visualizarAlmacen();
                    break;
                case 2:
                    almacen.cargarArticulo();
                    break;
                case 3:
                    almacen.pedidosPendientes();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Hay un total de " + almacen.getAlmacen().size() + " artículos distintos");
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Hay un total de " + almacen.sumarExistencias() + " artículos");
                    System.out.println("----------------------------------------------------------------------");
                    break;
                case 6:
                    almacen.modificarExistencias();
                    break;
                case 7:
                    almacen.borrarArticulo();
                    break;
                case 8:
                    almacen.vaciarAlmacen();
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("¡Hasta pronto! Gracias por usar nuestra aplicación");
                    System.out.println("----------------------------------------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Respuesta incorrecta");
                    System.out.println("----------------------------------------------------------------------");
                    break;
            }
        } while (opcionmenu != 8);
    }

}
