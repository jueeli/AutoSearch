package com.autosearch;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mii-android2 on 21/7/16.
 */

public class AutoSearchAdapter extends RecyclerView.Adapter<AutoSearchAdapter.MyViewHolder> {
    ArrayList<String> listdata;
    ArrayList<String> clone;
    Context context;

    public AutoSearchAdapter(Context context, ArrayList<String> listdata) {
        this.context = context;
        this.listdata = listdata;
        clone=new ArrayList<>(listdata);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final String data = listdata.get(position);
        holder.title.setText(data);

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,AutoSearchCategary.class);
                intent.putExtra("MESSAGEFROM", data);
//                ((Activity) context).setResult(RESULT_OK, intent);
//                ((Activity) context).finish();//finishing activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listdata.size();
    }

    public void filter(String stringToSearch) {
        listdata.clear();
        if (stringToSearch.length() == 0) {
            listdata.addAll(clone);

        } else {
            for (String find : clone) {
                if (find.toLowerCase()
                        .contains(stringToSearch.toLowerCase())) {

                    listdata.add(find);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;


        public MyViewHolder(View view) {

            super(view);
            title = (TextView) view.findViewById(R.id.txt_search);

        }
    }
}