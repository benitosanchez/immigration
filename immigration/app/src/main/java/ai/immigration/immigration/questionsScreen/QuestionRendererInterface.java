package ai.immigration.immigration.questionsScreen;

public interface QuestionRendererInterface {
    enum QuestionType {
        DetailMessage,
        YesNo,
        TextField,
    }

    void RenderNextQuestion(String message, QuestionType questionType);
}

