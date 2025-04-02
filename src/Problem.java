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
     * Include the initial patient in the count if the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */
    public static int countSeriousInfections(Salamander initialPatient) {
        // Components for a Salamander
        // - private int age;
        // - private Set<Salamander> contacts;

        // HashSet to keep track of visited nodes
        Set<Salamander> visited = new HashSet<>();

        // return the result of the helper method
        return depthFirstSearch(initialPatient, visited);
    }

    // Helper Method
    private static int depthFirstSearch(Salamander tuShan, Set<Salamander> visited) {
        // Check if the given Set contains the given Salamander
        if (visited.contains(tuShan))
            return 0;

        // Add the given Salamander to the Set
        visited.add(tuShan);

        // Count variable to keep track of how many Salamanders are at risk of infection
        int count = 0;

        // if the given Salamanders' age is less than 3 set count = 1, otherwise set it
        // to 0
        if (tuShan.getAge() < 3) {
            count = 1;
        } else {
            count = 0;
        }

        for (Salamander contact : tuShan.getContacts()) {
            // Add the recursive result to the count
            count += depthFirstSearch(contact, visited);
        }

        return count;

    }
}
