package ai.immigration.immigration.data.component;

import javax.inject.Singleton;

import ai.immigration.immigration.data.module.AppModule;
import ai.immigration.immigration.data.module.NetModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Component for objects that will be used through out the app life cycle.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    /**
     * Should return a {@link Retrofit}
     *
     * @return a {@link Retrofit}
     */
    Retrofit retrofit();
}