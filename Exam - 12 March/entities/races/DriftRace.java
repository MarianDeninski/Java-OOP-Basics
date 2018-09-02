package nfs.entities.races;

import nfs.entities.cars.Car;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriftRace extends Race {


    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String determineWinner() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.getRoute()+" - "+super.getLength());


        int counter = 1;


        List<Car> sorted = super.getParticipants().stream().sorted((a, b)->
                b.suspensionPerformance() - a.suspensionPerformance()).collect(Collectors.toList());


        for (Car car : sorted) {
            sb.append(System.lineSeparator());
            if(counter==1) {
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.suspensionPerformance() + "PP - " + "$" +(long) (super.getPrizePool() * 0.5));

            }
            else if(counter==2){
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.suspensionPerformance() + "PP - " + "$" +(long) (super.getPrizePool() * 0.3));
            }
            else if(counter==3){
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.suspensionPerformance() + "PP - " + "$" + (long)(super.getPrizePool() * 0.2));
                break;
            }
            counter++;

        }


        return sb.toString().trim();

    }
}
