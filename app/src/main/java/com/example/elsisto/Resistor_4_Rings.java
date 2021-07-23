package com.example.elsisto;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Resistor_4_Rings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resistor_4_Rings extends Fragment {
    List<Name_and_Color> ring123;
    List<Name_and_Color> ring4;
    List<Name_and_Color> ring5;

    int[] values;

    Spinner sp1,sp2,sp3,sp4;
    MyArrayAdapter sp1A, sp2A, sp3A, sp4A;
    TextView result;

    public Resistor_4_Rings() {
        // Required empty public constructor
    }


    public static Resistor_4_Rings newInstance() {
        Resistor_4_Rings fragment = new Resistor_4_Rings();
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.setArguments((getArguments().deepCopy()));
        }

        values = new int[4];
        ring123 = new ArrayList<>();
        ring123.add(new Name_and_Color("Izaberite opciju", R.color.White_ring));
        ring123.add(new Name_and_Color("Crna - 0", R.color.Black_ring));
        ring123.add(new Name_and_Color("Smeđa - 1", R.color.Brown_ring));
        ring123.add(new Name_and_Color("Crvena - 2 ", R.color.Red_ring));
        ring123.add(new Name_and_Color("Narandžasta - 3", R.color.Orange_ring));
        ring123.add(new Name_and_Color("Žuta - 4", R.color.Yellow_ring));
        ring123.add(new Name_and_Color("Zelena - 5", R.color.Green_ring));
        ring123.add(new Name_and_Color("Plava -6 ", R.color.Blue_ring));
        ring123.add(new Name_and_Color("Ljubičasta - 7", R.color.Violet_ring));
        ring123.add(new Name_and_Color("Siva - 8", R.color.Grey_ring));
        ring123.add(new Name_and_Color("Bijela - 9", R.color.White_ring));

        ring4 = new ArrayList<>();
        ring4.add(new Name_and_Color("Izaberite opciju", R.color.White_ring));
        ring4.add(new Name_and_Color("Crna x1", R.color.Black_ring));
        ring4.add(new Name_and_Color("Smeđa x10", R.color.Brown_ring));
        ring4.add(new Name_and_Color("Crvena x100", R.color.Red_ring));
        ring4.add(new Name_and_Color("Narandžasta x1k", R.color.Orange_ring));
        ring4.add(new Name_and_Color("Žuta x10k", R.color.Yellow_ring));
        ring4.add(new Name_and_Color("Zelena x100k", R.color.Green_ring));
        ring4.add(new Name_and_Color("Plava x1M", R.color.Blue_ring));
        ring4.add(new Name_and_Color("Ljubičasta x10M", R.color.Violet_ring));
        ring4.add(new Name_and_Color("Siva x100M", R.color.Grey_ring));
        ring4.add(new Name_and_Color("Bijela x1G", R.color.White_ring));
        ring4.add(new Name_and_Color("Zlatna x0.1", R.color.Gold_ring));
        ring4.add(new Name_and_Color("Srebrna x0.01", R.color.Silver_ring));

        ring5 = new ArrayList<>();
        ring5.add(new Name_and_Color("Izaberite opciju", R.color.White_ring));
        ring5.add(new Name_and_Color("Smeđa 1%", R.color.Brown_ring));
        ring5.add(new Name_and_Color("Crvena 2%", R.color.Red_ring));
        ring5.add(new Name_and_Color("Zelena 0.5%", R.color.Green_ring));
        ring5.add(new Name_and_Color("Plava 0.25%", R.color.Blue_ring));
        ring5.add(new Name_and_Color("Ljubičasta 0.1%", R.color.Violet_ring));
        ring5.add(new Name_and_Color("Siva 0.05%", R.color.Grey_ring));
        ring5.add(new Name_and_Color("Zlatna 5%", R.color.Gold_ring));
        ring5.add(new Name_and_Color("Srebrna 10%", R.color.Silver_ring));


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sp1 = (Spinner) view.findViewById(R.id.spinner_fourband_ring1);
        sp2 = (Spinner) view.findViewById(R.id.spinner_fourband_ring2);
        sp3 = (Spinner) view.findViewById(R.id.spinner_fourband_ring3);
        sp4 = (Spinner) view.findViewById(R.id.spinner_fourband_ring4);
        result = (TextView) view.findViewById(R.id.tw_value_result_4rings);

        sp1A = new MyArrayAdapter(getContext(), R.layout.custom_spinner_item, ring123);
        sp1.setAdapter(sp1A);
        sp2A = new MyArrayAdapter(getContext(), R.layout.custom_spinner_item, ring123);
        sp2.setAdapter(sp2A);
        sp3A = new MyArrayAdapter(getContext(), R.layout.custom_spinner_item, ring4);
        sp3.setAdapter(sp3A);
        sp4A = new MyArrayAdapter(getContext(), R.layout.custom_spinner_item, ring5);
        sp4.setAdapter(sp4A);


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate(1, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate(2, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate(3,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculate(4,position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resistor_4__rings, container, false);
    }

    void calculate(int SpinnerN, int position){
        values[SpinnerN-1]=position;
        for(int i=0;i<4;i++){
            if(values[i]==0) return;
        }
        double resistance=(values[0]-1)*10;
        resistance+=(values[1]-1);
        if(values[2]==11){
            resistance*=0.1;
        }
        else if(values[2]==12){
            resistance*=0.01;
        }
        else if(values[2]>0 && values[2]<11){
            resistance*=Math.pow(10, values[2]-1);
        }
        double tolerance=0;
        switch(values[3]) {
            case 1:
                tolerance = 1; break;
            case 2:
                tolerance = 2;  break;
            case 3:
                tolerance = 0.5;  break;
            case 4:
                tolerance = 0.25;  break;
            case 5:
                tolerance = 0.1;  break;
            case 6:
                tolerance = 0.05;  break;
            case 7:
                tolerance = 5;  break;
            case 8:
                tolerance = 10;  break;
        }

        char sign=' ';
        if(resistance>Math.pow(10,9)) {
            sign='G';
            resistance/=Math.pow(10,9);
        }
        else if(resistance>Math.pow(10,6)){
            sign='M';
            resistance/=Math.pow(10,6);
        }
        else if(resistance>Math.pow(10,3)){
            sign='k';
            resistance/=Math.pow(10,3);
        }
        if(resistance==(int)resistance){
            result.setText(""+(int)resistance+ sign+"Ω +/-" + tolerance + "%");
        }
        else{
            result.setText("" + resistance + " " +sign+"Ω +/-" + tolerance + "%");
        }
    }

}