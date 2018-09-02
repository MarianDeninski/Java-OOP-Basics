package nfs.entities.races;


import nfs.entities.cars.Car;

import java.util.*;


public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private Collection<Car> participants;

    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedList<>();

    }

   public abstract String determineWinner();




    public int getLength() {
        return length;
    }

    public String getRoute() {
        return route;
    }

    public int getPrizePool() {
        return prizePool;
    }

    public List<Car> getParticipants() {
        return (List<Car>) participants;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
