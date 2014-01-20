package net.spantree.emote;

import android.app.Activity;
import android.os.Bundle;
<<<<<<< HEAD
import net.spantree.emote.util.FragmentUtil;
=======
import android.view.View;
>>>>>>> Basic button setup for worksheet activity
import android.widget.TextView;
import net.spantree.emote.util.FragmentUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by malynda on 1/20/14.
 */
public class NewWorksheetActivity extends Activity implements View.OnClickListener {

    private View buttonPrevious;
    private View buttonDone;
    private View buttonNext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newemote);
        FragmentUtil.replaceFragment(this, new QuestionListFragment(), R.id.fragment);
        setupViews();
    }

    private void setupViews() {
        showDate();
        buttonPrevious = findViewById(R.id.worksheet_back_button);
        buttonDone = findViewById(R.id.worksheet_done_button);
        buttonNext = findViewById(R.id.worksheet_next_button);
        buttonPrevious.setOnClickListener(this);
        buttonDone.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
    }

    private void showDate() {
        TextView dateView = (TextView) findViewById(R.id.worksheet_date);
        String dateFormat = getString(R.string.default_date_format);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateText = formatter.format(new Date()).toString();
        dateView.setText(dateText);
    }

    /** Called when a navigation button is pressed. */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.worksheet_back_button:
                onBackPressed();
                break;
            case R.id.worksheet_next_button:
                // TODO add next fragment to stack
                break;
            case R.id.worksheet_done_button:
                // TODO save worksheet
                finish();
                break;
        }
    }

    /** Called when the hardware back button is pressed. */
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            FragmentUtil.popFragmentStack(this);
        } else {
            // TODO show dialog confirming deletion of entry
            // closing Activity for now...
            finish();
        }
    }
}