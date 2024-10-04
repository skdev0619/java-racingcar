package racingCar.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RacingCars {

    private static final String CAR_NAME_SEPARATOR = ",";

    private final List<RacingCar> cars;

    private RacingCars(List<RacingCar> cars){
        this.cars = cars;
    }

    public static RacingCars createCarsWithNames(String names){
        List<RacingCar> cars = new ArrayList<>();
        String[] nameArray = splitName(names);
        for (String name : nameArray) {
            RacingCar car = RacingCar.createCarWithName(name);
            cars.add(car);
        }
        return new RacingCars(cars);
    }

    private static String[] splitName(String names) {
        return names.split(CAR_NAME_SEPARATOR);
    }

    public void move(RandomNumber randomNumber) {
        for (RacingCar car : cars) {
            car.move(randomNumber.generate());
        }
    }

    public int getMaxCarPosition() {
        int maxCarPosition = 0;
        for (RacingCar car : cars) {
            maxCarPosition = Math.max(maxCarPosition, car.getPosition());
        }
        return maxCarPosition;
    }

    public List<RacingCar> findCarsByPosition(int maxCarPosition) {
        List<RacingCar> samePositionCars = new ArrayList<>();
        for (RacingCar car : cars) {
            if(car.isCurrentPosition(maxCarPosition)) samePositionCars.add(car);
        }
        return samePositionCars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}

