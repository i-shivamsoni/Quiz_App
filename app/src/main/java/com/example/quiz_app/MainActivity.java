package com.example.quiz_app;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // int score = 0;
    RadioGroup radioGroup;
    String[] Answers = new String[7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_answers();
    }

    final void set_answers() { //sets the answers of the question for comparision
        Answers[0] = getString(R.string.q1_op1);
        Answers[1] = getString(R.string.q2_op3);
        Answers[2] = getString(R.string.q3_op2);
        Answers[3] = getString(R.string.q4_op1);
        Answers[4] = getString(R.string.q4_op2);
        Answers[5] = getString(R.string.q5_op1);
        Answers[6] = getString(R.string.q5_op4);
    }

    int check_for_edt() {
        int score = 0;
        String response;
        EditText text = findViewById(R.id.ansq01);
        response = text.getText().toString();

        if (!(TextUtils.isEmpty(response))) {
            String answer = getString(R.string.qnoans);
            boolean bool = response.equalsIgnoreCase(answer);
            if (bool) {
                score++;
                //    text.setBackgroundColor(getResources().getColor(R.color.white));
            }

        }
        return score;
    }

    int check_for_rad() {  //for getting scores of questions with radio button
        int rg_id_1 = R.id.rg_no_1;
        int rg_id_2 = R.id.rg_no_2;
        int rg_id_3 = R.id.rg_no_3;

        int score = 0;

//        RadioButton rb_q1 = findViewById(R.id.rdb_q1_1);
//        RadioButton rb_q2 = findViewById(R.id.rdb_q2_3);
//        RadioButton rb_q3 = findViewById(R.id.rdb_q3_2);


        radioGroup = findViewById(rg_id_1);
        int selectedId_1 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_1 != -1) {
            RadioButton reponse_1 = findViewById(selectedId_1);
            if (reponse_1.getText().toString().equalsIgnoreCase(Answers[0])) {
                score++;
                //  rb_q1.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
        radioGroup = findViewById(rg_id_2);
        int selectedId_2 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_2 != -1) {
            RadioButton reponse_2 = findViewById(selectedId_2);
            if (reponse_2.getText().toString().equalsIgnoreCase(Answers[1])) {
                score++;
                //rb_q2.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }

        radioGroup = findViewById(rg_id_3);
        int selectedId_3 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_3 != -1) {
            RadioButton reponse_3 = findViewById(selectedId_3);
            if (reponse_3.getText().toString().equalsIgnoreCase(Answers[2])) {
                score++;
                // rb_q3.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }

        return score;
    }


    int check_for_cb() {  //for getting scores of questions with checkboxes
        //correct answers for q 4 are 1 & 2
        CheckBox Op_4q_1 = findViewById(R.id.cb_q4_1);
        CheckBox Op_4q_2 = findViewById(R.id.cb_q4_2);
        CheckBox Op_4q_3 = findViewById(R.id.cb_q4_3);
        CheckBox Op_4q_4 = findViewById(R.id.cb_q4_4);
        int score = 0;
        boolean flag = false;
        if (Op_4q_1.isChecked() || Op_4q_2.isChecked() || Op_4q_3.isChecked() || Op_4q_4.isChecked()) {
            flag = true;

        }

        if (flag) {

            if (Op_4q_3.isChecked() || Op_4q_4.isChecked()) {
                //condition for false answer
                //  Log.w("V", "4 incorrect answer ");
            } else {
                //  Log.w("V", "4 correct answer ");
                score++;
                //Op_4q_1.setBackgroundColor(getResources().getColor(R.color.white));
                //Op_4q_2.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }

        //correct answers for q 5 are 1 & 4
        CheckBox Op_5q_1 = findViewById(R.id.cb_q5_1);
        CheckBox Op_5q_2 = findViewById(R.id.cb_q5_2);
        CheckBox Op_5q_3 = findViewById(R.id.cb_q5_3);
        CheckBox Op_5q_4 = findViewById(R.id.cb_q5_4);
        boolean flag1 = false;
        if (Op_5q_1.isChecked() || Op_5q_2.isChecked() || Op_5q_3.isChecked() || Op_5q_4.isChecked()) {
            flag1 = true;
        }

        if (flag1) {
            if (Op_5q_2.isChecked() || Op_5q_3.isChecked()) {
                //condition for false answer
                //Log.w("V", "5 incorrect answer ");
            } else {
                // Log.w("V", "5 correct answer ");
                score++;
                // Op_5q_1.setBackgroundColor(getResources().getColor(R.color.white));
                // Op_5q_4.setBackgroundColor(getResources().getColor(R.color.white));
            }
        }
        return score;
    }

    void get_grades() {
        int score = check_for_edt() + check_for_cb() + check_for_rad();
        Toast msg = Toast.makeText(getApplicationContext(), getString(R.string.scoremsg) + " " + score, Toast.LENGTH_LONG);
        msg.show();
    }

    public void On_Submit(View view) { // user will click on submit button and this method will be called
        try {  //to handle exceptions
            check_for_rad();
            check_for_cb();
            get_grades();
        } catch (Exception ex) {
            Log.e("MainActivity", "exception", ex);
        }
    }
}
