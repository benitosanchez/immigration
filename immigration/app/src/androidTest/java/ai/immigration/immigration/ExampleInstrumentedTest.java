package ai.immigration.immigration;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ai.immigration.immigration.data.Evaluator;
import ai.immigration.immigration.data.UserState;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("ai.immigration.immigration", appContext.getPackageName());
    }

    @Test
    public void evaluate_age() throws Exception {
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Context appContext = InstrumentationRegistry.getTargetContext();
                Evaluator eval = new Evaluator(appContext);
                UserState user = new UserState();
                user.SetUserInfo("age", "18");
                eval.Evaluate(user, "user['age'] < 21");
            }
        });

        //assertEquals("ai.immigration.immigration", appContext.getPackageName());
    }
}
