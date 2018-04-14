package ai.immigration.immigration.immigrationApi;

import ai.immigration.immigration.data.model.Response;
import retrofit2.http.GET;

public interface ImmigrationApi {

    @GET("/test")
    rx.Observable<Response> getNodes();
}
