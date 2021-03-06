
package ai.immigration.immigration.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node {

    @SerializedName("details") @Expose private String details;
    @SerializedName("requirements") @Expose private List<Requirement> requirements = null;
    @SerializedName("next_node_ids") @Expose private List<String> nextNodeIds = null;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Requirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirement> requirements) {
        this.requirements = requirements;
    }

    public List<String> getNextNodeIds() {
        return nextNodeIds;
    }

    public void setNextNodeIds(List<String> nextNodeIds) {
        this.nextNodeIds = nextNodeIds;
    }

}
