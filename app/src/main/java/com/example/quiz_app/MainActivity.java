package com.example.quiz_app;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String name, age, gender;
    int score = 0;
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
        Answers[1] = getString(R.string.q2_op3);
        Answers[2] = getString(R.string.q3_op2);
        Answers[3] = getString(R.string.q4_op1);
        Answers[4] = getString(R.string.q4_op2);
        Answers[5] = getString(R.string.q5_op1);
        Answers[6] = getString(R.string.q5_op4);
    }


    void check_for_rad() {
        int rg_id_1 = R.id.rg_no_1;
        int rg_id_2 = R.id.rg_no_2;
        int rg_id_3 = R.id.rg_no_3;

        radioGroup = findViewById(rg_id_1);
        int selectedId_1 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_1 != -1) {
            RadioButton reponse_1 = findViewById(selectedId_1);
            if (reponse_1.getText().toString().equalsIgnoreCase(Answers[0])) {
                score++;
            }
        }
        radioGroup = findViewById(rg_id_2);
        int selectedId_2 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_2 != -1) {
            RadioButton reponse_2 = findViewById(selectedId_2);
            if (reponse_2.getText().toString().equalsIgnoreCase(Answers[0])) {
                score++;
            }
        }

        radioGroup = findViewById(rg_id_3);
        int selectedId_3 = radioGroup.getCheckedRadioButtonId();
        if (selectedId_3 != -1) {
            RadioButton reponse_3 = findViewById(selectedId_3);
            if (reponse_3.getText().toString().equalsIgnoreCase(Answers[0])) {
                score++;
            }
        }


    }


    void details_Response() {
        EditText ET_name = findViewById(R.id.ET_name);
        EditText ET_age = findViewById(R.id.ET_age);
        radioGroup = findViewById(R.id.radio_gender);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radio_selected = findViewById(selectedId);

        name = ET_name.getText().toString();
        age = ET_age.getText().toString();
        gender = radio_selected.getText().toString();
    }

    Boolean check_Details(Boolean flag) {
        EditText ET_name = findViewById(R.id.ET_name);
        EditText ET_age = findViewById(R.id.ET_age);
        radioGroup = findViewById(R.id.radio_gender);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        String name = ET_name.getText().toString();
        String age = ET_age.getText().toString();
        if ((TextUtils.isEmpty(age)) || ((selectedId == -1)) || (TextUtils.isEmpty(name))) {
            Log.w("V", "no name ");
            Toast msg = Toast.makeText(getApplicationContext(), "Please fill all the details  ", Toast.LENGTH_LONG);
            msg.show();
            flag = false;
        }


        return flag;
    }

    void set_Results() {
        details_Response();
        TextView Final_TV = findViewById(R.id.tv_8_final_results);
        Final_TV.setText(getString(R.string.Text_Name));
        Final_TV.append(name + "\n" + getString(R.string.Text_Age) + age);
        Final_TV.append("\n" + getString(R.string.Text_Gender) + gender);
        Final_TV.append("\n" + " The Score is " + score);
    }

    public void On_Submit(View view) {
        try {
            Boolean flag = true;
            if (check_Details(flag)) {

                check_for_rad();
                set_Results();

            }

        } catch (Exception ex) {
            Log.e("MainActivity", "exception", ex);
        }
    }
}
