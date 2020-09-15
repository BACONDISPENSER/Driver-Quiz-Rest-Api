package pl.coderslab.driver.entity;

public class Score {

    private int score;
    private int maxScore;
    private boolean passed;

    public Score(int score, int maxScore, boolean passed) {
        this.score = score;
        this.maxScore = maxScore;
        this.passed = passed;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
