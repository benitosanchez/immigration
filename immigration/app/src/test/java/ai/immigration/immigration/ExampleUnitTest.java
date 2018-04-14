package ai.immigration.immigration;

import android.util.Log;

import org.junit.Test;

import ai.immigration.immigration.data.UserState;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void CanSerializeUserState() throws Exception {
        UserState state = new UserState();
        state.SetUserInfo("age", "20");
        assertEquals(state.GetUserInfo("age"), "20");
        String serialized_state = state.ToJsonString();
        assertEquals(serialized_state, "{\"age\":\"20\"}");
    }
}