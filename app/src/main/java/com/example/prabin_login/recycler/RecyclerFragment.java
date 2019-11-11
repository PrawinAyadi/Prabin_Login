package com.example.prabin_login.recycler;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.prabin_login.R;
import com.example.prabin_login.adapters.UserDetailAdapter;
import com.example.prabin_login.models.UserDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment implements  View.OnClickListener {
    EditText etName,etAge;
    RadioButton rbMale, rbFemale, rbOthers;
    Spinner spinner;
    Button btnSave;
    RadioGroup rg;
    RecyclerView recyclerView;
    String gen;
    int img;
    List<UserDetail> userList = new ArrayList<>();


    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recycler, container, false);

        etName=view.findViewById(R.id.etName);
        etAge=view.findViewById(R.id.etAge);
        rbMale=view.findViewById(R.id.rbMale);
        rbFemale=view.findViewById(R.id.rbFemale);
        rbOthers=view.findViewById(R.id.rbOthers);
        btnSave=view.findViewById(R.id.btnSave);
        spinner=view.findViewById(R.id.spinner);
        rg=view.findViewById(R.id.rg);

        recyclerView = view.findViewById(R.id.recyclerView);
        btnSave.setOnClickListener(this);


        String[] images = {"Select Image", "Birat", "Model", "Old", "Four", "Five", "Six"};

        final ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                images);
        spinner.setAdapter(adapter);

        return  view;
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.equals(etName.getText().toString(),"")){
            return;
        }
        if(TextUtils.equals(etAge.getText().toString(),"")){
            return;
        }



        if(rbMale.isChecked()){
            gen="Male";
        }
        if(rbFemale.isChecked()){
            gen="Female";
        }
        if(rbOthers.isChecked()){
            gen="Others";
        }
        String image=spinner.getSelectedItem().toString();
        if(image=="Birat"){
            img=  R.drawable.three ;
        }
        if(image=="Model"){
            img=  R.drawable.two ;
        }
        if(image=="Old"){
            img=  R.drawable.one ;
        }
        if(image=="Four"){
            img=  R.drawable.four ;
        }
        if(image=="Five"){
            img=  R.drawable.five ;
        }
        if(image=="Six"){
            img=  R.drawable.six ;
        }

        int age=Integer.parseInt(etAge.getText().toString());

        boolean add = userList.add(new UserDetail(etName.getText().toString(), age, gen, img));

        UserDetailAdapter userDetailAdapter = new UserDetailAdapter(this,userList);
        recyclerView.setAdapter(userDetailAdapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));





        etName.setText("");
        etAge.setText("");
        rbFemale.clearFocus();
        rbOthers.clearFocus();
        rbMale.clearFocus();
        spinner.clearFocus();

    }
}
