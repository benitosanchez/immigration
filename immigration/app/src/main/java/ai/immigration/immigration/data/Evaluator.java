package ai.immigration.immigration.data;

import android.content.Context;
import android.util.Log;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Evaluator {
    JsEvaluator js_eval;
    ExecutorService executor;

    interface EvalResult {
        void OnResult(boolean result);
        void OnError(UserState user, String evalString);
    }

    public Evaluator(Context context) {
        js_eval = new JsEvaluator(context);
    }

    public void Evaluate(final UserState user, final String eval_string, final EvalResult callback) {
        String user_ser = user.ToJsonString();
        String WRAPPER = "function __wrapper__(user_ser) {" +
                "var user = JSON.parse(user_ser);" +
                "var output = " + eval_string + ";" +
                "return JSON.stringify(output);" +
                "}";

        String FUNC_NAME = "__wrapper__";

        js_eval.callFunction(WRAPPER, new JsCallback() {
            @Override
            public void onResult(final String result) {
                Log.i("Evaluator.onResult", "res is " + result);
                callback.OnResult(result.equals("true"));
            }

            @Override
            public void onError(String s) {
                Log.e("Evaluator.onError", "res is " + s);
                callback.OnError(user, eval_string);
            }
        }, FUNC_NAME, user_ser);

    }
}
