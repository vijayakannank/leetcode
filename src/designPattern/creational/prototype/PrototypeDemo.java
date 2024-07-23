package designPattern.creational.prototype;

import java.util.List;

public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee();
        employee.loadEmployee();

        Employee e2 = (Employee) employee.clone();
        List<String> list = e2.getEmployees();
        list.add("klsd");

        System.out.println(employee.getEmployees());
    }
}
