package com.example.prabin_login.adapters;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prabin_login.DetailsActivity;
import com.example.prabin_login.R;
import com.example.prabin_login.models.UserDetail;
import com.example.prabin_login.recycler.RecyclerFragment;

import java.util.List;

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailAdapter.UserDetailViewHolder> {
    RecyclerFragment context;
    List<UserDetail> userDetailList;


    public UserDetailAdapter(RecyclerFragment context, List<UserDetail> userDetailList) {
        this.context = context;
        this.userDetailList = userDetailList;
    }

    public UserDetailAdapter(com.example.prabin_login.ui.recycler.RecyclerFragment recyclerFragment, List<UserDetail> userList) {
    }

    @NonNull
    @Override
    public UserDetailAdapter.UserDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.userview, parent, false);
        return new UserDetailViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull UserDetailAdapter.UserDetailViewHolder holder, int position) {
        final UserDetail userDetail = userDetailList.get(position);



        int image_id = userDetail.getImageId();
        final int age = userDetail.getAge();

        holder.ivImage.setImageResource(image_id);
        holder.tvName.setText(userDetail.getName().toString());
        holder.tvAge.setText(String.valueOf(age));
        holder.tvGender.setText(userDetail.getGender().toString());
        //holder.ivImage.setImageResource(2131099747);




        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                final int agee = userDetail.getAge();
                intent.putExtra("name",userDetail.getName());
                intent.putExtra("image",userDetail.getImageId());
                intent.putExtra("age",String.valueOf(agee));
                intent.putExtra("gender",userDetail.getGender());


                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return userDetailList.size();
    }


    public  class UserDetailViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvName, tvGender, tvAge;
        Button btndelete;


        public UserDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            btndelete = itemView.findViewById(R.id.btndelete);
        }



    }

}



