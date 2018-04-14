package ai.immigration.immigration.questionsScreen;

import android.util.Log;

import java.util.ArrayList;

import ai.immigration.immigration.data.model.Node;
import ai.immigration.immigration.data.model.Requirement;

public class QuestionsController implements QuestionsLayout.Listener {

    private QuestionsActivity questionsActivity;
    private QuestionsLayout questionsLayout;

    public QuestionsController(QuestionsActivity activity) {
        questionsActivity = activity;
        questionsLayout = new QuestionsLayout(questionsActivity, this);
    }

    @Override
    public void onYesButtonClicked() {
        Log.d("Testing buttons", "yes");
    }

    @Override
    public void onNoButtonClicked() {
        Log.d("Testing buttons", "no");
    }
}
