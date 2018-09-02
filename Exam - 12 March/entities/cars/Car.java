package nfs.entities.cars;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;



    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        setHorsepower(horsepower);
        this.acceleration = acceleration;
        setSuspension(suspension);
        this.durability = durability;

    }
    protected void setHorsepower(int horsepower){

        this.horsepower += horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension += suspension;
    }

    public abstract void setAddOns(Object...arg);

    public int overallPerformance(){


        return (this.horsepower/this.acceleration) + (this.suspension + this.durability);
    }

    public int enginePerformance(){

        return this.horsepower/this.acceleration;
    }

    public int suspensionPerformance(){


        return this.suspension+this.durability;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public String toString() {
        return "";
    }
}
