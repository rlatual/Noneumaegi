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
import com.nonu.noneumaegi.VO.MainItemVO;


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

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_listview_item,parent,false);
        }

        ImageView iv_img = convertView.findViewById(R.id.iv_image);
        ImageView iv_person = convertView.findViewById(R.id.iv_person);
        TextView tv_addr = convertView.findViewById(R.id.tv_addr);
        TextView tv_product = convertView.findViewById(R.id.tv_productname);
        TextView tv_money = convertView.findViewById(R.id.tv_money);
        TextView tv_number = convertView.findViewById(R.id.tv_number);

        MainItemVO mainItemVO = arrayList.get(pos);

        iv_img.setImageDrawable(mainItemVO.getIcon());
        iv_person.setImageDrawable(mainItemVO.getPerson());
        tv_addr.setText(mainItemVO.getAddr());
        tv_product.setText(mainItemVO.getName());
        tv_money.setText(mainItemVO.getMoney());
        tv_number.setText(mainItemVO.getNumber());

        return convertView;
    }

    public void addItem(Drawable img, Drawable person, String addr, String product, String money, String number){
        MainItemVO vo = new MainItemVO();

        vo.setIcon(img);
        vo.setPerson(person);
        vo.setAddr(addr);
        vo.setName(product);
        vo.setMoney(money);
        vo.setNumber(number);

        arrayList.add(vo);
    }
}
