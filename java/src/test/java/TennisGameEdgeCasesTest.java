import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TennisGameEdgeCasesTest {

    public static final String PLAYER_1_NAME = "player1";
    public static final String PLAYER_2_NAME = "player2";

    @Test
    void unknownPlayerGivesErrorTennisGame1() {
        // Given
        TennisGame1 tennisGame1 = new TennisGame1(PLAYER_1_NAME, PLAYER_2_NAME);
        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> tennisGame1.wonPoint("player3"));
        assertTrue(exception.getMessage().contains(PLAYER_1_NAME));
        assertTrue(exception.getMessage().contains(PLAYER_2_NAME));
    }
}