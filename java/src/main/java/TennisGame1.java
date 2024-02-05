import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1")) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (playerOneScore == playerTwoScore) {
            score = switch (playerOneScore) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            int minusResult = playerOneScore - playerTwoScore;
            if (minusResult == 1) {
                score = "Advantage player1";
            } else if (minusResult == -1) {
                score = "Advantage player2";
            } else if (minusResult >= 2) {
                score = "Win for player1";
            } else {
                score = "Win for player2";
            }
        } else {
            score += getOnePlayersScore(playerOneScore);
            score += "-";
            score += getOnePlayersScore(playerTwoScore);
        }
        return score;
    }

    public String getOnePlayersScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }
}
