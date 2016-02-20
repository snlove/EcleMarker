package sn.eclemarker.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sn.eclemarker.R;

/**主页
 * Created by acer on 2016/2/19.
 */
public class MainFragment extends Fragment {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.main_showlayout,container,false);
        return  root;
    }
}
