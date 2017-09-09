package com.nsu.advising.QuickAdvising.chat;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nsu.advising.advising.R;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatFragment extends Fragment {

    private EditText et_message;
    private Button btn_sent;
    private TextView conversation;
    private ScrollView scrollView;
    private String user_name;
    private DatabaseReference root;
    private String tmp_msg,tmp_userName = " ";
    private int i = 1;
    private String tmpString = "",tmpString1,sharedStr;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        et_message = (EditText)view.findViewById(R.id.et_chat);
        btn_sent = (Button)view.findViewById(R.id.btn_sent);
        conversation = (TextView)view.findViewById(R.id.conversation);
        scrollView = (ScrollView) view.findViewById(R.id.chat_ScrollView);
        root = FirebaseDatabase.getInstance().getReference().getRoot();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = sharedPreferences.edit();

        sharedStr = sharedPreferences.getString("user_name", "null");

        if(sharedStr.equalsIgnoreCase("null")) {
            request_user_name();
        }

        btn_sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( et_message.getText().toString().length() > 0 && !sharedStr.equalsIgnoreCase("null")) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("message", et_message.getText().toString());
                    map.put("user_name", sharedStr);
                    root.updateChildren(map);

                    i++;
                    et_message.setText("");
                    setKeyboardVisibility(false);
                    if(i > 400){

                        conversation.setText(tmpString);
                        i = 1;
                    }

                }else{
                    Toast.makeText(getContext(),"write something",Toast.LENGTH_SHORT).show();
                }

            }
        });

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                append_chat_conversation(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }




    private void request_user_name(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(false);
        builder.setTitle("Enter your name");

        final EditText input_name = new EditText(getContext());
        input_name.setMaxLines(1);
        builder.setView(input_name);

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(input_name.getText().toString().length() <= 10 && input_name.getText().toString().length() >= 3) {
                    user_name = input_name.getText().toString();
                    editor.putString("user_name", user_name); // Storing string
                    editor.commit();
                    sharedStr = sharedPreferences.getString("user_name", "null");
                   // Toast.makeText(getContext(),sharedPreferences.getString("user_name", null),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"your name should be small( < 10 and > 2)",Toast.LENGTH_SHORT).show();
                    request_user_name();
                }
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                request_user_name();
            }
        });
        builder.show();
    }

    private void append_chat_conversation(DataSnapshot dataSnapshot) {
        Iterator iterator = dataSnapshot.getChildren().iterator();

        while (iterator.hasNext()){

            i++;
            tmp_msg = (String) ((DataSnapshot)iterator.next()).getValue();
            tmp_userName = (String) ((DataSnapshot)iterator.next()).getValue();
            conversation.append(tmp_userName +" : "+tmp_msg+"\n\n");

            scrollView.post(new Runnable()
            {
                public void run()
                {
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            });

        }

    }

    public void setKeyboardVisibility(boolean show) {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
        if(show){
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }else{
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),0);
        }
    }


}
