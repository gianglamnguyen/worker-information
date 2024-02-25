
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Worker implements Comparable<Worker>{
    
    protected String id;
    protected Name name;
    protected int age;
    protected int salary;
    protected String local;
    protected String status;
    protected LocalDate date;
    
    public Worker(){}

    public Worker(String id, Name name, String age, String salary, String local, String status, String date) {
        this.id = id;
        this.name = name;
        this.age = Integer.parseInt(age);
        this.salary = Integer.parseInt(salary);
        this.local = local;
        this.status = status;
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

     public String getAge() {
        return String.valueOf(age);
    }

    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public String getSalary() {
        return String.valueOf(salary);
    }

    public void setSalary(String salary) {
        this.salary = Integer.parseInt(salary);
    }


    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date);
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-10s%-15s%-10s%-20s", id, printName(), age, salary, status, date);
    }
    
    public String printName(){
        return name.fName + " " + name.lName;
    }

    @Override
    public int compareTo(Worker o) {
        return this.id.compareTo(o.id);
    }
}
