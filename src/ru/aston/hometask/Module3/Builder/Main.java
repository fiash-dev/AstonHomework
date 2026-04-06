package ru.aston.hometask.Module3.Builder;

public class Main {
    public static void main(String[] args) {
        Car carPorshe = Car.builder()
                .setModel("Spyder")
                .setColor("Blue")
                .setYear(2024)
                .setPower(500)
                .isAutomaticTransmission(true)
                .build();

        Car carLada = Car.builder()
                .setModel("Vesta")
                .setColor("White")
                .setYear(2017)
                .setPower(106)
                .isAutomaticTransmission(false)
                .build();

        System.out.println(carPorshe);
        System.out.println(carLada);
    }
}