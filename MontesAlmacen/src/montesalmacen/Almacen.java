/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montesalmacen;

import java.util.*;

/**
 *
 * @author daw122
 */
public class Almacen {

    private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

    public Almacen() {
    }

    public ArrayList<Articulo> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(ArrayList<Articulo> almacen) {
        this.almacen = almacen;
    }

    void cargarColeccion() {
        Articulo articulo1 = new Articulo();
        Articulo articulo2 = new Articulo("1234/35.A", "tornillos", 9);
        Articulo articulo3 = new Articulo("0022/42.BAS", "tuercas");
        Articulo articulo4 = new Articulo("1122/43.B");
        almacen.add(articulo1);
        almacen.add(articulo2);
        almacen.add(articulo3);
        almacen.add(articulo4);
        System.out.println("Artículos cargados correctamente");
    }

    void visualizarAlmacen() {
        Collections.sort(almacen);
        for (Articulo art : almacen) {
            System.out.println(art.toString());
        }
    }

    void cargarArticulo() {
        Scanner teclado = new Scanner(System.in);
        String codigo = "";
        String descripcion = "";
        int existencias;
        do {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Introduce código de artículo");
            System.out.println("----------------------------------------------------------------------");
            codigo = teclado.nextLine();
        } while (!Articulo.validarCodigo(codigo) || !comprobarCodigo(codigo));
        do {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Introduce descripción del artículo");
            System.out.println("----------------------------------------------------------------------");
            descripcion = teclado.nextLine();
        } while (!Articulo.validarDescripcion(descripcion));
        do {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Introduce número de existencias del artículo");
            System.out.println("----------------------------------------------------------------------");
            try {
                existencias = teclado.nextInt();
            } catch (Exception e) {
                existencias = -1;
                teclado.nextLine();
            }
        } while (!Articulo.validarExistencias(existencias));
        Articulo añadir = new Articulo(codigo, descripcion, existencias);
        almacen.add(añadir);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Artículo añadido correctamente");
        System.out.println("----------------------------------------------------------------------");
    }

    void pedidosPendientes() {
        boolean encontrado = false;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("LISTADO DE ARTÍCULOS PENDIENTES DE REALIZAR PEDIDO");
        for (Articulo art : almacen) {
            if (art.getExistencias() < 10) {
                System.out.println(art.toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("No hay artículos pendientes de realizar pedido.");
        }
    }

    int sumarExistencias() {
        int contador = 0;
        for (Articulo art : almacen) {
            contador = contador + art.getExistencias();
        }
        return contador;
    }

    void modificarExistencias() {
        Scanner teclado = new Scanner(System.in);
        String codigo;
        boolean encontrado = false;
        int respuesta;
        int existencias = 0;
        do {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Introduce el código el artículo a modificar");
            System.out.println("----------------------------------------------------------------------");
            codigo = teclado.nextLine();
        } while (!Articulo.validarCodigo(codigo));
        for (Articulo art : almacen) {
            if (art.getCodigo().equals(codigo)) {
                encontrado = true;
                do {
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Este artículo cuenta con " + art.getExistencias() + "/999 existencias.");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("Introduce la cantidad de existencias a aumentar (- para disminuir)");
                    System.out.println("----------------------------------------------------------------------");
                    try {
                        respuesta = teclado.nextInt();
                    } catch (Exception e) {
                        respuesta = -1;
                        teclado.nextLine();
                    }
                    existencias = art.getExistencias() + respuesta;
                } while (!Articulo.validarExistencias(existencias));
                art.setExistencias(existencias);
                System.out.println("----------------------------------------------------------------------");
                System.out.println(
                        "Se han modificado las existencias del artículo " + codigo + ", existencias: " + existencias);
                System.out.println("----------------------------------------------------------------------");
            }
        }
        if (!encontrado) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("No se han encontrado artículos con este código");
            System.out.println("----------------------------------------------------------------------");
        }
    }

    void borrarArticulo() {
        Scanner teclado = new Scanner(System.in);
        String codigo;
        boolean encontrado = false;
        do {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Introduce el código el artículo a borrar");
            System.out.println("----------------------------------------------------------------------");
            codigo = teclado.nextLine();
        } while (!Articulo.validarCodigo(codigo));
        Iterator<Articulo> it = almacen.listIterator();
        while (it.hasNext()) {
            Articulo art = it.next();
            if (art.getCodigo().equals(codigo)) {
                encontrado = true;
                it.remove();
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Se ha eliminado el artículo con código: " + codigo);
                System.out.println("----------------------------------------------------------------------");
            }
        }
        if (!encontrado) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("No se han encontrado artículos con este código");
            System.out.println("----------------------------------------------------------------------");
        }
    }

    void vaciarAlmacen() {
        almacen.clear();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Almacén borrado correctamente");
    }

    boolean comprobarCodigo(String codigo) {
        boolean encontrado = false;
        for (Articulo art : almacen) {
            if (art.getCodigo().equals(codigo)) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Ya existe un artículo con el código introducido");
            return false;
        } else {
            return true;
        }
    }

}
