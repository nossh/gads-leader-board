package com.example.gadsleaderboard.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.Learner;
import com.example.gadsleaderboard.Test;

public class PageViewModel extends ViewModel {

    Test test = new Test();
    Learner learner = new Learner();

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<Learner> mText = Transformations.map(mIndex, new Function<Integer, Learner>() {
        @Override
        public Learner apply(Integer input) {
            if (input == 1){
                //return "Hi world from section: ";

                return learner;
            }else {
                //return "Hello world from section: ";
                return learner;
            }

        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<Learner> getText() {
        return mText;
    }
}