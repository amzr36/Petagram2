package com.alejo_zr.petagram2;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Alejo on 03/08/2017.
 */

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHOlder> {

    ArrayList<Pets> petss;

    public PetAdaptador (ArrayList<Pets> petss){
         this.petss = petss;
    }


    @Override
    public PetViewHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        //Da vida al Layout, el q recicla
        return new PetViewHOlder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(PetViewHOlder petViewHOlder, int position) { //Se pasa la lista de contactos
        Pets pets = petss.get(position);
        petViewHOlder.imgFoto.setImageResource(pets.getFoto());
        petViewHOlder.tvPetNom.setText(pets.getNombre());
        petViewHOlder.tvLikes.setText(pets.getLikes());
    }

    @Override
    public int getItemCount() {//Cantidad de elementos que contiene mi lista
        return petss.size();
    }

    public static class PetViewHOlder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvPetNom;
        private  TextView tvLikes;


        public PetViewHOlder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvPetNom    = (TextView) itemView.findViewById(R.id.tvPetNom);
            tvLikes     = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }

}
