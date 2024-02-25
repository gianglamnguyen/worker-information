
package Model;

import java.util.ArrayList;

public class WorkerList extends ArrayList<Worker>{
    
    public Worker findById(String id) {
        for (Worker f : this) {
            if (id.equals(f.getId())) {
                return f;
            }
        }
        return null;
    }
}
