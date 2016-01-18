package br.com.keepinshape;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.sql.SQLException;

import br.com.keepinshape.activity.exercicio.ExercicioList;
import br.com.keepinshape.activity.exercicio.ExercicioRegister;
import br.com.keepinshape.activity.pessoa.PessoaRegister;
import br.com.keepinshape.activity.treino.TreinoList;
import br.com.keepinshape.activity.treino.TreinoRegister;
import br.com.keepinshape.api.entity.Pessoa;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.helper.DatabaseHelperFactory;
import br.com.keepinshape.core.helper.PessoaFactory;
import br.com.keepinshape.core.helper.facade.PessoaFacadeFactory;
import br.com.keepinshape.core.impl.PessoaDaoImpl;


public class MainActivity extends ActionBarActivity {


    //Como criar gráficos Android http://www.android-graphview.org/download--getting-started.html
    //https://www.youtube.com/watch?v=R1ApbajtVyg


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelperFactory.getIntanceConnection(MainActivity.this); //Criando o banco ou carregando conexões

        if (PessoaFacadeFactory.getInstancePessoaFacade().findById(1, this) instanceof Pessoa){

            setContentView(R.layout.activity_main);

        } else {

            startActivity(new Intent(this, PessoaRegister.class));
        }


    }

    public void handlerStartAcitivityExercicioList (View view){
        startActivity(new Intent(this, ExercicioList.class));
    }

    public void handlerStartAcitivityExercicioRegister (View view){
        startActivity(new Intent(this, ExercicioRegister.class));
    }

    public void handlerStartAcitivityTreinoList (View view){
        startActivity(new Intent(this, TreinoList.class));
    }

    public void handlerStartAcitivityTreinoRegister(View view){
        startActivity(new Intent(this, TreinoRegister.class));
    }



    //IMC, relação cintura quadril, dobras cuntania


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
