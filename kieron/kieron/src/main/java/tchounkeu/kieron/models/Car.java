package tchounkeu.kieron.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Le modèle est obligatoire")
    @Size(min = 2, message = "Le modèle doit comporter au moins 2 caractères")
    private String model;

    @NotNull(message = "La marque est obligatoire")
    @Size(min = 2, message = "La marque doit comporter au moins 2 caractères")
    private String brand;

    private LocalDate releaseDate;

    @NotNull(message = "Le statut est obligatoire")
    private String status; // "available" ou "borrowed"

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
