package ai.immigration.immigration;

import android.app.Application;

import ai.immigration.immigration.data.component.DaggerNetComponent;
import ai.immigration.immigration.data.component.NetComponent;
import ai.immigration.immigration.data.module.AppModule;
import ai.immigration.immigration.data.module.NetModule;

public class ImmigrationApp extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule("https://storage.googleapis.com"))
                .appModule(new AppModule(this))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

}

