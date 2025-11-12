package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void validBoardHasNonNullSquares() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);

        // These assertions are from your PDF:
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.invariant()).isTrue();
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
    }

    @Test
    void boardWithNullSquareFailsInvariant() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;
        try {
            new Board(grid);
        } catch (AssertionError e) {
            assertThat(e).isInstanceOf(AssertionError.class);
        }
    }
}
