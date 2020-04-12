package com.example.quiz_app;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String name, age, gender;
    //  int score;
    RadioGroup radioGroup;
    String[] Answers = new String[7];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set_answers();
    }

    final void set_answers() {
        Answers[0] = getString(R.string.q1_op1);
        Answers[1] = getString(R.string.q2_op1);
        Answers[2] = getString(R.string.q3_op1);
        Answers[3] = getString(R.string.q4_op1);
        Answers[4] = getString(R.string.q4_op2);
        Answers[5] = getString(R.string.q5_op1);
        Answers[6] = getString(R.string.q5_op2);
    }

    String Get_answers(int ques_no) {

        return Answers[ques_no];
    }

    void details() {

    }

    void answers() {

    }

    Boolean check_details(Boolean flag) throws Exception {
        EditText ET_name = findViewById(R.id.ET_name);
        EditText ET_age = findViewById(R.id.ET_age);
        radioGroup = findViewById(R.id.radio_gender);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {

            Log.w("V", "no selected gender ");
            Toast msg = Toast.makeText(getApplicationContext(), "Please select the gender ", Toast.LENGTH_LONG);
            msg.show();
            flag = false;
        }
        String name = ET_name.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Log.w("V", "no name ");
            Toast msg = Toast.makeText(getApplicationContext(), "Please enter the name ", Toast.LENGTH_LONG);
            msg.show();
            flag = false;
        }

        String age = ET_age.getText().toString();
        if (TextUtils.isEmpty(age)) {
            Log.w("V", "no name ");
            Toast msg = Toast.makeText(getApplicationContext(), "Please enter the age ", Toast.LENGTH_LONG);
            msg.show();
            flag = false;
        }
        return flag;
    }

    void set_results() {

        TextView Final_TV = findViewById(R.id.tv_8_final_results);
        Final_TV.setText(getString(R.string.Text_Name));
        Final_TV.append(name + "\n" + getString(R.string.Text_Age) + age);
        Final_TV.append("\n" + getString(R.string.Text_Gender) + gender);
    }

    public void On_submit(View view) {
        try {
            Boolean flag = true;
            if (check_details(flag)) {
            }

        } catch (Exception ex) {
            Log.e("MainActivity", "exception", ex);
        }
    }
}
