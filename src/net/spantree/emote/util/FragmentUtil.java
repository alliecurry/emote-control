package net.spantree.emote.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by alliecurry on 1/20/14.
 */
public final class FragmentUtil {


    public static void addFragment(Activity fragmentActivity, Fragment fragment, int containerId) {
        FragmentManager fragmentManager = fragmentActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void addFragment(Activity fragmentActivity, Fragment fragment, int containerId, String tag) {
        FragmentManager fragmentManager = fragmentActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerId, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void replaceFragment(Activity fragmentActivity, Fragment fragment, int containerId) {
        FragmentManager fragmentManager = fragmentActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void removeFragment(Activity fragmentActivity, Fragment fragment) {
        FragmentManager fragmentManager = fragmentActivity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static void popFragmentStack(Activity fragmentActivity) {
        fragmentActivity.getFragmentManager().popBackStack();
    }

}
