package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int scoreA=0,scoreB=0;
    private String matchStart="The match has Started !!";
    private String matchEnd="The match has Ended !!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
     public void addScore1ToA(View view) {
        scoreA += 1;
        setScore();
        showStatus();
     }
    public void addScore2ToA(View view) {
        scoreA += 2;
        setScore();
        showStatus();
    }
    public void addScore3ToA(View view) {
        scoreA += 3;
        setScore();
        showStatus();
    }
    public void addScore1ToB(View view) {
        scoreB += 1;
        setScore();
        showStatus();
    }
    public void addScore2ToB(View view) {
        scoreB += 2;
        setScore();
        showStatus();
    }
    public void addScore3ToB(View view) {
        scoreB += 3;
        setScore();
        showStatus();
    }
    private void showStatus() {
        String status = getStatus();
        TextView res = (TextView) findViewById(R.id.status);
        res.setText(status);
    }

    private String getStatus() {
        String res;
        if(scoreA==scoreB) {
            res = "Both the teams have equal scores";
        }
        else if(scoreA>scoreB) {
            res = "Team A is leading by " + (scoreA-scoreB) + " points.";
        }
        else {
            res = "Team B is leading by " + (scoreB-scoreA) + " points.";
        }
        return matchStart+"\n"+res;
    }

    public void showResult(View view) {
        TextView res = (TextView) findViewById(R.id.status);
        res.setText(getResult());
    }

    private String getResult() {
        String res;
        if(scoreA==scoreB) {
            res = "DRAW MATCH!!";
        }
        else if(scoreA>scoreB) {
            res = "TEAM A wins with " + (scoreA-scoreB) + " points more.";
        }
        else {
            res = "TEAM B wins with " + (scoreB-scoreA) + " points more.";
        }
        res=matchEnd+"\n"+res;
        return res;
    }
    public void reset(View view) {
        scoreA=0;
        scoreB=0;
        setScore();
        TextView res = (TextView) findViewById(R.id.status);
        res.setText(matchStart);
    }
    private void setScore() {
        TextView boardB = (TextView) findViewById(R.id.BoardB);
        boardB.setText(String.valueOf(scoreB));
        TextView boardA = (TextView) findViewById(R.id.BoardA);
        boardA.setText(String.valueOf(scoreA));
    }
}