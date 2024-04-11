package org.citerne;

public class Citerne {
    private int unloadedWeight;
    private int maxCapacity;
    private int fillingRate;

    private static int fillingRateCiterne = 0;

    public Citerne(int unloadedWeight, int maxCapacity, int fillingRate)  {
        this.unloadedWeight = unloadedWeight;
        this.maxCapacity = maxCapacity;
        this.fillingRate = fillingRate;
        fillingRateCiterne += fillingRate;
    }

    public static int getFillingRateCiterne() {
        return fillingRateCiterne;
    }

    public int getFillingRate() {
        return fillingRate;
    }

    public int getUnloadedWeight() {
        return unloadedWeight;
    }

    public int getTotalWeight() {
        return unloadedWeight + fillingRate;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public int addFillingRate(int amount) {
        int fill = fillingRate + amount;
        if (fill > maxCapacity) {
            int excessWater = fill - maxCapacity;
            amount -= excessWater;
            fillingRate += amount;
            fillingRateCiterne += amount;
            return excessWater;
        }else {
            fillingRate += amount;
            fillingRateCiterne += amount;
            return 0;
        }
    }

    public int emptyFillingRate(int amount) {
        int fill = fillingRate - amount;
        if(fill < 0){
            amount += fill;
        }
        fillingRate -= amount;
        fillingRateCiterne += amount;
        return amount;
    }


}
