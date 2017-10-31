package com.robotsandpencils.androiddaggerpractice1;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

import com.robotsandpencils.androiddaggerpractice1.di.DaggerAppComponent;

/**
 * Created by pwray on 2017-10-30.
 */

public class App extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchAndroidInjector;
    }
}
