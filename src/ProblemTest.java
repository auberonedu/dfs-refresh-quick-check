import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//works
public class ProblemTest {
    Salamander sal;
    Salamander sally;
    Salamander samuel;
    Salamander sam;
    Salamander sandy;
    Salamander squiggles;
    Salamander slippy;
    Salamander sammy;

    @BeforeEach
    void setup() {
        sal = new Salamander(2);
        sally = new Salamander(1);
        samuel = new Salamander(5);
        sam = new Salamander(2);
        sandy = new Salamander(9);
        squiggles = new Salamander(2);
        slippy = new Salamander(1);
        sammy = new Salamander(7);

        sal.extendContacts(Set.of(sally));
        sally.extendContacts(Set.of(sandy, samuel));
        samuel.extendContacts(Set.of(squiggles));
        sam.extendContacts(Set.of(slippy, sammy));
        sandy.extendContacts(Set.of(sal));
        squiggles.extendContacts(Set.of());
        slippy.extendContacts(Set.of(samuel, sam, squiggles));
        sammy.extendContacts(Set.of());
    }

    @Test
    void testCountSeriousInfections() {
        int actual = Problem.countSeriousInfections(sal);
        assertEquals(3, actual);

        actual = Problem.countSeriousInfections(sally);
        assertEquals(3, actual);

        actual = Problem.countSeriousInfections(samuel);
        assertEquals(1, actual);

        actual = Problem.countSeriousInfections(sam);
        assertEquals(3, actual);

        actual = Problem.countSeriousInfections(sandy);
        assertEquals(3, actual);

        actual = Problem.countSeriousInfections(squiggles);
        assertEquals(1, actual);

        actual = Problem.countSeriousInfections(slippy);
        assertEquals(3, actual);

        actual = Problem.countSeriousInfections(sammy);
        assertEquals(0, actual);
    }
}
