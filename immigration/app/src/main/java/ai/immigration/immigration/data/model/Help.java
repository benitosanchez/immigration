
package ai.immigration.immigration.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Help {

    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("requirements")
    @Expose
    private List<Object> requirements = null;
    @SerializedName("next_node_ids")
    @Expose
    private List<Object> nextNodeIds = null;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Object> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Object> requirements) {
        this.requirements = requirements;
    }

    public List<Object> getNextNodeIds() {
        return nextNodeIds;
    }

    public void setNextNodeIds(List<Object> nextNodeIds) {
        this.nextNodeIds = nextNodeIds;
    }

}
