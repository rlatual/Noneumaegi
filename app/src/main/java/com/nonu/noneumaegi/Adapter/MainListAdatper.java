package com.nonu.noneumaegi.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.nonu.noneumaegi.R;
import com.nonu.noneumaegi.VO.MainItemVO;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainListAdatper extends BaseAdapter {
    private ArrayList<MainItemVO> arrayList = new ArrayList<>();

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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
            convertView = inflater.inflate(R.layout.main_listview_item, parent, false);
        }

        ImageView iv_img = convertView.findViewById(R.id.iv_image);
        TextView tv_addr = convertView.findViewById(R.id.tv_addr);
        TextView tv_product = convertView.findViewById(R.id.tv_productname);
        TextView tv_money = convertView.findViewById(R.id.tv_money);
        TextView tv_number = convertView.findViewById(R.id.tv_number);
        TextView tv_joinperson = convertView.findViewById(R.id.tv_person2);
        TextView tv_leftperson = convertView.findViewById(R.id.tv_person4);

        MainItemVO mainItemVO = arrayList.get(pos);

        iv_img.setImageBitmap(mainItemVO.getIcon());

        tv_addr.setText(mainItemVO.getAddr());
        tv_product.setText(mainItemVO.getName());
        tv_money.setText(mainItemVO.getMoney());
        tv_number.setText(mainItemVO.getNumber());
        tv_joinperson.setText(mainItemVO.getJoinperson()+"");
        tv_leftperson.setText(mainItemVO.getTotalperson()-mainItemVO.getJoinperson()+"");

        return convertView;
    }

    public void addItem(Bitmap img, String addr, String product, String money, String number, int total, int join) {
        MainItemVO vo = new MainItemVO();

        vo.setIcon(img);
        vo.setAddr(addr);
        vo.setName(product);
        vo.setMoney(money);
        vo.setNumber(number);
        vo.setTotalperson(total);
        vo.setJoinperson(join);

        arrayList.add(vo);
    }
}
