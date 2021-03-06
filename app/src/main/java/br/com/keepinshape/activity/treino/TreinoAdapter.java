package br.com.keepinshape.activity.treino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.keepinshape.R;
import br.com.keepinshape.api.entity.Treino;
import br.com.keepinshape.core.service.ConvertToTypes;

/**
 * Created by root on 25/09/15.
 */
public class TreinoAdapter extends BaseAdapter {

    private Context context;
    private List<Treino> treinos;

    public TreinoAdapter (Context context, List<Treino> treinos){
        this.context = context;
        this.treinos = treinos;
    }

    @Override
    public int getCount() {
        return treinos.size();
    }

    @Override
    public Object getItem(int position) {
        return treinos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Treino treino = treinos.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.treino, null);

        TextView id = (TextView) layout.findViewById(R.id.treino_list_id);
        id.setText(ConvertToTypes.convertIntToString(treino.get_id()));

        TextView nome = (TextView) layout.findViewById(R.id.txtNomeTreino);
        nome.setText(treino.getNome());

        TextView semana = (TextView) layout.findViewById(R.id.txtTreinoSemana);
        semana.setText(treino.getDiaSemana());

        TextView tipo = (TextView) layout.findViewById(R.id.txtTreinoTipo);
        tipo.setText(treino.getTipo());

        return layout;
    }
}
