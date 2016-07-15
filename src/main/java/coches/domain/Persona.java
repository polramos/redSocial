package coches.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity //para que la clase sea una identidad dentro de la base de datos
public class Persona {
    @Id // identificador. 2 objetos de la misma base de datos no pueden tener el mismo identificador
    @GeneratedValue(strategy = GenerationType.AUTO)// el id se genera automaticamente
    private Long id;
    private String nombre;
    private String apellido;
    private Integer age;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "age=" + age +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (getId() != null ? !getId().equals(persona.getId()) : persona.getId() != null) return false;
        if (getNombre() != null ? !getNombre().equals(persona.getNombre()) : persona.getNombre() != null) return false;
        if (getApellido() != null ? !getApellido().equals(persona.getApellido()) : persona.getApellido() != null)
            return false;
        return getAge() != null ? getAge().equals(persona.getAge()) : persona.getAge() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        result = 31 * result + (getApellido() != null ? getApellido().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }
}

