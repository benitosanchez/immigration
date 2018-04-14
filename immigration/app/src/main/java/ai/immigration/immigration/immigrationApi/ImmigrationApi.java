package ai.immigration.immigration.immigrationApi;

import java.util.HashMap;

import ai.immigration.immigration.data.model.Node;
import retrofit2.http.GET;

public interface ImmigrationApi {

    @GET("/testman-d2065.appspot.com/flowchart_1.json")
    rx.Observable<HashMap<String, Node>> getNodes();
}
