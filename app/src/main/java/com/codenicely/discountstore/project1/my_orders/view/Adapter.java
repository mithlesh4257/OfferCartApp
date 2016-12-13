package com.codenicely.discountstore.project1.my_orders.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codenicely.discountstore.project1.R;
import com.codenicely.discountstore.project1.helper.image_loader.GlideImageLoader;
import com.codenicely.discountstore.project1.helper.image_loader.ImageLoader;
import com.codenicely.discountstore.project1.my_orders.model.data.OrderDetails;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by iket on 3/11/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<OrderDetails> ordersDatas=new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    private MyOrdersFragment myOrdersFragment;


    public Adapter(Context context, MyOrdersFragment myOrdersFragment) {

        this.context=context;
        this.myOrdersFragment = myOrdersFragment;
        layoutInflater = LayoutInflater.from(context);
        imageLoader = new GlideImageLoader(context);

    }
    public void setData(List<OrderDetails> data)
    {
        ordersDatas=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.activity_orders_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        OrderDetails ordersDetails=ordersDatas.get(position);

        holder.title.setText(ordersDetails.getTitle());
        holder.address.setText(ordersDetails.getAddress());
        holder.cost.setText(ordersDetails.getCost());
        holder.valid.setText("Offer valid upto "+ordersDetails.getDate());
        holder.shop.setText(ordersDetails.getShop());
        imageLoader.loadImage(ordersDetails.getImage(),holder.image,holder.imageProgressBar);

    }

    @Override
    public int getItemCount() {
        return ordersDatas.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title,shop,address,valid,cost;
        private ImageView image;
        private ProgressBar imageProgressBar;


        private MyViewHolder(View itemView) {
            super(itemView);

            title=(TextView)itemView.findViewById(R.id.order_title);
            shop=(TextView)itemView.findViewById(R.id.order_shop);
            address=(TextView)itemView.findViewById(R.id.order_address);
            valid=(TextView)itemView.findViewById(R.id.order_validity);
            cost=(TextView)itemView.findViewById(R.id.order_cost);
            image=(ImageView)itemView.findViewById(R.id.image);
            imageProgressBar=(ProgressBar)itemView.findViewById(R.id.imageProgressBar);
        }

    }

}
