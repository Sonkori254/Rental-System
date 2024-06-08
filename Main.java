import java.util.ArrayList;
import java.util.List;

class Car {
    private String make;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean available;

    public Car(String make, String model, int year, double pricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}

class Customer {
    private String name;
    private String email;
    private List<Car> rentedCars;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedCars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }
}

class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void rentCar(Customer customer, Car car) {
        if (car.isAvailable()) {
            car.setAvailable(false);
            customer.getRentedCars().add(car);
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    public void returnCar(Customer customer, Car car) {
        if (customer.getRentedCars().contains(car)) {
            car.setAvailable(true);
            customer.getRentedCars().remove(car);
        } else {
            System.out.println("Customer did not rent this car.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, 50.0);
        Car car2 = new Car("Honda", "Civic", 2019, 40.0);

        Customer customer1 = new Customer("Emmanuel", "emmanuelsonko5@gmail.com");

        RentalAgency rentalAgency = new RentalAgency();
        rentalAgency.addCar(car1);
        rentalAgency.addCar(car2);
        rentalAgency.addCustomer(customer1);

        rentalAgency.rentCar(customer1, car1);

        System.out.println(customer1.getName() + " has rented the following cars:");
        for (Car car : customer1.getRentedCars()) {
            System.out.println(car.getMake() + " " + car.getModel());
        }

        rentalAgency.returnCar(customer1, car1);

        System.out.println(customer1.getName() + "'s rented cars after return:");
        for (Car car : customer1.getRentedCars()) {
            System.out.println(car.getMake() + " " + car.getModel());
        }
    }
}

