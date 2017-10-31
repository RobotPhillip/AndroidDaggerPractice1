package com.robotsandpencils.androiddaggerpractice1.di;

import android.app.Application;
import android.content.Context;

import com.robotsandpencils.androiddaggerpractice1.common.CommonHelloService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pwray on 2017-10-30.
 *
 * This is where you will inject application-wide dependencies.
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(Application app) {
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    CommonHelloService provideCommonHelloService() {
        return new CommonHelloService();
    }
}
