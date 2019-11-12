package com.example.prabin_login.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prabin_login.CheckLogin;
import com.example.prabin_login.Navigation_Activity;
import com.example.prabin_login.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    TextView etUser, etPassword;
    Button btnLogin;

    private String Username, Password;boolean status;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etUser=view.findViewById(R.id.etUser);
        etPassword=view.findViewById(R.id.etPassword);
        btnLogin=view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username= etUser.getText().toString().trim();
                Password=etPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {

                    CheckLogin checkLogin=new CheckLogin();
                    checkLogin.setUsername(Username);
                    checkLogin.setPassword(Password);
                    status=checkLogin.chkLogin();


//                    for (int i = 0; i < checkLogin.getUserList().size(); i++) {
//                        final User userdetail = checkLogin.getUserList().get(i);
//
//
//                        Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_SHORT).show();
//                    }

                    if(status){
                        Toast.makeText(getActivity(), "Login Successful, Welcome: " +Username, Toast.LENGTH_LONG).show();
                        etUser.setText("");
                        etPassword.setText("");

                        /// new activcity

                        Intent intent = new Intent(getActivity(), Navigation_Activity.class);
                        intent.putExtra(EXTRA_MESSAGE, Username);
                        startActivity(intent);


                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Username && Password did not match", Toast.LENGTH_LONG).show();
                        etUser.setText("");
                        etPassword.setText("");
                    }
                }
                else
                {
                    if(TextUtils.isEmpty(Username)){
                        etUser.setError("Enter Username");}
                    if(TextUtils.isEmpty(Password)){
                        etUser.setError("Enter Password");}
                    return;
                }

            }
        });


        return  view;
    }


}
