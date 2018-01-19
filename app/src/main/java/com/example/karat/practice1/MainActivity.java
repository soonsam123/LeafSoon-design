package com.example.karat.practice1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Intent intentEnviarVideo;

    TextInputLayout tituloLayout, categoriaLayout, metaDeLikeLayout, descricaoLayout;
    AppCompatEditText tituloEditText, categoriaEditText, metaDeLikeEditText, descricaoEditText;

    RelativeLayout relativeLayout;

    AppCompatButton enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        /*====Toolbar====*/
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        /*====Assigning values====*/
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        intentEnviarVideo = new Intent(this, EnviarVideoActivity.class);

        tituloLayout = findViewById(R.id.tituloLayout);
        descricaoLayout = findViewById(R.id.descricaoLayout);
        tituloEditText = findViewById(R.id.tituloEditText);
        descricaoEditText = findViewById(R.id.descricaoEditText);

        relativeLayout = findViewById(R.id.relativeLayout);

        enviarButton = findViewById(R.id.enviar_id);

        /*====Click in the drawerLayout buttons====*/
        navigationView.setNavigationItemSelectedListener(this);

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Video enviado com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

        /*====Connect the toggle button within the drawerLayout====*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);

        toggle.syncState();




        /*=================== Titulo functions ===================*/
        tituloEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if (tituloEditText.getText().toString().isEmpty()){

                    tituloLayout.setErrorEnabled(true);
                    tituloLayout.setError("Campo obrigatório");

                } else {

                    tituloLayout.setErrorEnabled(false);

                }

            }
        });


        tituloEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (tituloEditText.getText().toString().isEmpty()){

                    tituloLayout.setErrorEnabled(true);
                    tituloLayout.setError(getString(R.string.campo_obrigatorio));

                } else {

                    tituloLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tituloLayout.setCounterEnabled(true);
        tituloLayout.setCounterMaxLength(100);
        /*=================== END OF Titulo functions ===================*/



        /*=================== LAYOUT ===================*/
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                relativeLayout.setFocusable(true);
                relativeLayout.setFocusableInTouchMode(true);

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputMethodManager != null && getCurrentFocus().getWindowToken() != null) {
                    inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }

            }
        });
        /*=================== END OF LAYOUT ===================*/


        /*=================== Descrição ===================*/

        descricaoLayout.setCounterEnabled(true);
        descricaoLayout.setCounterMaxLength(1000);

        /*=================== END OF Descrição ===================*/


    }

    /*==== Menu right side====*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.meucanal_id:
                Toast.makeText(this, R.string.meu_canal, Toast.LENGTH_SHORT).show();
                break;
            case R.id.configuracoes_id:
                Toast.makeText(this, R.string.configura_es, Toast.LENGTH_SHORT).show();
                break;
            case R.id.sair_id:
                Toast.makeText(this, R.string.sair, Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_id:
                Toast.makeText(this, R.string.pesquisar, Toast.LENGTH_SHORT).show();
                break;
            case R.id.upload_id:
                startActivity(intentEnviarVideo);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    /*==== END OF Menu right side====*/




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.meuCanal_drawer_id:
                Toast.makeText(this, R.string.meu_canal, Toast.LENGTH_SHORT).show();
                break;

            case R.id.enviarVideo_drawer_id:
                Toast.makeText(this, R.string.enviar_video, Toast.LENGTH_SHORT).show();
                break;

            case R.id.videosDestaque_drawer_id:
                Toast.makeText(this, R.string.videos_destaque, Toast.LENGTH_SHORT).show();
                break;

            case R.id.comedia_drawer_id:
                Toast.makeText(this, R.string.comedia, Toast.LENGTH_SHORT).show();
                break;

            case R.id.games_drawer_id:
                Toast.makeText(this, R.string.games, Toast.LENGTH_SHORT).show();
                break;

            case R.id.esportes_drawer_id:
                Toast.makeText(this, R.string.esportes, Toast.LENGTH_SHORT).show();
                break;

            case R.id.vlogs_drawer_id:
                Toast.makeText(this, R.string.vlogs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.canal1_drawer_id:
                Toast.makeText(this, R.string.atletas_pelo_mundo, Toast.LENGTH_SHORT).show();
                break;

            case R.id.canal2_drawer_id:
                Toast.makeText(this, R.string.pool_games, Toast.LENGTH_SHORT).show();
                break;

            case R.id.canal3_drawer_id:
                Toast.makeText(this, R.string.next_level_calistenia, Toast.LENGTH_SHORT).show();
                break;

            case R.id.canal4_drawer_id:
                Toast.makeText(this, R.string.macho_alfa, Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
