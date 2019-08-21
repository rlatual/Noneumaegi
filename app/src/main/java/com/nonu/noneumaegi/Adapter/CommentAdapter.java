package com.nonu.noneumaegi.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nonu.noneumaegi.R;
import com.nonu.noneumaegi.VO.Comment;

import java.util.ArrayList;

public class CommentAdapter extends BaseAdapter {
    ArrayList<Comment> comments = new ArrayList<>();

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return comments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(comments.get(pos).isComofcom()){
                convertView = inflater.inflate(R.layout.commentofcomment,parent,false);
            }else{
                convertView = inflater.inflate(R.layout.comment,parent,false);
            }
        }

        ImageView img = convertView.findViewById(R.id.iv_image);
        TextView nickname = convertView.findViewById(R.id.tv_nickname);
        TextView content = convertView.findViewById(R.id.tv_content);

        Comment comment = comments.get(pos);

        img.setImageDrawable(comment.getImg());
        nickname.setText(comment.getNickname());
        content.setText(comment.getContent());

        return convertView;
    }

    public void addItem(Drawable img, String nickname, String content){
        Comment c = new Comment();
        c.setImg(img);
        c.setNickname(nickname);
        c.setContent(content);
        comments.add(c);
    }
}
