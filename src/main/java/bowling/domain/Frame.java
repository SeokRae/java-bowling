package bowling.domain;

import bowling.score.Score;
import bowling.score.Scores;

import java.util.List;

public abstract class Frame {
    public static final int FIRST_FRAME = 1;
    public static final int LAST_FRAME = 10;

    protected int frameNumber;
    Scores scores;

    Frame(int frameNumber, Scores scores) {
        this.frameNumber = frameNumber;
        this.scores = scores;
    }

    public int getNumber() {
        return frameNumber;
    }

    public boolean getBy(int frameNumber) {
        return this.frameNumber == frameNumber;
    }

    public List<Score> getResult() {
        return scores.getResult();
    }

    public void bowl(Score score) {
        scores.add(score);
    }

    public boolean canBowl() {
        return scores.canBowl();
    }

    public abstract Frame next();
}