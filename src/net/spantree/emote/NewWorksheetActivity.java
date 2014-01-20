package net.spantree.emote;

import android.app.Activity;
import android.os.Bundle;
import net.spantree.emote.util.FragmentUtil;

/**
 * Created by malynda on 1/20/14.
 */
public class NewWorksheetActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newemote);
        FragmentUtil.replaceFragment(this, new QuestionListFragment(), R.id.fragment);
    }
}