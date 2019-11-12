package com.example.prabin_login.fragments;

import android.content.Context;
import android.net.Uri;
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
import com.example.prabin_login.R;
import com.example.prabin_login.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SignupFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SignupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignupFragment extends Fragment {
    TextView etrUser, etrPassword, etrCPassword;
    Button btnSignup;
    private String Username, Password, CPassword;

    static List<User> userList = new ArrayList<>();

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_signup, container, false);
        etrUser= view.findViewById(R.id.etrUser);
        etrPassword=view.findViewById(R.id.etrPassword);
        etrCPassword=view.findViewById(R.id.etrCPassword);
        btnSignup=view.findViewById(R.id.btnSignup);



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Username= etrUser.getText().toString().trim();
                Password=etrPassword.getText().toString().trim();
                CPassword=etrCPassword.getText().toString().trim();

                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {
                    if (!Password.equals(CPassword)) {
                        etrCPassword.setError("Password Do not match");
                        Toast.makeText(getActivity(), "" + Password + " : another : " + CPassword, Toast.LENGTH_LONG).show();
                        onStop();
                    }

                    else
                    {

                        User user= new User();
                        user.setUser(Username);
                        user.setPass(Password);
                        userList.add(user);


                        CheckLogin checkLogin=new CheckLogin();
                        checkLogin.setUserList(userList);

                        for (int i = 0; i < checkLogin.getUserList().size(); i++) {
                            final User userdetail = checkLogin.getUserList().get(i);
                            Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_SHORT).show();
                        }




                        Toast.makeText(getActivity(), "Signup Sucessful : " + Username, Toast.LENGTH_LONG).show();
                        etrUser.setText("");
                        etrPassword.setText("");
                        etrCPassword.setText("");




                    }
                }
                else
                {
                    if(TextUtils.isEmpty(Username)){
                        etrUser.setError("Enter Username");}
                    if(TextUtils.isEmpty(Password)){
                        etrPassword.setError("Enter Password");}
                    if(TextUtils.isEmpty(CPassword)){
                        etrCPassword.setError("Conform Password");}
                    return;
                }

            }

        });

        return  view;
    }



}
