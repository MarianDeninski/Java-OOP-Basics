package model.colonists;

import model.Colonist;

public class Soldier extends Colonist {

    private static final int BONUS = 6;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        return BONUS;
    }
}
