package tchounkeu.kieron.repositories;

import tchounkeu.kieron.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    // Méthodes CRUD de base fournies par JpaRepository
}
