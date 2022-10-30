import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TennisGameEdgeCasesTest {

    @Test
    void unknownPlayerGivesErrorTennisGame1() {
        // Given
        TennisGame1 tennisGame1 = new TennisGame1("player1", "player2");
        // When / Then
        assertThrows(IllegalArgumentException.class, () -> tennisGame1.wonPoint("player3"));
    }
}