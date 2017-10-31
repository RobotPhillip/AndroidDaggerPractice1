package com.robotsandpencils.androiddaggerpractice1.lobby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.robotsandpencils.androiddaggerpractice1.R;
import com.robotsandpencils.androiddaggerpractice1.common.CommonHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

/**
 * Created by pwray on 2017-10-30.
 */

public class LobbyActivity extends AppCompatActivity {

    @Inject
    CommonHelloService commonHelloService;

    @BindView(R.id.common_hello)
    TextView commonHelloTextView;

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
    }

    private void sayCommonHello() {
        commonHelloTextView.setText(commonHelloService.sayHello());
    }
}
