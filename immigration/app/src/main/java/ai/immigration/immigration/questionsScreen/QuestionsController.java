package ai.immigration.immigration.questionsScreen;

import android.util.Log;

import java.util.ArrayList;

import ai.immigration.immigration.data.model.Help;
import ai.immigration.immigration.data.model.I130;
import ai.immigration.immigration.data.model.I130Filed;
import ai.immigration.immigration.data.model.I130NotFiled;
import ai.immigration.immigration.data.model.ParentPetition;
import ai.immigration.immigration.data.model.PrelimQuestions;
import ai.immigration.immigration.data.model.Requirement;
import ai.immigration.immigration.data.model.Requirement_;
import ai.immigration.immigration.data.model.Requirement__;
import ai.immigration.immigration.data.model.Requirement___;
import ai.immigration.immigration.data.model.Requirement____;
import ai.immigration.immigration.data.model.Response;
import ai.immigration.immigration.data.model.SpousePetition;
import ai.immigration.immigration.data.model.Start;

public class QuestionsController implements QuestionsLayout.Listener {

    private QuestionsActivity questionsActivity;
    private QuestionsLayout questionsLayout;

    public QuestionsController(QuestionsActivity activity) {
        questionsActivity = activity;
        questionsLayout = new QuestionsLayout(questionsActivity, this);
    }

    @Override
    public void onYesButtonClicked() {
        Log.d("Testing buttons", "yes");
    }

    @Override
    public void onNoButtonClicked() {
        Log.d("Testing buttons", "no");
    }

    private Response getTestingNodes() {
        // Creates the start object.
        Start start = new Start();
        start.setDetails("Welcome, thanks for trying us out");
        start.setRequirements(new ArrayList<Object>());
        ArrayList<String> nextNodes = new ArrayList<>();
        nextNodes.add("prelim_questions");
        start.setNextNodeIds(nextNodes);

        // Prelim Questions
        PrelimQuestions prelimQuestions = new PrelimQuestions();
        prelimQuestions.setDetails("Great, these questions will help us find a path just for you!");
        ArrayList<Requirement> requirements = new ArrayList<>();

        Requirement requirement = new Requirement();

        requirement.setQuestion("How old are you?");
        requirement.setEvalString("true");
        requirement.setUserInfoKey("age");
        requirements.add(requirement);

        requirement = new Requirement();

        requirement.setQuestion("Are you a relative of a US citizen??");
        requirement.setEvalString("true");
        requirement.setUserInfoKey("rel_citizen");
        requirements.add(requirement);

        requirement = new Requirement();

        requirement.setQuestion("Do you have a work opportunity in the US?");
        requirement.setEvalString("true");
        requirement.setUserInfoKey("has_work_opp");
        requirements.add(requirement);

        requirement = new Requirement();

        requirement.setQuestion("Do you currently have legal status?");
        requirement.setEvalString("true");
        requirement.setUserInfoKey("current_legal_status");
        requirements.add(requirement);

        prelimQuestions.setRequirements(requirements);

        ArrayList<String> nextNodeIds = new ArrayList<>();
        nextNodeIds.add("parent_petition");
        nextNodeIds.add("spouse_petition");
        nextNodeIds.add("employment_based");
        prelimQuestions.setNextNodeIds(nextNodeIds);

        // Parent Petition
        ParentPetition parentPetition = new ParentPetition();
        parentPetition.setDetails("You may qualify for a parent petition visa!");

        ArrayList<Requirement_> requirement_s = new ArrayList<>();
        Requirement_ requirement_ = new Requirement_();
        requirement_.setQuestion("Is your relative citizen your parent?");
        requirement_.setEvalString("user['rel_citizen_is_parent'] == true");
        requirement_.setUserInfoKey("rel_citizen_is_parent");

        requirement_s.add(requirement_);

        requirement_ = new Requirement_();
        requirement_.setQuestion("Are you 21 or younger?");
        requirement_.setEvalString("user['age'] <= 21");
        requirement_.setUserInfoKey("age");
        requirement_s.add(requirement_);

        parentPetition.setRequirements(requirement_s);

        nextNodeIds = new ArrayList<>();
        nextNodeIds.add("i130");
        parentPetition.setNextNodeIds(nextNodeIds);

        // Spouse petition
        SpousePetition spousePetition = new SpousePetition();
        spousePetition.setDetails("Your US citizen spouse may be able to file an immediate relative petition!");

        ArrayList<Requirement__> requirement__s = new ArrayList<>();
        Requirement__ requirement__ = new Requirement__();
        requirement__.setQuestion("Is your relative citizen your spouse?");
        requirement__.setEvalString("user['rel_citizen_is_spouse'] == true");
        requirement__.setUserInfoKey("rel_citizen_is_parent");
        requirement__s.add(requirement__);

        spousePetition.setRequirements(requirement__s);

        nextNodeIds = new ArrayList<>();
        nextNodeIds.add("i130");
        spousePetition.setNextNodeIds(nextNodeIds);

        I130 i130 = new I130();
        i130.setDetails("You appear to be eligible for a petition based visa. This process requires proper filing of an I-130 is crucial to a successful petition.");
        i130.setRequirements(new ArrayList<Object>());
        nextNodeIds = new ArrayList<>();
        nextNodeIds.add("i130-not-filed");
        nextNodeIds.add("i130-filed");
        i130.setNextNodeIds(nextNodeIds);

        I130NotFiled i130NotFiled = new I130NotFiled();
        i130NotFiled.setDetails("We can help you with filing the I-130. Here's the outline of the process:..... Tap here to see a list of lawyers vetted by us that have loads of experience in filing these petitions!");

        ArrayList<Requirement___> requirement___s = new ArrayList<>();
        Requirement___ requirement___ = new Requirement___();
        requirement___.setEvalString("filed-i130 == true");
        requirement___.setQuestion("Have your relative filed for an I-130 petition?");
        requirement___.setUserInfoKey("filed-i130");

        i130NotFiled.setRequirements(requirement___s);

        nextNodeIds = new ArrayList<>();
        nextNodeIds.add("help");
        i130NotFiled.setNextNodeIds(nextNodeIds);

        I130Filed i130Filed = new I130Filed();
        i130Filed.setDetails("Nice! NVC will send out instructions to collect fees, visa app, including DS-230 and I-864");

        ArrayList<Requirement____> requirement____s = new ArrayList<>();
        Requirement____ requirement____ = new Requirement____();
        requirement____.setQuestion("Have your relative filed for an I-130 petition?");
        requirement____.setEvalString("filed-i130 == false");
        requirement____.setUserInfoKey("filed-i130");
        requirement____s.add(requirement____);
        i130Filed.setRequirements(requirement____s);

        Help help = new Help();
        help.setDetails("We have a list of expert professionals that can help you proceed in your immigration process. Here's a summary of what you have told us... Here's a list of lawyers that can help you...");
        help.setNextNodeIds(new ArrayList<Object>());
        help.setRequirements(new ArrayList<Object>());

        Response response = new Response();
        response.setStart(start);
        response.setPrelimQuestions(prelimQuestions);
        response.setParentPetition(parentPetition);
        response.setSpousePetition(spousePetition);
        response.setI130(i130);
        response.setI130NotFiled(i130NotFiled);
        response.setI130Filed(i130Filed);
        response.setHelp(help);

        return response;
    }
}
