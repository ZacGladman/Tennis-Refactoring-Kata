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
        String score;
        if (playerOneScore == playerTwoScore) {
            score = getEqualScore(playerOneScore);
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            score = getWinnerOrAdvantage(playerOneScore, playerTwoScore);
        } else {
            score = getDefaultScore();
        }
        return score;
    }

    public String getWinnerOrAdvantage(int playerOneScore, int playerTwoScore) {
        String score;
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
        return score;
    }

    public String getEqualScore(int score) {
        return switch (score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

    public String getDefaultScore() {
        return getSinglePlayersScore(playerOneScore) + "-" + getSinglePlayersScore(playerTwoScore);
    }

    public String getSinglePlayersScore(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            default -> "Forty";
        };
    }
}
