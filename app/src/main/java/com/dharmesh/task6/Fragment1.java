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

public class Fragment1 extends Fragment {
    private Button b1;
    private Fragment f1,f2;
private EditText name;
    private View view;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container,false);
        b1 = (Button)v.findViewById(R.id.btn_goto_b);

        name = (EditText)v.findViewById(R.id.name);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = name.getText().toString();
                Bundle txtNameData = new Bundle();
                txtNameData.putString("Name",data);
                f2 = new Fragment2();

                FragmentManager fm =getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                f2.setArguments(txtNameData);
                ft.replace(R.id.main_id,f2);
                fm.popBackStack();
                name.clearFocus();
                ft.commit();




            }
        });
        return v;



    }


}
