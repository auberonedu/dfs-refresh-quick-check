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
     * Include the initial patient in the count if the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */
    public static int countSeriousInfections(Salamander initialPatient) {
        //initialize HashSet to track visited nodes
        Set<Salamander> visited = new HashSet<>();
        //return helper/recursion method
        return dfs(initialPatient, visited);

        //I wanted to accomplish without helper method
        //This works but uses BFS instead of DFS 
        //So I commented this out but wanted to keep it
        
        // Set<Salamander> visited = new HashSet<>(); 
        // Queue<Salamander> cueBall = new LinkedList<>();

        // int count = 0;
        // cueBall.add(initialPatient);

        // while (!cueBall.isEmpty()) {
        //     Salamander current = cueBall.poll();

        //     if (visited.contains(current)) continue;
        //     visited.add(current);

        //     if (current.getAge() < 3) {
        //         count++;
        //     }

        //     for (Salamander contact : current.getContacts()) {
        //         if (!visited.contains(contact)) {
        //             cueBall.add(contact);
        //         }
        //     }
        // }
        // return count;
    }

    private static int dfs(Salamander slay, Set<Salamander> visited) {
        //base case
        if (visited.contains(slay)) return 0;
        visited.add(slay);

        //ternary op - condition (slay.getAge() < 3)
        int count = slay.getAge() < 3 ? 1 : 0;

        //for each iteration
        for (Salamander contact : slay.getContacts()) {
            //add recursion result to count
            count += dfs(contact, visited);
        }
        return count;
    }
}
