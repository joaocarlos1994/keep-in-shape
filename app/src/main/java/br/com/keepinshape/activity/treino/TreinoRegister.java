package br.com.keepinshape.activity.treino;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.activity.exercicio.ExercicioAdapter;
import br.com.keepinshape.api.entity.Exercicio;
import br.com.keepinshape.core.helper.ExercicioFactory;
import br.com.keepinshape.core.impl.ExercicioDaoImpl;

public class TreinoRegister extends ActionBarActivity {

    private List<Exercicio> exercicios;
    private ExercicioAdapter exercicioAdapter;
    private Spinner sp;
    private List<Exercicio> exerciciosSelecionados = new ArrayList<Exercicio>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_register);

        loadAllExerciseSpinner();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_treino_register, menu);
        return true;
    }

    public void loadAllExerciseSpinner (){


        try {

            ExercicioDaoImpl exerciciosDaoImpl = ExercicioFactory.getInstanceExercicioDaoImpl(this);
            exercicios = exerciciosDaoImpl.queryForAll();
            exercicioAdapter = new ExercicioAdapter(this, exercicios);
            sp = (Spinner) findViewById(R.id.spinnerExercicio);
            sp.setAdapter(exercicioAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayAdapter<Exercicio> dataAdapter = new ArrayAdapter<Exercicio>(this,
                android.R.layout.simple_spinner_item, exercicios);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


    }

    public void handlerTreinoAddExercicio(View view) {

        sp = (Spinner) findViewById(R.id.spinnerExercicio);
        Exercicio exercicio = (Exercicio) sp.getSelectedItem();
        exerciciosSelecionados.add(exercicio);


        GridView gridView = (GridView) findViewById(R.id.gridViewExercicioCadastrados);
        final ExercicioAdapter exercicioAdapter = new ExercicioAdapter(this, exerciciosSelecionados);
        gridView.setAdapter(exercicioAdapter);

        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Exercicio exercicio = (Exercicio) exercicioAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
