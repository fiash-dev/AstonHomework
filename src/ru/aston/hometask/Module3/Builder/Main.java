package ru.aston.hometask.Module3.Builder;

public class Main {
    public static void main(String[] args) {
        Car carPorshe = new Car.Builder()
                .setModel("Spyder")
                .setColor("Blue")
                .setYear(2024)
                .setPower(500)
                .setAutomaticTransmission(true)
                .build();

        Car carLada = new Car.Builder()
                .setModel("Vesta")
                .setColor("White")
                .setYear(2017)
                .setPower(106)
                .setAutomaticTransmission(false)
                .build();

        System.out.println(carPorshe);
        System.out.println(carLada);
    }
}
