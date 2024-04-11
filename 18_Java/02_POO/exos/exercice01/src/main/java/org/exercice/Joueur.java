package org.exercice;

public class Joueur {
    private String name;
    private int level = 1;
    private int experiencePoints = 0;

    public Joueur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(this.name+ " change de pseudo: " + name);
        this.name = name;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
    public void quest(){
        setExperiencePoints(experiencePoints+10);
        levelUp();
    }

    public void levelUp(){
        if(experiencePoints > 100){
            setExperiencePoints(0);
            setLevel(level+1);
            System.out.println("Level up ! " + getLevel());
        }
    }


}
