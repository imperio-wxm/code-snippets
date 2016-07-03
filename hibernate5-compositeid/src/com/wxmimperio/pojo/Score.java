package com.wxmimperio.pojo;

/**
 * Created by wxmimperio on 2016/7/3.
 */
public class Score {
    private ScoreId scoreId;//组合键
    private double score;//分数

    public ScoreId getScoreId() {
        return scoreId;
    }

    public void setScoreId(ScoreId scoreId) {
        this.scoreId = scoreId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
