package org.example;


import javax.persistence.*;
import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni", unique = true)
    private int dni;

    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;

    }
}
