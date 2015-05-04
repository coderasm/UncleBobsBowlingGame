import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pkrueger on 5/2/2015.
 */
public class BowlingGameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    private void rollMany(int n, int pins) {
        for(int i = 0;i < n; i++)
            game.roll(pins);
    }

    @Test
    public void WhenRollingAGutterGame_ThenTheScoreIsZero() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void  WhenRollingAllOnes_ThenTheScoreIsTwenty() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void WhenRollingOneSpareInGame_ThenScoreIsSixteen() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void WhenRollingOneStrikeInGame_ThenScoreIsTwentyFour() throws Exception {
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void WhenRollingAllStrikesInGame_ThenScoreIsThreeHundred() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
}