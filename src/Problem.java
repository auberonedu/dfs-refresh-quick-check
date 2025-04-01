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
        return -1;
    }

    private static int helper(Salamander patient, Set<Salamander> infected) {
        if (infected.contains(patient) || patient == null) return 0;
        int count = 0;
        infected.add(patient);

        for(Salamander contact : patient.getContacts()) {
            if (contact.getAge() < 3) {
                count++;
            }
            count += helper(contact, infected);
        }
        return count;
    }
}
