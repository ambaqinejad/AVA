package my_plans_recycler_view_handler.logic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import ir.ambaqi.musicevent.ava.PlanDetailActivity;
import ir.ambaqi.musicevent.ava.R;
import my_plans_recycler_view_handler.data.PlansData;
import select_course_recycler_view_handler.data.CourseDetailSerializable;

public class RowPlanAdapter extends RecyclerView.Adapter<RowPlanViewHolder> {

    private ArrayList<PlansData> coursesInPlans;
    private Context context;
    private String stno;
    public RowPlanAdapter(ArrayList<PlansData> coursesInPlans,
                          Context context, String stno) {
        this.coursesInPlans = coursesInPlans;
        this.context = context;
        this.stno = stno;
    }

    @Override
    public RowPlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //parent.removeAllViews();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_plans_row_in_recycler_view,
                parent,false);

        return new RowPlanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RowPlanViewHolder holder, int position) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        holder.getMyPlanRowTextView().setTypeface(typeface);
        holder.getMyPlanRowTextView().setText("برنامه شماره " + (position+1));
        holder.getMyPlanRowLayout().setOnClickListener(v -> {
            Intent intent = new Intent(context, PlanDetailActivity.class);
            intent.putExtra("stno", stno);
            intent.putExtra("courses", coursesInPlans.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return coursesInPlans.size();
    }
}
