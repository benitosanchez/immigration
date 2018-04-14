
package ai.immigration.immigration.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("start")
    @Expose
    private Start start;
    @SerializedName("prelim_questions")
    @Expose
    private PrelimQuestions prelimQuestions;
    @SerializedName("parent_petition")
    @Expose
    private ParentPetition parentPetition;
    @SerializedName("spouse_petition")
    @Expose
    private SpousePetition spousePetition;
    @SerializedName("i130")
    @Expose
    private I130 i130;
    @SerializedName("i130-not-filed")
    @Expose
    private I130NotFiled i130NotFiled;
    @SerializedName("i130-filed")
    @Expose
    private I130Filed i130Filed;
    @SerializedName("help")
    @Expose
    private Help help;

    public Start getStart() {
        return start;
    }

    public void setStart(Start start) {
        this.start = start;
    }

    public PrelimQuestions getPrelimQuestions() {
        return prelimQuestions;
    }

    public void setPrelimQuestions(PrelimQuestions prelimQuestions) {
        this.prelimQuestions = prelimQuestions;
    }

    public ParentPetition getParentPetition() {
        return parentPetition;
    }

    public void setParentPetition(ParentPetition parentPetition) {
        this.parentPetition = parentPetition;
    }

    public SpousePetition getSpousePetition() {
        return spousePetition;
    }

    public void setSpousePetition(SpousePetition spousePetition) {
        this.spousePetition = spousePetition;
    }

    public I130 getI130() {
        return i130;
    }

    public void setI130(I130 i130) {
        this.i130 = i130;
    }

    public I130NotFiled getI130NotFiled() {
        return i130NotFiled;
    }

    public void setI130NotFiled(I130NotFiled i130NotFiled) {
        this.i130NotFiled = i130NotFiled;
    }

    public I130Filed getI130Filed() {
        return i130Filed;
    }

    public void setI130Filed(I130Filed i130Filed) {
        this.i130Filed = i130Filed;
    }

    public Help getHelp() {
        return help;
    }

    public void setHelp(Help help) {
        this.help = help;
    }

}
