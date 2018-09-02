package nfs.entities.cars;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PerformanceCar extends Car {

    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction,  horsepower, acceleration, suspension, durability);

        this.addOns = new LinkedList<>();

    }
   @Override
   public void setHorsepower(int horsepower) {
       int inscresedHorsePower = horsepower +((horsepower * 50)/100);
       super.setHorsepower(inscresedHorsePower);
   }


    @Override
   public void setSuspension(int suspension) {
       int decreseSuspension = suspension - ((suspension * 25)/100);
       super.setSuspension(decreseSuspension);
   }

    @Override
    public void setAddOns(Object... arg) {
        super.setHorsepower((int)(arg[0]));
        super.setSuspension((int)(arg[0])/2);

        this.addOns.add((String) arg[1]);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %s",this.getBrand(),getModel(),getYearOfProduction()));
        sb.append(System.lineSeparator());
        sb.append(String.format("%s HP, 100 m/h in %s s",this.getHorsepower(),this.getAcceleration()));
        sb.append(System.lineSeparator());
        sb.append(String.format("%s Suspension force, %s Durability",this.getSuspension(),this.getDurability()));
        sb.append(System.lineSeparator());
        if(this.addOns.isEmpty()){
            sb.append("Add-ons: None");
        }else {
            sb.append("Add-ons: " + String.join(", ", this.addOns));
        }

        return sb.toString().trim();
    }
}
