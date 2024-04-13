package com.example.semana02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.semana02.R;
import com.example.semana02.entity.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User>  {

    private Context context;
    private  List<User> objects;
    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.user_item, parent, false);

        User objUser = objects.get(position);

        TextView txtId = row.findViewById(R.id.idItemUserId);
        txtId.setText(String.valueOf(objUser.getId()));

        TextView txtName = row.findViewById(R.id.idItemName);
        txtName.setText(objUser.getName());

        TextView txtEmail = row.findViewById(R.id.idItemEmail);
        txtEmail.setText(objUser.getEmail());

        TextView txtPhone= row.findViewById(R.id.idItemPhone);
        txtPhone.setText(objUser.getPhone());

        TextView txtWebsite= row.findViewById(R.id.idItemWebsite);
        txtWebsite.setText(objUser.getWebsite());
        return row;
    }
}
