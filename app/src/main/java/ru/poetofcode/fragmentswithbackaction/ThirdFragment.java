package ru.poetofcode.fragmentswithbackaction;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment implements OnBackButtonListener {

    boolean running = false;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        final ProgressBar progressBar = getActivity().findViewById(R.id.progressBar);
        Button btnLongAction = getActivity().findViewById(R.id.btn_long_action);

        btnLongAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                running = true;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        running = false;
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                }, 3000);
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onBackPressed() {
        if (running) {
            Toast.makeText(getActivity(), "The operation is still in progress", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}
