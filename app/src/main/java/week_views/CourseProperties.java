package week_views;

import android.widget.TextView;

public class CourseProperties {
    private TextView courseTextView;
    private int itemIndex;

    public int getArrayListIndex() {
        return arrayListIndex;
    }

    private int arrayListIndex;

    public TextView getCourseTextView() {
        return courseTextView;
    }

    public void setCourseTextView(TextView courseTextView) {
        this.courseTextView = courseTextView;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public void setArrayListIndex(int arrayListIndex) {
        this.arrayListIndex = arrayListIndex;
    }
}
