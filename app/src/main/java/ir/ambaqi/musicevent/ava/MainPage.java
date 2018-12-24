package ir.ambaqi.musicevent.ava;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import Interfaces.ComponentMethod;

public class MainPage extends AppCompatActivity implements ComponentMethod {

    Toolbar mainPageToolbar;
    RelativeLayout selectCourseMenu, myPlansMenu, commentMenu;
    RelativeLayout updateInformationMenu, checkSituationMenu, exitMenu;
    TextView toolbarText, selectCourseText, myPlansText, commentText;
    TextView updateInformationText, checkSituationText, exitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        init();
    }

    @Override
    public void init() {
        mainPageToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        selectCourseMenu = (RelativeLayout) findViewById(R.id.select_course_menu);
        myPlansMenu = (RelativeLayout) findViewById(R.id.my_plans_menu);
        commentMenu = (RelativeLayout) findViewById(R.id.comment_menu);
        updateInformationMenu = (RelativeLayout) findViewById(R.id.update_information_menu);
        checkSituationMenu = (RelativeLayout) findViewById(R.id.check_situation_menu);
        exitMenu = (RelativeLayout) findViewById(R.id.exit_menu);
        toolbarText = (TextView) findViewById(R.id.toolbar_text);
        toolbarText = (TextView) findViewById(R.id.toolbar_text);
        selectCourseText = (TextView) findViewById(R.id.select_course_text);
        myPlansText = (TextView) findViewById(R.id.my_plans_text);
        commentText = (TextView) findViewById(R.id.comment_text);
        updateInformationText = (TextView) findViewById(R.id.update_information_text);
        checkSituationText = (TextView) findViewById(R.id.check_situation_text);
        exitText = (TextView) findViewById(R.id.exit_text);
        setTypeFaceToComponent();
    }

    @Override
    public void changeVisibility(boolean isVisible) {

    }

    @Override
    public void setTypeFaceToComponent() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "Fonts/Far_Naskh.ttf");
        toolbarText.setTypeface(typeface);
        toolbarText.setTypeface(typeface);
        selectCourseText.setTypeface(typeface);
        myPlansText.setTypeface(typeface);
        commentText.setTypeface(typeface);
        updateInformationText.setTypeface(typeface);
        checkSituationText.setTypeface(typeface);
        exitText.setTypeface(typeface);
    }

    public void menuClick(View view) {
        switch (view.getId()) {
            case R.id.select_course_menu:
                startActivity(new Intent(MainPage.this, SelectCourseActivity.class));
                break;
            case R.id.exit_menu:
                finish();
        }
    }
}
