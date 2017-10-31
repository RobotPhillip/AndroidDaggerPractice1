package com.robotsandpencils.androiddaggerpractice1.lobby;

import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.robotsandpencils.androiddaggerpractice1.R;
import com.robotsandpencils.androiddaggerpractice1.common.CommonHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by pwray on 2017-10-30.
 *
 * For learning, I am using the android.app.Fragment,
 * instead of the android.support.v4.Fragment.
 * If the android.support.support.v4.Fragment is extended in LobbyFragment,
 * then implement HasSupportFragmentInjector.
 */

public class LobbyActivity extends AppCompatActivity implements HasFragmentInjector {
//public class LobbyActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    CommonHelloService commonHelloService;

    @Inject
    LobbyHelloService lobbyHelloService;

    @BindView(R.id.common_hello)
    TextView commonHelloTextView;

    @BindView(R.id.lobby_hello)
    TextView lobbyHelloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sayCommonHello();
        sayLobbyHello();
    }

    private void sayCommonHello() {
        commonHelloTextView.setText(commonHelloService.sayHello());
    }

    private void sayLobbyHello() {
        lobbyHelloTextView.setText(lobbyHelloService.sayHello());
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return fragmentDispatchingAndroidInjector;
//    }
}
