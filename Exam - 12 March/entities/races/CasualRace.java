package nfs.entities.races;

import nfs.entities.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CasualRace extends Race {


    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String determineWinner() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.getRoute()+" - "+super.getLength());


        int counter = 1;


        List<Car> sorted = super.getParticipants().stream().sorted((a, b)->
                b.overallPerformance() - a.overallPerformance()).collect(Collectors.toList());

        for (Car car : sorted) {
            sb.append(System.lineSeparator());
            if(counter==1) {
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.overallPerformance() + "PP - " + "$" +(long) (super.getPrizePool() * 0.5));

            }
           else if(counter==2){
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.overallPerformance() + "PP - " + "$" +(long) (super.getPrizePool() * 0.3));
            }
           else if(counter==3){
                sb.append(counter + ". " + car.getBrand() + " " + car.getModel() + " " + car.overallPerformance() + "PP - " + "$" + (long)(super.getPrizePool() * 0.2));
                break;
            }
            counter++;

        }


         return sb.toString().trim();

    }
}
