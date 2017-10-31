package com.robotsandpencils.androiddaggerpractice1.di;

import com.robotsandpencils.androiddaggerpractice1.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by pwray on 2017-10-30.
 */
@Singleton
/* Use AndoroidInjectionModule.class if you're not using support library */
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }

    void inject(App app);
}
