package net.spantree.emote;

import android.app.Activity;
import android.os.Bundle;
import net.spantree.emote.util.FragmentUtil;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by malynda on 1/20/14.
 */
public class NewWorksheetActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newemote);
        FragmentUtil.replaceFragment(this, new QuestionListFragment(), R.id.fragment);
        showDate();
    }

    private void showDate() {
        TextView dateView = (TextView) findViewById(R.id.worksheet_date);
        String dateFormat = getString(R.string.default_date_format);
        DateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateText = formatter.format(new Date()).toString();
        dateView.setText(dateText);
    }

}