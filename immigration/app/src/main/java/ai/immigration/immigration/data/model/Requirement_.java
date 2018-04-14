
package ai.immigration.immigration.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requirement_ {

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("eval_string")
    @Expose
    private String evalString;
    @SerializedName("user_info_key")
    @Expose
    private String userInfoKey;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEvalString() {
        return evalString;
    }

    public void setEvalString(String evalString) {
        this.evalString = evalString;
    }

    public String getUserInfoKey() {
        return userInfoKey;
    }

    public void setUserInfoKey(String userInfoKey) {
        this.userInfoKey = userInfoKey;
    }

}
