package org.thermo;

public class Main {
    public static void main(String[] args) {
        Thermo thermo1 = new Thermo(20, UniteTemperature.CELSIUS);
        Thermo thermo2 = new Thermo(-459.66, UniteTemperature.FAHRENHEIT);
        Thermo thermo3 = new Thermo(-25, UniteTemperature.KELVIN);

        System.out.println("Thermo 1  en kelvin est : "+thermo1.getTemperatureKelvin());
        System.out.println("Thermo 1 La température en celsius est : "+thermo1.getTemperatureCelsius());
        System.out.println("Thermo 1 La température en Fahrenheit est : "+thermo1.getTemperatureFahrenheit());

        System.out.println("Thermo 2  en kelvin est : "+thermo2.getTemperatureKelvin());
        System.out.println("Thermo 2 La température en celsius est : "+thermo2.getTemperatureCelsius());
        System.out.println("Thermo 2 La température en Fahrenheit est : "+thermo2.getTemperatureFahrenheit());

        System.out.println("Thermo 3  en kelvin est : "+thermo3.getTemperatureKelvin());
        System.out.println("Thermo 3 La température en celsius est : "+thermo3.getTemperatureCelsius());
        System.out.println("Thermo 3 La température en Fahrenheit est : "+thermo3.getTemperatureFahrenheit());

    }
}
