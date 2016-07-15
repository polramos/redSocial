package coches.domain;

import javax.persistence.*;


@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String modelo;
    private String matricula;
    private Integer año;
    private double precio;
    @ManyToOne
    private Persona propietario;


    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "año=" + año +
                ", id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (Double.compare(coche.getPrecio(), getPrecio()) != 0) return false;
        if (getId() != null ? !getId().equals(coche.getId()) : coche.getId() != null) return false;
        if (getMarca() != null ? !getMarca().equals(coche.getMarca()) : coche.getMarca() != null) return false;
        if (getModelo() != null ? !getModelo().equals(coche.getModelo()) : coche.getModelo() != null) return false;
        if (getMatricula() != null ? !getMatricula().equals(coche.getMatricula()) : coche.getMatricula() != null)
            return false;
        return getAño() != null ? getAño().equals(coche.getAño()) : coche.getAño() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        result = 31 * result + (getAño() != null ? getAño().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrecio());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
