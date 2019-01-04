package my_plans_recycler_view_handler.logic;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.ambaqi.musicevent.ava.R;

public class RowPlanViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout myPlanRowLayout;
    private TextView myPlanRowTextView;
    public RowPlanViewHolder(View itemView) {
        super(itemView);
        myPlanRowLayout = (LinearLayout) itemView.findViewById(R.id.goToPlanDetailLinearLayout);
        myPlanRowTextView = (TextView) itemView.findViewById(R.id.myPlanTextView);
    }


    public LinearLayout getMyPlanRowLayout() {
        return myPlanRowLayout;
    }

    public TextView getMyPlanRowTextView() {
        return myPlanRowTextView;
    }
}
