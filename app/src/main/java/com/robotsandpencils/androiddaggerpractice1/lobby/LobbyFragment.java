package com.robotsandpencils.androiddaggerpractice1.lobby;

import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robotsandpencils.androiddaggerpractice1.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
//import dagger.android.support.AndroidSupportInjection;

/**
 * Created by pwray on 2017-10-30.
 */

public class LobbyFragment extends Fragment {

    @Inject
    LobbyFragmentHelloService lobbyFragmentHelloService;

    @BindView(R.id.lobby_fragment_hello)
    TextView lobbyFragmentHelloTextView;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        // use this if extending the support v4 Fragment
//        AndroidSupportInjection.inject(this);
        // use this if extending the android.app.Fragment
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lobby_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sayFragmentHello();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void sayFragmentHello() {
        lobbyFragmentHelloTextView.setText(lobbyFragmentHelloService.sayHello());
    }
}
