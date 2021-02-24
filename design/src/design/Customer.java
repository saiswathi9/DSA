package design;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Customers {
    private long id;
    private String name;

    public Customers(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Two customers are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customer = (Customers) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Customer {
    public static void main(String[] args) {
        Set<Customers> customers = new HashSet<>();
        customers.add(new Customers(101, "Rajeev"));
        customers.add(new Customers(102, "Sachin"));
        customers.add(new Customers(103, "Chris"));

        /*
          HashSet will use the `equals()` & `hashCode()` implementations 
          of the Customer class to check for duplicates and ignore them
        */
        customers.add(new Customers(101, "Rajeev"));

        System.out.println(customers);
    }
}