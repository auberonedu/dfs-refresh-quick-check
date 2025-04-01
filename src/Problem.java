import java.util.*;

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
        //account for nulls
        //make a set 
        //call to helper method

        if (initialPatient == null) return 0;

        Set<Salamander> visited = new HashSet<>();

        return countSeriousInfectionsHelper(initialPatient, visited);

    }

    private static int countSeriousInfectionsHelper(Salamander current, Set<Salamander> visited) {
        //base case, check for nulls 
        //mark the visited
        //logic, include the initial patient if it is less than 3 years old 
        //for each 
            //traverse
            //
    }
}
