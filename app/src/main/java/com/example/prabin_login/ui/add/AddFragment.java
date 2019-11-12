package com.example.prabin_login.ui.add;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabin_login.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements  View.OnClickListener {


    EditText etFirst,etSecond;
    Button btnCalculate;
    TextView tvResult;
    int num1, num2, result;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_add, container, false);


        etFirst=view.findViewById(R.id.etFirst);
        etSecond=view.findViewById(R.id.etSecond);
        btnCalculate=view.findViewById(R.id.btnCalculate);
        tvResult=view.findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(this);
        return  view;

    }

    @Override
    public void onClick(View v) {

        num1=Integer.parseInt(etFirst.getText().toString());
        num2=Integer.parseInt(etSecond.getText().toString());
        result=num1+num2;
        // tvResult.setText(result);

        Toast.makeText(getActivity(), "The sum is: "+result, Toast.LENGTH_SHORT).show();


    }
}