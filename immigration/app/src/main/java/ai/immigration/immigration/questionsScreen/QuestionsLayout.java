package ai.immigration.immigration.questionsScreen;

import android.widget.Button;

import ai.immigration.immigration.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.compiler.ButterKnifeProcessor;

public class QuestionsLayout {

    private QuestionsActivity mQuestionsActivity;
    private Listener mListener;

    @BindView(R.id.yes) Button mYesButton;
    @BindView(R.id.no) Button mNoButton;

    public QuestionsLayout(
            QuestionsActivity questionsActivity,
            Listener listener) {

        mQuestionsActivity = questionsActivity;
        mListener = listener;
        mQuestionsActivity.setContentView(R.layout.activity_quesetions);
        ButterKnife.bind(this, mQuestionsActivity);

    }

    @OnClick(R.id.yes)
    public void onYesButtonClicked() {
        mListener.onYesButtonClicked();
    }

    @OnClick(R.id.no)
    public void onNoButtonClicked() {
        mListener.onNoButtonClicked();
    }

    interface Listener {
        void onYesButtonClicked();
        void onNoButtonClicked();
    }
}
