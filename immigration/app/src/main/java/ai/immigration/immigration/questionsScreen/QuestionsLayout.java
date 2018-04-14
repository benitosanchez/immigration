package ai.immigration.immigration.questionsScreen;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

import ai.immigration.immigration.R;
import ai.immigration.immigration.data.model.Node;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.compiler.ButterKnifeProcessor;
import rx.Subscriber;

public class QuestionsLayout extends Subscriber<HashMap<String, Node>> implements QuestionRendererInterface {

    private QuestionsActivity mQuestionsActivity;
    private Listener mListener;

    @BindView(R.id.yes) Button mYesButton;
    @BindView(R.id.no) Button mNoButton;
    @BindView(R.id.edit_text_input) LinearLayout mEditTextView;
    @BindView(R.id.yesNoLayout) LinearLayout mYesNoLayout;
    @BindView(R.id.question) TextView mQuestionView;
    @BindView(R.id.next_button_layout) LinearLayout mNextButtonLayout;

    public QuestionsLayout(
            QuestionsActivity questionsActivity,
            Listener listener,
            AnswerInterface answerInterface) {

        mQuestionsActivity = questionsActivity;
        mListener = listener;
        mQuestionsActivity.setContentView(R.layout.activity_quesetions);
        ButterKnife.bind(this, mQuestionsActivity);

        answerInterface.OnAnswer("");
    }

    @OnClick(R.id.yes)
    public void onYesButtonClicked() {
        mListener.onYesButtonClicked();
    }

    @OnClick(R.id.no)
    public void onNoButtonClicked() {
        mListener.onNoButtonClicked();
    }

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) {
        Log.d("NODE", e.getMessage());
    }

    /**
     * Switch to decide which input to receive from user.
     *
     * @param questionType The quetion type represented by an {@link QuestionType}.
     */
    public void updateUserInputType(QuestionType questionType) {
        switch (questionType) {
            case YesNo:
                mYesNoLayout.setVisibility(View.VISIBLE);
                mEditTextView.setVisibility(View.GONE);
                mNextButtonLayout.setVisibility(View.GONE);
                break;
            case TextField:
                mYesNoLayout.setVisibility(View.GONE);
                mEditTextView.setVisibility(View.VISIBLE);
                mNextButtonLayout.setVisibility(View.GONE);
                break;
            case DetailMessage:
                mYesNoLayout.setVisibility(View.GONE);
                mEditTextView.setVisibility(View.GONE);
                mNextButtonLayout.setVisibility(View.VISIBLE);
            default:
        }
    }

    @Override
    public void onNext(HashMap<String, Node> listNodes) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            listNodes.forEach(new BiConsumer<String, Node>() {
                @Override
                public void accept(String s, Node node) {

                }
            });
        }
    }

    @Override
    public void RenderNextQuestion(String message, QuestionType questionType) {
        updateUserInputType(questionType);
        mQuestionView.setText(message);
    }

    interface Listener {
        void onYesButtonClicked();
        void onNoButtonClicked();
    }
}
