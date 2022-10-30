
public class TennisGame1 implements TennisGame {

    public static final int TOTAL_SETS_IN_GAME = 3;
    private int player1Score;
    private int player2Score;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else if (playerName.equals(player2Name)) {
            player2Score++;
        } else {
            throw new IllegalArgumentException(String.format("This game has only the following players: %s, %s", player1Name, player2Name));
        }
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < TOTAL_SETS_IN_GAME; i++) {
                int tempScore;
                if (i == 1) {
                    tempScore = player1Score;
                } else {
                    score += "-";
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}
