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

public class KondenzatorA extends Fragment {
    EditText input;
    TextView result;
    public KondenzatorA() {
        // Required empty public constructor
    }

    public static KondenzatorA newInstance() {
        KondenzatorA fragment = new KondenzatorA();
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
        return inflater.inflate(R.layout.fragment_kondenzator_a, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        input=(EditText) view.findViewById(R.id.et_kondA);
        result=(TextView)view.findViewById(R.id.tv_kondA_result);

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
        if(code.length()!=3){
            result.setText("");
            return;
        }
        double number;
        try{
            if(code.charAt(0)>='0' && code.charAt(0)<='9' && code.charAt(1)>='0' && code.charAt(1)<='9' && code.charAt(2)>='0' && code.charAt(2)<='9'){
                number=(code.charAt(0)-'0')*10+(code.charAt(1)-'0');
                Log.i("mytag", ""+number);
                number*=Math.pow(10, code.charAt(2)-'0');

                char[] signs = {'p', 'n', 'u', 'm'};
                int size=0;
                while(number>1000){
                    number/=1000;
                    size++;
                }
                if(number==(int)number){
                    result.setText(""+String.valueOf((int)number)+" " + signs[size]+"F");
                }
                else {
                    result.setText(""+String.valueOf(number)+" " + signs[size]+"F");
                }
                Log.i("mytag", ""+number);
            }
            else{
                throw (new Exception());
            }
        }
        catch (Exception e){
            result.setText("");
        }
    }
}