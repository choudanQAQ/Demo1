package com.example.gjl.myjddemo.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gjl.myjddemo.R;
import com.example.gjl.myjddemo.view.activities.DetailActivity;

import java.util.List;

/**
 * Created by gjl on 2018/3/29.
 */

public class MiaoShaAdapter extends BaseAdapter {
    private Context context;
    private List<ShouYeBean.MiaoshaBean.ListBeanX> list;
    public MiaoShaAdapter(Context context, List<ShouYeBean.MiaoshaBean.ListBeanX> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.ms_item,null);
            TextView name = convertView.findViewById(R.id.item_name);
            ImageView pic = convertView.findViewById(R.id.item_pic);

            myViewHolder=new MyViewHolder(name,pic);

            convertView.setTag(myViewHolder);

        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }

        myViewHolder.getName().setText(list.get(position).getTitle());

        String url=list.get(position).getImages().split("\\|")[0];

        Glide.with(context).load(url).into(myViewHolder.getPic());


        myViewHolder.getPic().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("detail_url",list.get(position).getDetailUrl());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class MyViewHolder{
        private TextView name;
        private ImageView pic;

        public MyViewHolder(TextView name, ImageView pic) {
            this.name = name;
            this.pic = pic;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public ImageView getPic() {
            return pic;
        }

        public void setPic(ImageView pic) {
            this.pic = pic;
        }
    }
}
