package com.robotsandpencils.androiddaggerpractice1.lobby;

import android.app.Fragment;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robotsandpencils.androiddaggerpractice1.R;
import com.robotsandpencils.androiddaggerpractice1.databinding.LobbyFragmentBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * Created by pwray on 2017-10-30.
 */

public class LobbyFragment extends Fragment {

    @Inject
    LobbyFragmentHelloService lobbyFragmentHelloService;

    private LobbyFragmentBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.lobby_fragment, container, false);
        View view = binding.getRoot();

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
        binding.unbind();
    }

    private void sayFragmentHello() {
        binding.lobbyFragmentHello.setText(lobbyFragmentHelloService.sayHello());
    }
}
