package com.robotsandpencils.androiddaggerpractice1.lobby;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pwray on 2017-10-30.
 */
@Module
public class LobbyFragmentModule {

    @Provides
    LobbyFragmentHelloService provideLobbyFragmentHelloService() {
        return new LobbyFragmentHelloService();
    }
}
