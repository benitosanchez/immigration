package ai.immigration.immigration.immigrationApi.factory;

import ai.immigration.immigration.immigrationApi.ImmigrationApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Implements {@link ImmigrationApi}.
 */
public class Factory {

    public final static String BASE_URL = "http://immigration.ai/";

    private static ImmigrationApi service;

    /**
     * Creates {@link ImmigrationApi} service.
     *
     * @return The {@link ImmigrationApi}.
     */
    public static ImmigrationApi getInstance() {
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();

            service = retrofit.create(ImmigrationApi.class);

            return service;
        } else {
            return service;
        }
    }
}