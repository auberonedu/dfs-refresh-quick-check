import java.util.HashSet;
import java.util.Set;

public class Problem {
    /**
     * Returns how many salamanders less than 3 years old will be at risk from a
     * serious infection if a given salamander is infected.
     * 
     * When a salamander is infected, it will pass the disease along to all of
     * its contacts. Each of those contacts will pass it on to their contacts
     * and so on. Salamanders of any age can catch and spread the disease, but
     * it is only a serious risk for salamanders strictly less than 3 years old.
     * 
     * Include the initial patient in the count iff the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */


    public static int countSeriousInfections(Salamander initialPatient) {
        Set<Salamander> visited = new HashSet<>();
        return countSeriousInfections(initialPatient, visited, 0);
    }

    private static int countSeriousInfections(Salamander current, Set<Salamander> visited, int count){
        if (current == null || !visited.add(current)) return count;

        if (current.getAge() < 3) count++;

        for (var contact : current.getContacts()){
            count = countSeriousInfections(contact, visited, count);
        }

        return count;
    }
}
