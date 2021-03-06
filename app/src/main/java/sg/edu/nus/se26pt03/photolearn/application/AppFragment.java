package sg.edu.nus.se26pt03.photolearn.application;

import android.app.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by MyatMin on 10/3/18.
 */

public class AppFragment extends Fragment {
    public AppEventListener mAppEventListener;
    public LearningEventListener mLearningEventListener;

    public interface AppEventListener {
        void onModeChanged(UserMode userMode, AccessMode accessMode);
        void onLoggedIn();
    }

    public interface LearningEventListener {
        void onLearningSessionReaction(Action action);
        void onLearningTitleReaction(Action action);
        void onLearningItemReaction(Action action);
        void onQuizTitleReaction(Action action);
        void onQuizItemReaction(Action action);
        void onQuizAnswerReaction(Action action);
    }

    protected void setFragment(int id,Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        Fragment fragment;
        if (context instanceof Activity)
        {
            activity = (Activity) context;
            if (activity instanceof AppEventListener) mAppEventListener = (AppEventListener) activity;
            if (activity instanceof LearningEventListener) mLearningEventListener = (LearningEventListener) activity;
        }
        if (getParentFragment() != null) {
            fragment = getParentFragment();
            if (fragment instanceof AppEventListener) mAppEventListener = (AppEventListener) getParentFragment();
            if (fragment instanceof LearningEventListener) mLearningEventListener = (LearningEventListener) getParentFragment();
        }
    }
}
