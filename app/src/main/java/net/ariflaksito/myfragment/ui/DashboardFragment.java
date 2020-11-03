package net.ariflaksito.myfragment.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.ariflaksito.myfragment.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDash = view.findViewById(R.id.btn_dash);
        btnDash.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_dash){
            ReportFragment reportFragment = new ReportFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(ReportFragment.EXTRA_DATA, "Ini pesan dari Dashboard Fragment");
            reportFragment.setArguments(mBundle);

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null) {
                mFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, reportFragment, ReportFragment.class.getSimpleName())
                        .commit();
            }

        }
    }
}