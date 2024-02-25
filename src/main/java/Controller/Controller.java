
package Controller;

import Common.Library;
import Common.Validation;
import Model.History;
import Model.Name;
import Model.Worker;
import Model.WorkerList;
import View.Display;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import view.Menu;

public class Controller extends Menu<String>{
    
    private Menu parentMenu;
    private static String[] mc = {"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};
    private Library lib;
    private WorkerList wList;
    private Validation vl;
    private History h;
    private Display dp;
    
    public Controller (Menu parentMenu){
        super("======== Worker Management =========", mc, parentMenu);
        this.parentMenu = parentMenu;
        wList = new WorkerList();
        lib = new Library();
        vl = new Validation();
        h = new History();
        dp = new Display();
    }
    
    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                try{
                    addWorker();
                } catch(DateTimeParseException ex) {
                    System.err.println(ex.getMessage());
                } catch(NumberFormatException ex){
                    System.err.println("Age and salary must be number");
                } catch(Exception ex){
                    System.err.println(ex.getMessage());
                } 
                break;
            case 2:
                try{
                    upSalary();
                } catch(DateTimeParseException ex) {
                    System.err.println(ex.getMessage());
                }  catch(NumberFormatException ex){
                    System.err.println("Salary must be number");
                } catch(Exception ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case 3:
                try{
                    downSalary();
                } catch(DateTimeParseException ex) {
                    System.err.println(ex.getMessage());
                }  catch(NumberFormatException ex){
                    System.err.println("Salary must be number");
                } catch(Exception ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case 4:
                displayHistory();
                break;
            case 5:
                System.exit(0);
        }
    }
    
    public void addWorker() throws Exception{
        System.out.println("\n--------- Add Worker ----------");
        String id = lib.getString("Enter Code:");
        String fName = lib.getString("Enter first name: ");
        String lName = lib.getString("Enter last name: ");
        Name n = new Name(fName, lName);
        String age = lib.getString("Enter Age:");
        String salary = lib.getString("Enter Salary:");
        String l = lib.getString("Enter work location:");
        String s = "-";
        String d = lib.getString("Enter date:");
        vl.validateWorker(id, age, salary, d);
        vl.checkId(id, wList);
        Worker w = new Worker(id, n, age, salary, l, s, d);
        wList.add(w);
        h.add(new Worker(id, n, age, salary, l, s, d));
        dp.printRecent(w);
    }
    
    public void upSalary() throws Exception{
        System.out.println("\n------- Up/Down Salary --------");
        String id = lib.getString("Enter Code:");
        String salary = lib.getString("Enter salary:");
        String date = lib.getString("Enter date:");
        vl.validateId(id);
        vl.validateSalary(salary);
        vl.validateDate(date);

        Worker w = wList.findById(id);
        if (w == null) {
            throw new Exception("ID does not exist");
        } else{
            h.add(new Worker(id, w.getName(), w.getAge(), salary, w.getLocal(), "UP", date));
            w.setSalary(salary);
            w.setStatus("UP");
            w.setDate(date);
            System.out.println("Salary updated successfully.");
            dp.printRecent(w);
        }
    }

    public void downSalary() throws Exception{
        System.out.println("\n------- Up/Down Salary --------");
        String id = lib.getString("Enter Code:");
        String salary = lib.getString("Enter salary:");
        String date = lib.getString("Enter date:");
        vl.validateId(id);
        vl.validateSalary(salary);
        vl.validateDate(date);

        Worker w = wList.findById(id);
        if (w == null) {
            throw new Exception("ID does not exist");
        } else {
            h.add(new Worker(id, w.getName(), w.getAge(), salary, w.getLocal(), "DOWN", date));
            w.setSalary(salary);
            w.setStatus("DOWN");
            w.setDate(date);
            System.out.println("Salary updated successfully.");
            dp.printRecent(w);
        }
    }
    public void displayHistory(){
        dp.printLog(h);
    }
}