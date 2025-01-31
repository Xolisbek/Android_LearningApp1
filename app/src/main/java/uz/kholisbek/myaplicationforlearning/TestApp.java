package uz.kholisbek.myaplicationforlearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import uz.kholisbek.myaplicationforlearning.models.Questions;
import uz.kholisbek.myaplicationforlearning.models.TestVariant;

public class TestApp extends AppCompatActivity {
    private TextView questionView, resultView, questionNumber;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private Button btnNext, btnReplay;
    private LinearLayout answerSection;
    private ConstraintLayout questionSection;

    ProgressBar progressBar;

    private int index = 0;

    private int countOfCorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViews();
        loadQuestion(index);/* index = 0 by default shuning uchun birinchi savolni yuklaydi */

        btnNext.setOnClickListener(view -> {
            // pastdagi If ning ichi o'yin hali tugamagan holati
            if (index < Questions.getQuestions().size()) {

                /* Javob tanlanganmi yo'qmi tekshirish */
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(this, "Javob tanlanmagan", Toast.LENGTH_SHORT).show();
                } else {/* javob tanlangan holati */
                    RadioButton checkedRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                    if (checkedRadioButton.getText().toString().equals(Questions.getQuestions().get(index).getAnswer())) {
                        countOfCorrectAnswers++;
                        Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
                    index++;
                    radioGroup.clearCheck();
                    if (index < Questions.getQuestions().size()) {
                        loadQuestion(index);
                    } else {
                        answerSection.setVisibility(View.GONE);
                        questionSection.setVisibility(View.GONE);


                        resultView.setVisibility(View.VISIBLE);
                        resultView.setText(countOfCorrectAnswers + " out of " + Questions.getQuestions().size() + " are correct");
                        btnReplay.setVisibility(View.VISIBLE);
                    }
                }
            } else {/* pastdagi else ning ichi o'yin tugagan holati */
//                Todo o'yin oxirining logikasini yozish kerak
//                nechtasini to'g'ri yechganini ko'rsatish kabi logikalar
                Toast.makeText(this, "O'yin tugadi!\n to'g'ri javoblar soni: " + countOfCorrectAnswers, Toast.LENGTH_SHORT).show();
            }
        });

        btnReplay.setOnClickListener(view -> {
            btnReplay.setVisibility(View.GONE);
            resultView.setVisibility(View.GONE);

            answerSection.setVisibility(View.VISIBLE);
            questionSection.setVisibility(View.VISIBLE);
            index = 0;
            countOfCorrectAnswers = 0;
            loadQuestion(index);
        });

    }

    private void loadQuestion(int index) {
        TestVariant test = Questions.getQuestions().get(index);
        questionView.setText(test.getQuestion());
        radioButton1.setText(test.getVariantA());
        radioButton2.setText(test.getVariantB());
        radioButton3.setText(test.getVariantC());
        radioButton4.setText(test.getVariantD());

        questionNumber.setText(String.valueOf(index + 1));
        progressBar.setProgress((int) (100d * (index + 1) / Questions.getQuestions().size()));
    }

    private void findViews() {
        questionView = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.variantA);
        radioButton2 = findViewById(R.id.variantB);
        radioButton3 = findViewById(R.id.variantC);
        radioButton4 = findViewById(R.id.variantD);
        btnNext = findViewById(R.id.btn_next);
        resultView = findViewById(R.id.resultView);
        btnReplay = findViewById(R.id.replayBtn);
        questionNumber = findViewById(R.id.questionNumber);
        progressBar = findViewById(R.id.progressBar);
        answerSection = findViewById(R.id.wrapperOfAnswerSection);
        questionSection = findViewById(R.id.wrapperOfQuestionSection);
    }
}