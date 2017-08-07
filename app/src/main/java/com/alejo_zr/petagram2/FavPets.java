package com.alejo_zr.petagram2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class FavPets extends AppCompatActivity {

    ArrayList<Pets> petss;
    private RecyclerView listaPets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_pets);
        listaPets = (RecyclerView) findViewById(R.id.rvFavPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();
    }


    public void inicializarListaPets(){

        petss = new ArrayList<Pets>();

        petss.add(new Pets(R.drawable.pet1, "Zeus", "5" ));
        petss.add(new Pets(R.drawable.pet2, "Toby", "7" ));
        petss.add(new Pets(R.drawable.pet3, "Druppy", "8" ));
        petss.add(new Pets(R.drawable.pet4, "Mateo", "9" ));
        petss.add(new Pets(R.drawable.pet5, "Lucas", "10" ));


    }

    public void inicializarAdaptador(){

        PetAdaptador adaptador = new PetAdaptador(petss);
        listaPets.setAdapter(adaptador);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.iLike:
                Toast.makeText(this,"te gustó", Toast.LENGTH_LONG).show();
                break;
            case R.id.iHuella:
                Toast.makeText(this,"huellita",Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }

}

