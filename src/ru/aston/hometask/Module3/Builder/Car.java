package ru.aston.hometask.Module3.Builder;

public class Car {
    private final String model;
    private final String color;
    private final int year;
    private final int power;
    private final boolean automaticTransmission;

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

    private Car(Builder builder) {
        this.model = builder.model;
        this.color = builder.color;
        this.year = builder.year;
        this.power = builder.power;
        this.automaticTransmission = builder.automaticTransmission;
    }

    public static Builder builder() {
        return new Builder();
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
            if (year < 1980) {
                throw new IllegalStateException("Год модели не должно быть меньше 1980");
            }
            this.year = year;
            return this;
        }

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Builder isAutomaticTransmission(boolean automaticTransmission) {
            this.automaticTransmission = automaticTransmission;
            return this;
        }

        public Car build() {
            if (model == null || model.trim().isEmpty()) {
                throw new IllegalStateException("Модель обязательна для заполнения");
            }
            if (year < 1980) {
                throw new IllegalStateException("Год модели не должно быть меньше 1980");
            }
            return new Car(this);
        }
    }
}