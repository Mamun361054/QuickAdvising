package com.nsu.advising.QuickAdvising;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.nsu.advising.advising.R;

import java.util.ArrayList;
import java.util.List;

public class ListDataAdapterEighth extends ArrayAdapter {

    List list = new ArrayList();
    Activity activity;
    int layoutResourceId;


    public ListDataAdapterEighth(Activity act, int resource) {
        super(act, resource);
        this.activity=act;
        this.layoutResourceId=resource;
    }

    class LayoutHandeler{
        TextView SubName,gpa,credit,letter;
        ImageButton imbut;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view= convertView;
        LayoutHandeler layoutHandeler;

        if (view == null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.contactlistview,parent,false);
            layoutHandeler = new LayoutHandeler();

            layoutHandeler.SubName = (TextView) view.findViewById(R.id.tvCLASS);
            layoutHandeler.gpa= (TextView) view.findViewById(R.id.tvGPA);
            layoutHandeler.credit= (TextView) view.findViewById(R.id.tvCREDIT);
            layoutHandeler.letter=(TextView) view.findViewById(R.id.tvLG);
            layoutHandeler.imbut=(ImageButton)view.findViewById(R.id.imagebut);

            view.setTag(layoutHandeler);

        }
        else {
            layoutHandeler = (LayoutHandeler) view.getTag();
        }

        ContactInfo contactInfo = (ContactInfo) this.getItem(position);
        layoutHandeler.imbut.setTag(contactInfo.getClassN());

        layoutHandeler.SubName.setText(contactInfo.getClassN());
        layoutHandeler.gpa.setText(contactInfo.getTime());
        layoutHandeler.letter.setText(contactInfo.getLetterGrade());
        layoutHandeler.credit.setText(contactInfo.getRoomNo());

        layoutHandeler.imbut.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(final View v) {

                Context wrapper = new ContextThemeWrapper(getContext(), R.style.AppTheme);
                PopupMenu popup = new PopupMenu(wrapper, v);

                /** Adding menu items to the popumenu */
                popup.getMenuInflater().inflate(R.menu.updel, popup.getMenu());

                /** Defining menu item click listener for the popup menu */
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.edit:
                                Intent update_user = new Intent(activity, AddResultEighth.class);
                                update_user.putExtra("called", "update");
                                update_user.putExtra("class_name", v.getTag().toString());
                                activity.startActivity(update_user);
                                activity.finish();
                                break;

                            case R.id.del:
                                AlertDialog.Builder adb = new AlertDialog.Builder(activity);
                                adb.setTitle("Delete?");
                                adb.setMessage("Are you sure you want to delete ");
                                final String SubName = v.getTag().toString();
                                adb.setNegativeButton("Cancel", null);
                                adb.setPositiveButton("Ok",
                                        new AlertDialog.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog,
                                                                int which) {
                                                // MyDataObject.remove(positionToRemove);
                                                DatabasedHelper dBHandler = new DatabasedHelper(
                                                        activity.getApplicationContext());
                                                dBHandler.deleteFromEightSemester(SubName);
                                                Intent intent = new Intent(activity, EighthSemester.class);
                                                activity.startActivity(intent);
                                                activity.finish();

                                            }
                                        });
                                adb.show();
                                break;
                        }
                        return true;
                    }
                });

                /** Showing the popup menu */
                popup.show();
            }
        });

        return view;
    }
}
