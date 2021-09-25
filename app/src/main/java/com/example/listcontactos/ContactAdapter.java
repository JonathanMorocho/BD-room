package com.example.listcontactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listcontactos.database.Contacto;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contacto> {

    private Context context;
    private ArrayList<Contacto> contactArrayList;

    public ContactAdapter(Context context, ArrayList<Contacto> contactArrayList){
        super(context, R.layout.list_contact);
        this.context=context;
        this.contactArrayList=contactArrayList;

    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Contacto getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Permite obtener la vista apartir de una fila determinada(position)
    //La vista que representa se pasa por paramentros al metodo(convert)
    //
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        final ViewHolder viewHolder;
        if(convertView == null || convertView.getTag() == null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.list_contact,parent, false);
            viewHolder.mContactName = (TextView) view.findViewById(R.id.adapterContactName);
            viewHolder.mimageView = view.findViewById(R.id.adapterContactImage);
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            view=convertView;
        }
        viewHolder.mContactName.setText(contactArrayList.get(position).getNombre());
        Glide.with(context)
                //.load("https://image.flaticon.com/icons/png/512/3447/3447687.png")
                .load(contactArrayList.get(position).getUrl())
                .into(viewHolder.mimageView);

        return view;
    }



    static class ViewHolder{
        protected TextView mContactName;
        protected ImageView mimageView;
    }


}
