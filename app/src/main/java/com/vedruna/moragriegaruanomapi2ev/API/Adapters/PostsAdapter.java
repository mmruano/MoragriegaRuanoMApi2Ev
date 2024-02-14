package com.vedruna.moragriegaruanomapi2ev.API.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vedruna.moragriegaruanomapi2ev.API.DTO.PostDTO;
import com.vedruna.moragriegaruanomapi2ev.R;

import java.util.List;

/**
 * Adaptador personalizado para mostrar una lista de publicaciones en una interfaz de usuario.
 */
public class PostsAdapter extends BaseAdapter {

    private List<PostDTO> postDTOList;
    private Context context;
    private TextView nameText;
    private TextView postIdText;
    private ImageView imagePost;

    /**
     * Constructor de la clase `PostsAdapter`.
     *
     * @param postDTOList Lista de objetos PostDTO que se mostrarán en la interfaz.
     * @param context     Contexto de la aplicación.
     */
    public PostsAdapter(List<PostDTO> postDTOList, Context context) {
        this.postDTOList = postDTOList;
        this.context = context;
    }

    /**
     * Devuelve la cantidad de elementos en la lista.
     *
     * @return Número de elementos en la lista.
     */
    @Override
    public int getCount() {
        return postDTOList.size();
    }

    /**
     * Devuelve el elemento en la posición especificada.
     *
     * @param i Índice del elemento.
     * @return Objeto PostDTO en la posición especificada.
     */
    @Override
    public Object getItem(int i) {
        return postDTOList.get(i);
    }

    /**
     * Devuelve el ID del elemento en la posición especificada.
     *
     * @param i Índice del elemento.
     * @return ID de la publicación en la posición especificada.
     */
    @Override
    public long getItemId(int i) {
        return postDTOList.get(i).getPublicationId();
    }

    /**
     * Devuelve la vista que representa un elemento en la posición especificada.
     *
     * @param i           Índice del elemento.
     * @param view        Vista reciclada para optimizar la eficiencia.
     * @param viewGroup   Grupo de vistas al que pertenece la vista.
     * @return Vista que representa un elemento en la posición especificada.
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.post_list, viewGroup, false);
        }

        // Configuración de la imagen predeterminada en la vista.
        imagePost = view.findViewById(R.id.imagePost);
        imagePost.setImageResource(R.drawable.user_icon);

        // Configuración de los elementos de texto en la vista.
        nameText = view.findViewById(R.id.nameText);
        postIdText = view.findViewById(R.id.postIdText);

        // Configuración del texto en los elementos de texto.
        nameText.setText(postDTOList.get(i).getText());
        postIdText.setText(Long.toString(postDTOList.get(i).getPublicationId()));

        return view;
    }
}