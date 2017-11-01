package com.robotsandpencils.androiddaggerpractice1.lobby;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robotsandpencils.androiddaggerpractice1.R;
import com.robotsandpencils.androiddaggerpractice1.common.CommonHelloService;
import com.robotsandpencils.androiddaggerpractice1.databinding.LobbyActivityBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by pwray on 2017-10-30.
 *
 * For learning, I am using the android.app.Fragment,
 * instead of the android.support.v4.Fragment.
 * If the android.support.support.v4.Fragment is extended in LobbyFragment,
 * then implement HasSupportFragmentInjector.
 */

public class LobbyActivity extends AppCompatActivity implements HasFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    CommonHelloService commonHelloService;

    @Inject
    LobbyHelloService lobbyHelloService;

    private LobbyActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        // migrate to data binding
        binding = DataBindingUtil.setContentView(this, R.layout.lobby_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sayCommonHello();
        sayLobbyHello();
    }

    private void sayCommonHello() {
        binding.commonHello.setText(commonHelloService.sayHello());
    }

    private void sayLobbyHello() {
        binding.lobbyHello.setText(lobbyHelloService.sayHello());
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

}
