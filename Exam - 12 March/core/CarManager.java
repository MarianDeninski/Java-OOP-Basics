package nfs.core;

import nfs.entities.cars.Car;
import nfs.entities.cars.PerformanceCar;
import nfs.entities.cars.ShowCar;
import nfs.entities.garages.Garage;
import nfs.entities.races.CasualRace;
import nfs.entities.races.DragRace;
import nfs.entities.races.DriftRace;
import nfs.entities.races.Race;

import java.util.LinkedHashMap;

import java.util.Map;

public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {

        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();

    }

    public void register(int id, String type, String brand, String model, int yearOfProduction
            , int horsepower, int acceleration, int suspension, int durability) {

        Car car = null;

        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }

        this.cars.put(id, car);

    }

    public String check(int id) {

        if (this.cars.containsKey(id)) {

            return this.cars.get(id).toString();
        }
       else if(this.garage.getParkedCars().contains(this.cars.get(id))){
            return this.cars.get(id).toString();
        }
        else{

            for (Race race : this.races.values()) {

                if(race.getParticipants().contains(this.cars.get(id))){

                    return this.cars.get(id).toString();

                }
            }

        }
        return "";
    }

    public void open(int id, String type, int length, String route, int prizePool) {

        Race race = null;

        switch (type) {
            case "Casual":
                race = new CasualRace(length,route,prizePool);
                break;

            case "Drag":
                race = new DragRace(length,route,prizePool);
                break;

            case "Drift":
                race = new DriftRace(length,route,prizePool);
                break;
        }

        this.races.put(id,race);
    }

    public void participate(int carId, int raceId) {

        if(!this.garage.getParkedCars().contains(this.cars.get(carId))){



                this.races.get(raceId).getParticipants().add(this.cars.get(carId));


        }
    }

    public String start(int id) {


        if(this.races.get(id).getParticipants().size()==0){
            return "Cannot start the race with zero participants.";
        }

        String string = this.races.get(id).determineWinner();





        this.races.remove(id);
        return string;
    }

    public void park(int id) {



        for (Map.Entry<Integer,Race> map : this.races.entrySet()) {

            if(map.getValue().getParticipants().contains(this.cars.get(id))){

                return;
            }
        }
            this.garage.setParkedCars(this.cars.get(id));

    }

    public void unpark(int id) {

      this.garage.getParkedCars().remove(this.cars.get(id));



    }

    public void tune(int tuneIndex, String addOn) {

        for (Car car : this.garage.getParkedCars()) {
            if(car.getClass().getSimpleName().equals("PerformanceCar")){

                car.setAddOns(tuneIndex,addOn);
            }
            else if(car.getClass().getSimpleName().equals("ShowCar")){

                car.setAddOns(tuneIndex);

            }

        }


    }
}
