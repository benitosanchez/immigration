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

public class QuestionsLayout extends Subscriber<HashMap<String, Node>> {

    public static final int YES_NO_INPUT = 0;
    public static final int EDIT_TEXT_INPUT = 1;

    private QuestionsActivity mQuestionsActivity;
    private Listener mListener;

    @BindView(R.id.yes) Button mYesButton;
    @BindView(R.id.no) Button mNoButton;
    @BindView(R.id.edit_text_input) LinearLayout mEditTextView;
    @BindView(R.id.yesNoLayout) LinearLayout mYesNoLayout;
    @BindView(R.id.question) TextView mQuestionView;

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

    @Override
    public void onCompleted() { }

    @Override
    public void onError(Throwable e) {
        Log.d("NODE", e.getMessage());
    }

    /**
     * Switch to decide which input to receive from user.
     *
     * @param inputType The input type represented by an {@link int}.
     */
    public void updateUserInputType(int inputType) {
        switch (inputType) {
            case YES_NO_INPUT:
                mYesNoLayout.setVisibility(View.VISIBLE);
                mEditTextView.setVisibility(View.GONE);
                break;
            case EDIT_TEXT_INPUT:
                mYesNoLayout.setVisibility(View.GONE);
                mEditTextView.setVisibility(View.VISIBLE);
                break;
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

    interface Listener {
        void onYesButtonClicked();
        void onNoButtonClicked();
    }
}
