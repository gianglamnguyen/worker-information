package Common;

import Model.WorkerList;

public class Validation {
    
    public void validateWorker(String id, String age, String salary, String date) throws Exception{
        validateId(id);
        validateAge(age);
        validateSalary(salary);
        validateDate(date);
    }

    public void validateId(String id) throws Exception{      
        if (id == null || id.isEmpty()) {
            throw new Exception("ID cannot be null or empty.");
        }

    }
    public void validateAge(String age) throws Exception {
        int a = Integer.parseInt(age);
        if (a <= 0) {
            throw new Exception("Age must be a positive integer.");
        }
    }

    public void validateSalary(String salary) throws Exception {
        int s = Integer.parseInt(salary);
        if (s <= 0) {
            throw new Exception("Salary must be a positive integer.");
        }
    }

    public void validateDate(String date) throws Exception {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        if (!date.matches(regex)) {
            throw new Exception("Invalid date format. Date must be in the format dd/mm/yyyy.");
        }
    }
    
    public void checkId(String id, WorkerList wl) throws Exception{
                
        if (wl.findById(id) != null){
            throw new Exception("ID has already existed");
        }
    }
}