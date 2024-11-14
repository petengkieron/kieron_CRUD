package tchounkeu.kieron.controllers;

import tchounkeu.kieron.models.Car;
import tchounkeu.kieron.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    // GET - Récupère tous les véhicules
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    // GET - Récupère un véhicule par ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.findById(id);
        return car.map(value -> ResponseEntity.ok(value))
                  .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST - Crée un nouveau véhicule
    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car createdCar = carService.save(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    // PUT - Met à jour un véhicule existant
    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody Car car) {
        Optional<Car> existingCar = carService.findById(id);
        if (existingCar.isPresent()) {
            car.setId(id);
            Car updatedCar = carService.save(car);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DELETE - Supprime un véhicule par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        if (carService.findById(id).isPresent()) {
            carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
