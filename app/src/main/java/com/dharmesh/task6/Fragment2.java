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
import android.widget.EditText;

/**
 * Created by DHARMESH on 01-02-2017.
 */


public class Fragment2 extends Fragment {
    private Button b1,b2;
    private Fragment f1,f2,f3;
    private View view;
    private EditText semester;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     //   return super.onCreateView(inflater, container, savedInstanceState);


        View v = inflater.inflate(R.layout.fragment2, container,false);
        b1 = (Button)v.findViewById(R.id.btn_goto_c);
        semester = (EditText)v.findViewById(R.id.sem);
        final String semData = semester.getText().toString();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
               // String name = getArguments().getString("Name");
                String data_sem = semester.getText().toString();
                f3 = new Fragment3();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
              //  args.putString("Name", name);
                args.putString("Semester_data",data_sem);
                f3.setArguments(args);
                ft.replace(R.id.main_id,f3);
                ft.addToBackStack(null);
                fm.popBackStack();
                semester.clearFocus();
                ft.commit();

            }
        });
        b2 = (Button)v.findViewById(R.id.btn_goto_a);
        semester = (EditText)v.findViewById(R.id.sem);
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
