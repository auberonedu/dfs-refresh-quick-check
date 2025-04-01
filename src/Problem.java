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
        if (initialPatient == null) return 0;

        Set<Salamander> visited = new HashSet<>();
        return countSeriousInfectionsHelper(initialPatient, visited);
    }

    private static int countSeriousInfectionsHelper(Salamander current, Set<Salamander> visited) {
        if (current == null || visited.contains(current)) return 0;

        visited.add(current);

        int count = 0;
        if (current.getAge() < 3) {
            count++; 
        }

        for (Salamander neighbor : current.getContacts()) {
            count += countSeriousInfectionsHelper(neighbor, visited); 
        }
        
        return count;
    }
}
