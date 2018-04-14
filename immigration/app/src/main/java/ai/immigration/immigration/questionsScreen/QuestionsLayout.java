package ai.immigration.immigration.questionsScreen;

import android.os.Build;
import android.util.Log;
import android.widget.Button;
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

    private QuestionsActivity mQuestionsActivity;
    private Listener mListener;

    @BindView(R.id.yes) Button mYesButton;
    @BindView(R.id.no) Button mNoButton;
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
