package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // A newly created unit should not be on any square.
        assertThat(unit.getSquare()).isNull();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Create a square for the unit to occupy.
        Square square = new BasicSquare();

        // Perform the occupation
        unit.occupy(square);

        // Assert that the unit's square is the one it occupied.
        assertThat(unit.getSquare()).isEqualTo(square);

        // Assert that the square's list of occupants contains the unit.
        assertThat(square.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square square1 = new BasicSquare();
        Square square2 = new BasicSquare();

        // 1. Occupy the first square
        unit.occupy(square1);

        // Assertions for the first occupation
        assertThat(unit.getSquare()).isEqualTo(square1);
        assertThat(square1.getOccupants()).contains(unit);

        // 2. Re-occupy with the second square
        unit.occupy(square2);

        // Assert that the unit is now on the second square
        assertThat(unit.getSquare()).isEqualTo(square2);
        assertThat(square2.getOccupants()).contains(unit);

        // IMPORTANT: Assert that the unit is NO LONGER on the first square
        assertThat(square1.getOccupants()).doesNotContain(unit);
    }
}
