package de.setsoftware.reviewtool.ui.views;

import java.lang.ref.WeakReference;

import de.setsoftware.reviewtool.base.WeakListeners;
import de.setsoftware.reviewtool.model.changestructure.SliceFragment;

/**
 * Manages the currently selected fragment and its listeners.
 */
public class CurrentFragment {

    private static WeakListeners<FragmentSelectionListener> listeners = new WeakListeners<>();
    private static WeakReference<SliceFragment> currentFragment;

    static void setCurrentFragment(SliceFragment fragment) {
        currentFragment = new WeakReference<SliceFragment>(fragment);
        for (final FragmentSelectionListener l : listeners.getListeners()) {
            l.notifyFragmentChange(fragment);
        }
    }

    static void unsetCurrentFragment() {
        currentFragment = null;
        for (final FragmentSelectionListener l : listeners.getListeners()) {
            l.notifyFragmentChange(null);
        }
    }

    private static SliceFragment getCurrentFragment() {
        if (currentFragment == null) {
            return null;
        }
        return currentFragment.get();
    }

    static void registerListener(FragmentSelectionListener listener) {
        listeners.add(listener);
        listener.notifyFragmentChange(getCurrentFragment());
    }

}