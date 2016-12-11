package com.example.jason.schedule_app;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sabrina on 12/6/16.
 */

class CustomExpandableListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<String> expandableListTitle;//
    private HashMap<String, List<String>> expandableListDetail;//

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<String>>expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;//titles
        this.expandableListDetail = expandableListDetail;//details
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition){
        return expandableListDetail.get(expandableListTitle
                .get(listPosition)).get(expandedListPosition); //goes straight to hashMap
        //kind of like [#][#]... also suggested
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition){
        return expandedListPosition;
    }//this doesn't make sense

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent){
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }//I think this means if we don't have a view already set up
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition){
        return expandableListDetail.get(expandableListTitle.get(listPosition)).size();//suggested
    }

    @Override
    public Object getGroup(int listPosition){
        return expandableListTitle.get(listPosition);//gets Object at this position
    }

    @Override
    public int getGroupCount(){
        return expandableListTitle.size(); //how big is the size
    }

    @Override
    public long getGroupId(int listPosition){ //suggested to be overloaded like this
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent){
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_assign, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds(){//suggested
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandableListPosition){//suggested
        return true;
    }
}
