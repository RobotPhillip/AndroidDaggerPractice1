package com.robotsandpencils.androiddaggerpractice1.di;

import com.robotsandpencils.androiddaggerpractice1.lobby.LobbyActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pwray on 2017-10-30.
 *
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract LobbyActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}
