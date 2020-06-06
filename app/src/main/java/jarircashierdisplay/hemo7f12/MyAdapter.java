package jarircashierdisplay.hemo7f12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public List<MyListView> cashierList;

    public MyAdapter(List<MyListView> cashierList) {
        this.cashierList = cashierList;
    }//end MyAdapter Const.

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cashier_position, parent, false);

        return new MyViewHolder(itemView);
    }//end onCreateViewHolder

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyListView list = cashierList.get(position);
        holder.cp.setText(list.getCp());
        holder.img1.setImageResource(list.getImg1());
        holder.img2.setImageResource(list.getImg2());
        holder.img3.setImageResource(list.getImg3());

    }//end onBindViewHolder

    @Override
    public int getItemCount() {
        return cashierList.size();
    }//end getItemCount

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView cp;
        public ImageView img1, img2, img3;

        public MyViewHolder(View itemView) {
            super(itemView);
            cp = itemView.findViewById(R.id.cashier_number);
            img1 = itemView.findViewById(R.id.cashier_right);
            img2 = itemView.findViewById(R.id.cashier_end);
            img3 = itemView.findViewById(R.id.cashier_left);
        }//end MyViewHolder

    }//end MyViewHolder ViewHolder


}//end Class
