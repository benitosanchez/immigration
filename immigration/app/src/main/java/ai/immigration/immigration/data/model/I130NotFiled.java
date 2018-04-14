
package ai.immigration.immigration.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class I130NotFiled {

    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("requirements")
    @Expose
    private List<Requirement___> requirements = null;
    @SerializedName("next_node_ids")
    @Expose
    private List<String> nextNodeIds = null;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Requirement___> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement___> requirements) {
        this.requirements = requirements;
    }

    public List<String> getNextNodeIds() {
        return nextNodeIds;
    }

    public void setNextNodeIds(List<String> nextNodeIds) {
        this.nextNodeIds = nextNodeIds;
    }

}
