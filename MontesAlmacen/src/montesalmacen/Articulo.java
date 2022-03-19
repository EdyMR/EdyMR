/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montesalmacen;

import java.util.Objects;

/**
 *
 * @author daw122
 */
public class Articulo implements Comparable<Articulo> {

    private String codigo;
    private String descripcion;
    private int existencias;

    public Articulo() {
        codigo = "0000/00.X";
    }

    public Articulo(String codigo, String descripcion, int existencias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.existencias = existencias;
    }

    public Articulo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        existencias = 500;
    }

    public Articulo(String codigo) {
        this.codigo = codigo;
        descripcion = "arandelas";
        existencias = 500;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    static boolean validarCodigo(String codigo) {
        if (codigo.matches("[0-9]{4}/[0-9]{2}\\.[A-Z]{1,3}")) {
            return true;
        } else {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("El formato del código no es correcto.");
            return false;
        }
    }

    static boolean validarDescripcion(String descripcion) {
        if (descripcion.matches("[A-Za-z0-9 ]{3,10}")) {
            return true;
        } else {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("La descripción no es válida. Introduce una cadena de entre 3 y 10 caracteres.");
            return false;
        }
    }

    static boolean validarExistencias(int existencias) {
        if (existencias < 1000 && existencias >= 0) {
            return true;
        } else {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("La cantidad de existencias debe estar comprendida entre 0 y 1000");
            return false;
        }
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------"
        + "\nCódigo de artículo: " +codigo
        + "\nDescripción del artículo: "+descripcion
        + "\nNúmero de existencias: "+existencias
        + "\n----------------------------------------------------------------------";
    }
    
    @Override
    public int compareTo(Articulo t) {
        int comparacion = codigo.compareToIgnoreCase(t.codigo);
        return comparacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articulo other = (Articulo) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    

}
