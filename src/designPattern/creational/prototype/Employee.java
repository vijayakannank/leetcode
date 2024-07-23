package designPattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable{

    private List<String> employees;

    Employee(){
        this.employees = new ArrayList<>();
    }

    Employee(List<String> list){
        this.employees = list;
    }

    void loadEmployee(){
        employees.add("Vijay");
        employees.add("Vj");
        employees.add("Vj kannan");
    }
    List<String> getEmployees(){
        return employees;
    }

    protected Object clone() throws CloneNotSupportedException {
        return new Employee(new ArrayList<>(employees));
    }
}
