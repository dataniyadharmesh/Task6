package com.dharmesh.task6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by DHARMESH on 01-02-2017.
 */


public class Fragment2 extends Fragment {
    private Button b1,b2;
    private Fragment f1,f2,f3;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     //   return super.onCreateView(inflater, container, savedInstanceState);


        View v = inflater.inflate(R.layout.fragment2, container,false);
        b1 = (Button)v.findViewById(R.id.btn_goto_c);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f3 = new Fragment3();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_id,f3);
                ft.addToBackStack(null);
                fm.popBackStack();
                ft.commit();

            }
        });
        b2 = (Button)v.findViewById(R.id.btn_goto_a);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f2 = new Fragment1();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_id,f2);
                ft.addToBackStack(null);
                fm.popBackStack();
                ft.commit();

            }
        });
        return v;
    }
}
