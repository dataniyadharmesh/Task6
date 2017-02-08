package com.dharmesh.task6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.print.PrintHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DHARMESH on 01-02-2017.
 */

public class Fragment3 extends Fragment {
    private Button b1;
    private Fragment f1,f2,f3;
    private View view;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment3, container,false);
        TextView name = (TextView)v.findViewById(R.id.name_txt);
        TextView  semester = (TextView)v.findViewById(R.id.semester_txt) ;
         String name_data = getArguments().getString("Name");
        String sem_data = getArguments().getString("Semester_data");
        name.setText(name_data);
        semester.setText(sem_data);
        b1 = (Button)v.findViewById(R.id.btn_goback);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                f2 = new Fragment2();
                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.main_id,f2);
                ft.addToBackStack("fragment3");
                fm.popBackStack("fragment2",2);
                ft.commit();

            }
        });
        return v;
    }
}
