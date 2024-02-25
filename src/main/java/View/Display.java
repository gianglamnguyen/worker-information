
package View;

import Model.History;
import Model.Worker;

public class Display {
    
    public void printLog(History hl) {
        if (hl.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("--------------------Display Information Salary-----------------------");
            System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n", "ID", "Name", "Age", "Salary", "Status", "Date");
            for (Worker w : hl) {
                System.out.println(w);
            }
        }
    }
    
    public void printRecent(Worker w){
        System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n", "ID", "Name", "Age", "Salary", "Status", "Date");
        System.out.println(w);
    }
}