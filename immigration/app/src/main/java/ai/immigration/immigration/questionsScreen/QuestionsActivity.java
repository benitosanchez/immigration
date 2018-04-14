package ai.immigration.immigration.questionsScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ai.immigration.immigration.R;

public class QuestionsActivity extends AppCompatActivity {

    private QuestionsController questionsController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        questionsController = new QuestionsController(this);
    }
}
