package ru.poetofcode.fragmentswithbackaction;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements OnBackButtonListener {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button btnOpenThird = getActivity().findViewById(R.id.btn_open_third);
        btnOpenThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open second fragment
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ThirdFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onBackPressed() {
        Toast.makeText(getActivity(), "Returned to the home screen", Toast.LENGTH_LONG).show();

        return false;
    }
}
