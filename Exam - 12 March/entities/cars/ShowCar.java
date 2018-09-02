package nfs.entities.cars;

public class ShowCar extends Car {

    private int stars;
    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);

        this.stars = 0;
    }

    @Override
    public void setAddOns(Object... arg) {
        super.setHorsepower((int)arg[0]);
        super.setSuspension((int)arg[0]/2);
        this.stars += (int)arg[0];
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
        sb.append(this.stars+" *");

        return sb.toString().trim();
    }
}
