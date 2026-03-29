package ru.aston.hometask.Module3.Builder;

public class Car {
    private final String model;
    private final String color;
    private final int year;
    private final int power;
    private final boolean automaticTransmission;

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.power = builder.power;
        this.automaticTransmission = builder.automaticTransmission;
    }

    @Override
    public String toString() {
        return "Автомобиль [" +
                "Модель: '" + model + '\'' +
                ", Цвет: '" + color + '\'' +
                ", Год выпуска: " + year +
                ", Мощность: " + power +
                ", Автоматическая коробка передач: " + automaticTransmission +
                ']';
    }

    public static class Builder {
        private String model;
        private String color;
        private int year;
        private int power;
        private boolean automaticTransmission;


        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder setAutomaticTransmission(boolean automaticTransmission) {
            this.automaticTransmission = automaticTransmission;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
