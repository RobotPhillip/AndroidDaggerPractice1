package com.robotsandpencils.androiddaggerpractice1.di;

import com.robotsandpencils.androiddaggerpractice1.lobby.LobbyActivityModule;
import com.robotsandpencils.androiddaggerpractice1.lobby.LobbyActivity;
import com.robotsandpencils.androiddaggerpractice1.lobby.LobbyFragment;
import com.robotsandpencils.androiddaggerpractice1.lobby.LobbyFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by pwray on 2017-10-30.
 *
 * Binds all sub-components within the app.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = LobbyActivityModule.class)
    abstract LobbyActivity bindLobbyActivity();

    @ContributesAndroidInjector(modules = LobbyFragmentModule.class)
    abstract LobbyFragment bindLobbyFragment();

    // Add bindings for other sub-components here
}
