package com.alejo_zr.petagram2;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pets> petss;
    private RecyclerView listaPets;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.activity_main);
        listaPets = (RecyclerView) findViewById(R.id.rvPets);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaPets.setLayoutManager(llm);
        inicializarListaPets();
        inicializarAdaptador();
    }


    public void inicializarListaPets() {

        petss = new ArrayList<Pets>();

        petss.add(new Pets(R.drawable.pet1, "Zeus", "5"));
        petss.add(new Pets(R.drawable.pet2, "Toby", "7"));
        petss.add(new Pets(R.drawable.pet3, "Druppy", "8"));
        petss.add(new Pets(R.drawable.pet4, "Mateo", "9"));
        petss.add(new Pets(R.drawable.pet5, "Lucas", "10"));
        petss.add(new Pets(R.drawable.pet6, "Luna", "3"));
        petss.add(new Pets(R.drawable.pet7, "Bruno", "4"));

    }

    public void inicializarAdaptador() {

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

        switch (item.getItemId()) {

            case R.id.mAbout:
                Snackbar.make(layout, getResources().getString(R.string.menu_about), Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.mSettings:
                Snackbar.make(layout, getResources().getString(R.string.menu_settings), Snackbar.LENGTH_SHORT).show();
                ;
                break;

            case R.id.iLike:
                Intent intent = new Intent(MainActivity.this, FavPets.class);
                startActivity(intent);
                break;

            case R.id.iHuella:
                Toast.makeText(this, getResources().getString(R.string.menu_huella), Toast.LENGTH_SHORT).show();
                break;


        }

        return super.onOptionsItemSelected(item);
    }

}
