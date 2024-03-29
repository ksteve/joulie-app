package com.example.kyle.joulieapp.Views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kyle.joulieapp.Models.Device;
import com.example.kyle.joulieapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeviceTypeFragment.OnTypeSelectedListener} interface
 * to handle interaction events.
 * Use the {@link DeviceTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceTypeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnTypeSelectedListener mListener;

    private CardView tplink;
    private CardView wemo;

    public DeviceTypeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DeviceTypeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeviceTypeFragment newInstance() {
        DeviceTypeFragment fragment = new DeviceTypeFragment();
        Bundle args = new Bundle();
       // args.putString(ARG_PARAM1, param1);
       // args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
           // mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_device_type, container, false);

        ((NewDeviceActivity)getActivity()).getSupportActionBar().setTitle("Choose a Device Type");
        tplink = (CardView) view.findViewById(R.id.tplink_card);
        wemo = (CardView) view.findViewById(R.id.wemo_card);


        wemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSetType(Device.TYPE_WEMO);
            }
        });

        tplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSetType(Device.TYPE_TPLINK);
            }
        });

        return view;
    }

    public void onSetType(String type) {
        if (mListener != null) {
            mListener.onTypeSelected(type);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTypeSelectedListener) {
            mListener = (OnTypeSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTypeSelectedListener {
        // TODO: Update argument type and name
        void onTypeSelected(String type);
    }
}
