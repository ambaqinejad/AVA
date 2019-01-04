package comment_recycler_view_handler.logic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import comment_recycler_view_handler.data.RowCommentDetail;
import ir.ambaqi.musicevent.ava.R;

public class RowCommentAdapter extends RecyclerView.Adapter<RowCommentViewHolder> {

    private ArrayList<RowCommentDetail> rowCommentDetailArrayList;
    private Context context;
    private String stno;

    public RowCommentAdapter(ArrayList<RowCommentDetail> rowCommentDetailArrayList, Context context,
                             String stno) {
        this.rowCommentDetailArrayList = rowCommentDetailArrayList;
        this.context = context;
        this.stno = stno;
    }

    @Override
    public RowCommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rows_in_comment_detail,
                parent, false);
        //parent.removeView(view);
        return new RowCommentViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(RowCommentViewHolder holder, int position) {
        RowCommentDetail rowCommentDetail = rowCommentDetailArrayList.get(position);
        String content = "";
        String firstName = "";
        String lastName = "";
        try {
            content = URLDecoder.decode(rowCommentDetail.getContent(), "utf-8");
            firstName = URLDecoder.decode(rowCommentDetail.getFirstName(), "utf-8");
            lastName = URLDecoder.decode(rowCommentDetail.getLastName(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        holder.getContentTextView().setText("متن نظر دانشجو: "+"\n"+content);
        holder.getStudentFullNameTextView().setText("نام دانشجو: ");
        if (!firstName.equalsIgnoreCase("null")) {
            holder.getStudentFullNameTextView().setText(holder.getStudentFullNameTextView().getText() + " " + firstName);
        }
        if (!lastName.equalsIgnoreCase("null")) {
            holder.getStudentFullNameTextView().setText(holder.getStudentFullNameTextView().getText() + " " + lastName);
        }
        holder.getStudentNumberTextView().setText("شماره دانشجویی: "+ rowCommentDetail.getStudentNumber());
        holder.getTimeTextView().setText(rowCommentDetail.getTime());
        if(stno.equalsIgnoreCase(rowCommentDetail.getStudentNumber())) {
            holder.getStudentFullNameTextView().setTextColor(Color.parseColor("#f72020"));
            holder.getStudentNumberTextView().setTextColor(Color.parseColor("#163ef1"));
            holder.getContentTextView().setTextColor(Color.parseColor("#008702"));
            holder.getTimeTextView().setTextColor(Color.parseColor("#008702"));
            holder.getLayout().setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.my_comment_detail_border));
        }
    }

    @Override
    public int getItemCount() {
        return rowCommentDetailArrayList.size();
    }
}
