package ai.immigration.immigration.questionsScreen;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import ai.immigration.immigration.ImmigrationApp;
import ai.immigration.immigration.data.component.NetComponent;
import ai.immigration.immigration.data.model.Node;
import ai.immigration.immigration.data.model.Requirement;
import ai.immigration.immigration.immigrationApi.ImmigrationApi;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class QuestionsController implements QuestionsLayout.Listener, AnswerInterface {

    private QuestionsActivity questionsActivity;

    @Inject Retrofit retrofit;
    @Inject QuestionsLayout questionsLayout;

    public QuestionsController(QuestionsActivity activity) {
        questionsActivity = activity;

        DaggerQuestionsController_Component.builder()
                .netComponent(((ImmigrationApp) questionsActivity.getApplicationContext()).getNetComponent())
                .questionsControllerModule(new QuestionsControllerModule(questionsActivity, this, this))
                .build()
                .inject(this);
        retrofit.create(ImmigrationApi.class).getNodes()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(questionsLayout);
    }

    @Override
    public void onYesButtonClicked() {
        Log.d("Testing buttons", "yes");
    }

    @Override
    public void onNoButtonClicked() {
        Log.d("Testing buttons", "no");
    }

    @Override
    public void OnAnswer(String answer) {

    }

    @PerController
    @dagger.Component(dependencies = NetComponent.class, modules = QuestionsControllerModule.class)
    interface Component {
        void inject(QuestionsController questionsController);
    }

    @Module
    static class QuestionsControllerModule {
        private final QuestionsActivity questionsActivity;
        private final QuestionsLayout.Listener listener;
        private final AnswerInterface answerInterface;

        public QuestionsControllerModule(
                QuestionsActivity questionsActivity,
                QuestionsLayout.Listener listener,
                AnswerInterface answerInterface) {
            this.questionsActivity = questionsActivity;
            this.listener = listener;
            this.answerInterface = answerInterface;
        }

        @Provides
        QuestionsLayout providesQuestionsLayout() {
            return new QuestionsLayout(questionsActivity, listener, answerInterface);
        }
    }
}
