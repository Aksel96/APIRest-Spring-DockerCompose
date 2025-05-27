package mx.unam.aragon.ico.is.videojuegos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "videojuegos")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_videojuego", nullable = false, length = 100)
    @NotBlank(message = "No recibe blancos")
    @NotNull(message = "No deberia ser nulo")
    private String nombre;

    @Column(name = "genero_videojuego",
            columnDefinition = "VARCHAR(100) not null")
    private String genero;

    @Column(name = "url_portada",
            nullable = true,
            insertable = false,
        columnDefinition = "VARCHAR(250) DEFAULT 'https://cdn.shopify.com/s/files/1/0533/2089/files/placeholder-images-image_large.png'")
    private String portada;

    @Column(name = "precio_pesos",nullable = true)
    private Float precio;

    public Videojuego() {
    }

    public Videojuego(Long id, String nombre, String genero, String portada, Float precio) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.portada = portada;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Videojuego that = (Videojuego) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(genero, that.genero) && Objects.equals(portada, that.portada) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, genero, portada, precio);
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", portada='" + portada + '\'' +
                ", precio=" + precio +
                '}';
    }
}
