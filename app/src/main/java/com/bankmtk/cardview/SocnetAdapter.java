package com.bankmtk.cardview;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SocnetAdapter extends RecyclerView.Adapter<SocnetAdapter.ViewHolder> {
    private List<Soc> dataSource;
    private OnItemClicklistener itemClickListener;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView description;
        public ImageView picture;
        public CheckBox complete;

        public ViewHolder(View v){
            super(v);
            description  =v.findViewById(R.id.description);
            picture = v.findViewById(R.id.picture);
            complete = v.findViewById(R.id.complete);

            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener !=null){
                        itemClickListener.onItemClick(v,getAdapterPosition());
                    }
                }
            });
        }
    }
    public interface OnItemClicklistener{
        void onItemClick(View view, int position);
    }
    public void SetOnItemClickListener(OnItemClicklistener itemClicklistener){
        this.itemClickListener = itemClickListener;
    }
    public SocnetAdapter(List<Soc> dataSource){
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public SocnetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.d("SocnetAdapter","onCreateViewHolder");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Soc item = dataSource.get(position);
        holder.description.setText(item.getDescription());
        holder.picture.setImageResource(item.getPicture());
        holder.complete.setChecked(item.getComplete());

        Log.d("SocnetAdapter","onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
