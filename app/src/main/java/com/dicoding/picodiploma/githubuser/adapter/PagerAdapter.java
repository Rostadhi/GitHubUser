package com.dicoding.picodiploma.githubuser.adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dicoding.picodiploma.githubuser.R;
import com.dicoding.picodiploma.githubuser.fragment.followersfragment;
import com.dicoding.picodiploma.githubuser.fragment.followingfragment;


import java.util.Objects;

public class PagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }
    @StringRes
    private final int[] TAB_TITLES = new int[]{
            R.string.tab_text_2,
            R.string.tab_text_1
    };

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new followingfragment();
                break;
            case 1:
                fragment = new followersfragment();
                break;
        }
        return Objects.requireNonNull(fragment);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
