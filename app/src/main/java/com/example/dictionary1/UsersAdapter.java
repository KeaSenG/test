package com.example.dictionary1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public  class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVn> implements Filterable {

    private List<UserModel> userModelList;
    private Context context;
    private List<UserModel> getUserModelListFiltered;
    private SelectedUser selectedUser;

    public UsersAdapter(List<UserModel> userModelList,SelectedUser selectedUser) {
        this.userModelList=userModelList;
        this.getUserModelListFiltered = userModelList ;
        this.selectedUser=selectedUser;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersAdapterVn onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapterVn(LayoutInflater.from(context).inflate(R.layout.row_users,null));
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersAdapterVn holder, int position) {
        UserModel userModel = userModelList.get(position);

        String username = userModel.getUsername();
        String prefix = userModel.getUsername().substring(0,1);

        holder.tvUsername.setText(username);
        holder.tvPrefix.setText(prefix);

    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if(charSequence == null | charSequence.length() == 0) {
                    filterResults.count = getUserModelListFiltered.size();
                    filterResults.values = getUserModelListFiltered;

                }else{
                    String searchChr = charSequence.toString().toLowerCase();

                    List<UserModel> resultData = new ArrayList<>();

                    for (UserModel userModel : getUserModelListFiltered){
                        if(userModel.getUsername().toLowerCase().contains(searchChr)){
                            resultData.add(userModel);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                userModelList =(List<UserModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public interface SelectedUser{

        void selectedUser(UserModel userModel);
    }

    public class UsersAdapterVn extends RecyclerView.ViewHolder {

        TextView tvPrefix;
        TextView tvUsername;
        ImageView imIcon;
        public UsersAdapterVn(@NonNull View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.prefix);
            tvUsername = itemView.findViewById(R.id.usesname);
            imIcon = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedUser.selectedUser(userModelList.get(getAdapterPosition()));
                }
            });
        }
    }
}