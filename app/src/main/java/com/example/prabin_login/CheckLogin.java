package com.example.prabin_login;

import java.util.List;

public class CheckLogin {
    static List<User> UserList;
    boolean result=false;
    String Username, Password;


    public void setUserList(List<User> userList) {
        UserList=userList;

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<User> getUserList() {
        return UserList;
    }

    public boolean chkLogin() {
//        User user =new User();
//        user.setUser("sujan");
//        user.setPass("sujan");
//        UserList.add(user);
//        setUserList(UserList);

//        if (Username.equals( "prabin") && Password.equals("prabin")) {
//                        result = true;
//                    } else {
//                        result = false;
//                    }







        if(getUserList()!= null) {

            for (int i = 0; i < getUserList().size(); i++) {
                final User userdetail = getUserList().get(i);
                if (Username.equals(userdetail.getUser()) && Password.equals(userdetail.getPass())) {
                    result = true;
                } else {
                    result = false;
                }

                //Toast.makeText(getActivity(), ""+userdetail.getUser(), Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            result=false;

        }


        return result;

    }




}
