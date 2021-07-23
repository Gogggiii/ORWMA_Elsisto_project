package com.example.elsisto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KondenzatorB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KondenzatorB extends Fragment {
    EditText input;
    TextView result;

    public KondenzatorB() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static KondenzatorB newInstance() {
        KondenzatorB fragment = new KondenzatorB();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kondenzator_b, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        input=(EditText) view.findViewById(R.id.et_kondB);
        result=(TextView)view.findViewById(R.id.tv_kondB_result);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculate();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        super.onViewCreated(view, savedInstanceState);
    }

    void calculate(){
        String code=input.getText().toString();
        char signs[]={'u', 'n', 'p'};
        int sign=0;
        try{
            float value=Float.valueOf(code);
            if(value<0.0001) throw(new Exception());
            Log.i("myfrezze", "hej");
            while(value<1){
                sign++;
                value*=1000;
            }
            result.setText(value+" "+signs[sign]+'F');
        }
        catch(Exception e){
            result.setText("");
        }

    }

}