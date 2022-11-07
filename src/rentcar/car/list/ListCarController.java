package rentcar.car.list;

import rentcar.dao.impls.CarRepository;
import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class ListCarController {

    public Object getListCar() {
        List<Car> lstCar = new ArrayList<>();
        CarRepository carRepository = new IRepository<Car>;
        lstCar = carRepository.all();
        return ResponseEntity.status(HttpStatus.OK).body(lstCar);
    }
}