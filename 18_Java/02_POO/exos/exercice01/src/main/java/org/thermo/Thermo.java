package org.thermo;

public class Thermo {
    private double temperatureKelvin;

    public Thermo(double temperature, UniteTemperature uniteTemperature) {
        switch (uniteTemperature){
            case KELVIN:
                setTemperatureKelvin(temperature);
                break;
            case CELSIUS:
                setTemperatureCelsius(temperature);
                break;
            case FAHRENHEIT:
                setTemperatureFahrenheit(temperature);
                break;

        }
    }

    public double getTemperatureKelvin() {
        return temperatureKelvin;
    }

    public double getTemperatureCelsius() {
        return temperatureKelvin - 273.15;
    }

    public double getTemperatureFahrenheit() {
        return temperatureKelvin * 9/5 - 459.67;
    }

    public void setTemperatureKelvin(double temperature) {
        if (temperature < 0){
            temperature = 0;
        }
        this.temperatureKelvin = temperature;
    }

    public void setTemperatureCelsius(double temperature) {
        setTemperatureKelvin(temperature + 273.15);
    }

    public void setTemperatureFahrenheit(double temperature) {
        setTemperatureKelvin((temperature + 459.67) * 5/9);
    }
}
