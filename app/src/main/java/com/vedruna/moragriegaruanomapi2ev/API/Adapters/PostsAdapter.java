package com.vedruna.moragriegaruanomapi2ev.API.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vedruna.moragriegaruanomapi2ev.API.DTO.PostDTO;
import com.vedruna.moragriegaruanomapi2ev.R;

import java.util.List;

public class PostsAdapter extends BaseAdapter {

    List<PostDTO> postDTOList;
    Context context;
    TextView nameText;
    TextView postIdText;
    ImageView imagePost;
    public PostsAdapter(List<PostDTO> postDTOList, Context context) {
        this.postDTOList = postDTOList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return postDTOList.size();
    }

    @Override
    public Object getItem(int i) {
        return postDTOList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return postDTOList.get(i).getPublicationId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.post_list, viewGroup, false);
        }
        imagePost = view.findViewById(R.id.imagePost);
        imagePost.setImageResource(R.drawable.user_icon);

        nameText = view.findViewById(R.id.nameText);
        postIdText = view.findViewById(R.id.postIdText);

        nameText.setText(postDTOList.get(i).getText());
        postIdText.setText(Long.toString(postDTOList.get(i).getPublicationId()));
        return view;
    }
}