package ru.poetofcode.fragmentswithbackaction;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button btnOpenSecond = getActivity().findViewById(R.id.btn_open_second);
        btnOpenSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open second fragment
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

}
