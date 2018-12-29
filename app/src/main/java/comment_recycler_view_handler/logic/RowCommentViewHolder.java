package comment_recycler_view_handler.logic;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.ambaqi.musicevent.ava.R;

public class RowCommentViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout layout;
    private TextView studentFullNameTextView;
    private TextView studentNumberTextView;
    private TextView contentTextView;
    private TextView timeTextView;
    public RowCommentViewHolder(View itemView, Context context) {
        super(itemView);
        layout = (LinearLayout)itemView.findViewById(R.id.commentDetailLayout);
        studentFullNameTextView = (TextView)itemView.findViewById(R.id.studentFullNameInCommentDetail);
        studentNumberTextView = (TextView)itemView.findViewById(R.id.studentNumberInCommentDetail);
        contentTextView = (TextView)itemView.findViewById(R.id.contentInCommentDetail);
        timeTextView = (TextView)itemView.findViewById(R.id.timeInCommentDetail);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Far_Naskh.ttf");
        studentFullNameTextView.setTypeface(typeface);
        studentNumberTextView.setTypeface(typeface);
        contentTextView.setTypeface(typeface);
        timeTextView.setTypeface(typeface);
    }

    public TextView getStudentFullNameTextView() {
        return studentFullNameTextView;
    }

    public void setStudentFullNameTextView(TextView studentFullNameTextView) {
        this.studentFullNameTextView = studentFullNameTextView;
    }

    public TextView getStudentNumberTextView() {
        return studentNumberTextView;
    }

    public LinearLayout getLayout() {
        return layout;
    }

    public void setLayout(LinearLayout layout) {
        this.layout = layout;
    }

    public void setStudentNumberTextView(TextView studentNumberTextView) {
        this.studentNumberTextView = studentNumberTextView;
    }

    public TextView getContentTextView() {
        return contentTextView;
    }

    public void setContentTextView(TextView contentTextView) {
        this.contentTextView = contentTextView;
    }

    public TextView getTimeTextView() {
        return timeTextView;
    }

    public void setTimeTextView(TextView timeTextView) {
        this.timeTextView = timeTextView;
    }
}
