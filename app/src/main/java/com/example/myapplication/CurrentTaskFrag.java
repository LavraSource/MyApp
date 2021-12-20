package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentTaskFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentTaskFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrentTaskFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentTaskFrag.
     */
    SharedPreferences myPreferences;
    SharedPreferences.Editor myEditor;
    public static CurrentTaskFrag newInstance(String param1, String param2) {
        CurrentTaskFrag fragment = new CurrentTaskFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        myPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        myEditor = myPreferences.edit();
        if(myPreferences.getString("TASKS", "").equals("")){
            myEditor.putString("TASKS", "");
            myEditor.commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_current_task, container, false);
        EditText newTask= v.findViewById(R.id.new_task);
        Button addTask = v.findViewById(R.id.AddTask);
        Button clearTask = v.findViewById(R.id.ClearTask);
        TextView curTasks= v.findViewById(R.id.curTasks);
        curTasks.setText(myPreferences.getString("TASKS", ""));
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curTasks.append(newTask.getText().toString()+"\n");
                myEditor.putString("TASKS", curTasks.getText().toString());
                myEditor.commit();
            }
        });
        clearTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                curTasks.setText("");
                myEditor.putString("TASKS", curTasks.getText().toString());
                myEditor.commit();
            }
        });
        return v;
    }
}