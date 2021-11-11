class Car {
    private int speed;
    private int regularPrice;
    private String color;
    private double getSalePrice;

    public Car(int speed, int regularPrice, String color, double getSalePrice) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public double getSalePrice() {
        return regularPrice;
    }

    static class Truck extends Car {
        private int weight;
        private double getSalePrice;

        public Truck(int speed, double regularPrice, String color, int weight, double getSalePrice) {
            super(speed, (int) regularPrice, color, getSalePrice);
            this.weight = weight;
        }

        public Truck(int speed, double regularPrice, String color, double getSalePrice) {
            super(speed, (int) regularPrice, color, getSalePrice);
        }

        public double getSalePrice() {
            return super.getSalePrice() * (weight > 2000 ? 0.10 : 0.20);
        }
    }

    static class Ford extends Car {
        private int year;
        public int manufacturerDiscount;

        public Ford(int speed, double regularPrice, String color, int weight, double getSalePrice, int year, int manufacturerDiscount) {
            super(speed, (int) regularPrice, color, getSalePrice);
            this.year = year;
            this.manufacturerDiscount = manufacturerDiscount;
        }

        public double getSalePrice() {
            return super.getSalePrice() - manufacturerDiscount;
        }
    }

    static class Sedan extends Car {
        private static double getSalePrice;
        private int lenght;

        public Sedan(int speed, double regularPrice, String color, int weight, double getSalePrice, int year, int manufacturerDiscount, int lenght) {
            super(speed, (int) regularPrice, color, getSalePrice);
            this.lenght = lenght;
        }

        public double getSalePrice() {
            return super.getSalePrice() * (lenght > 20 ? 0.05 : 0.10);
        }
    }
    public static class MyOwnAutoShop {
        public static void main(String[] args) {
            Car car = new Car(160, 400000, "white", 4000000);
            Car.Truck truck = new Car.Truck(200, 1000000, "red", 20, 20000);
            Car.Ford ford = new Car.Ford(180, 600000, "red", 20, 200000, 2021, 30);
            Car.Sedan sedan = new Car.Sedan(220, 800000, "red", 40, 20, 2020, 15, 20);
            System.out.println("Car " + car.getSalePrice());
            System.out.println("Truck " + truck.getSalePrice());
            System.out.println("Ford " + ford.getSalePrice());
            System.out.println("Sedan " + sedan.getSalePrice());

        }
    }
}