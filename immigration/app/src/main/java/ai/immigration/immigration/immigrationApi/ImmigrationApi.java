package ai.immigration.immigration.immigrationApi;

import java.util.HashMap;

import ai.immigration.immigration.data.model.Node;
import retrofit2.http.GET;

public interface ImmigrationApi {

    @GET("/test")
    rx.Observable<HashMap<String, Node>> getNodes();
}
