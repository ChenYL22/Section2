package com.example.section;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class BallActivity extends Activity implements View.OnClickListener {
    private TextView team_scoreA, team_scoreB;
    private Button btn3_label, btn2_label, btn1_label;
    private Button btn6_label, btn5_label, btn4_label;
    private Button reset_label;
    private int AScore, BScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        initView();
    }

    private void initView() {
        team_scoreA = (TextView) findViewById(R.id.team_scoreA);
        team_scoreB = (TextView) findViewById(R.id.team_scoreB);
        btn3_label = (Button) findViewById(R.id.btn3_label);
        btn2_label = (Button) findViewById(R.id.btn2_label);
        btn1_label = (Button) findViewById(R.id.btn1_label);
        btn6_label = (Button) findViewById(R.id.btn6_label);
        btn5_label = (Button) findViewById(R.id.btn5_label);
        btn4_label = (Button) findViewById(R.id.btn4_label);
        reset_label = (Button) findViewById(R.id.reset_label);

        btn3_label.setOnClickListener(this);
        btn2_label.setOnClickListener(this);
        btn1_label.setOnClickListener(this);
        btn6_label.setOnClickListener(this);
        btn5_label.setOnClickListener(this);
        btn4_label.setOnClickListener(this);
        reset_label.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn3_label:
                aAddScore(3);
                break;
            case R.id.btn2_label:
                aAddScore(2);
                break;
            case R.id.btn1_label:
                aAddScore(1);
                break;
            case R.id.btn6_label:
                bAddScore(3);
                break;
            case R.id.btn5_label:
                bAddScore(2);
                break;
            case R.id.btn4_label:
                bAddScore(1);
                break;
            case R.id.reset_label:
                showResetDialog();
                break;
        }
    }

    private void aAddScore(int score) {
        AScore = AScore + score;
        displayAScore(AScore);
    }

    private void bAddScore(int score) {
        BScore = BScore + score;
        displayBScore(BScore);
    }

    private void showResetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("确认要清空两队的得分吗？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetScore();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.show();
    }

    private void resetScore() {
        AScore = 0;
        BScore = 0;
        displayAScore(AScore);
        displayBScore(BScore);
    }

    private void displayAScore(int score) {
        team_scoreA.setText(String.valueOf(score));
    }

    private void displayBScore(int score) {
        team_scoreA.setText(String.valueOf(score));
    }
}