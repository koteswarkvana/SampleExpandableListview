package com.koti.apple.sampleexpandablelistview;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

//    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
    public ExpandableListAdapter(Context context, List<String> listDataHeader) {
        this._context = context;
        this._listDataHeader = listDataHeader;
//        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ////
        String categoryName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }
        final EditText etReplyText = (EditText) convertView.findViewById(R.id.et_reply_text);
        TextView item = (TextView) convertView.findViewById(R.id.lblListHeader);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(categoryName);

        ImageView imageReply = (ImageView) convertView.findViewById(R.id.replyIv);
        imageReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etReplyText.setVisibility(View.VISIBLE);
            }
        });
        ///

        /*String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        ImageView imageReply = (ImageView) convertView.findViewById(R.id.replyIv);
        imageReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etReplyText.setVisibility(View.VISIBLE);
            }
        });
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);*/

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

////
/**
 * package com.koti.apple.sampleexpandablelistview;

 import java.util.HashMap;
 import java.util.List;

 import android.content.Context;
 import android.graphics.Typeface;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.BaseExpandableListAdapter;
 import android.widget.TextView;

 public class ExpandableListAdapter extends BaseExpandableListAdapter {

 private Context _context;
 private List<String> _listDataHeader; // header titles
 // child data in format of header title, child title
 private HashMap<String, List<String>> _listDataChild;

 public ExpandableListAdapter(Context context, List<String> listDataHeader,
 HashMap<String, List<String>> listChildData) {
 this._context = context;
 this._listDataHeader = listDataHeader;
 this._listDataChild = listChildData;
 }

 @Override
 public Object getChild(int groupPosition, int childPosititon) {
 return this._listDataChild.get(this._listDataHeader.get(groupPosition))
 .get(childPosititon);
 }

 @Override
 public long getChildId(int groupPosition, int childPosition) {
 return childPosition;
 }

 @Override
 public View getChildView(int groupPosition, final int childPosition,
 boolean isLastChild, View convertView, ViewGroup parent) {

 final String childText = (String) getChild(groupPosition, childPosition);

 if (convertView == null) {
 LayoutInflater infalInflater = (LayoutInflater) this._context
 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 convertView = infalInflater.inflate(R.layout.list_item, null);
 }

 TextView txtListChild = (TextView) convertView
 .findViewById(R.id.lblListItem);

 txtListChild.setText(childText);
 return convertView;
 }

 @Override
 public int getChildrenCount(int groupPosition) {
 return this._listDataChild.get(this._listDataHeader.get(groupPosition))
 .size();
 }

 @Override
 public Object getGroup(int groupPosition) {
 return this._listDataHeader.get(groupPosition);
 }

 @Override
 public int getGroupCount() {
 return this._listDataHeader.size();
 }

 @Override
 public long getGroupId(int groupPosition) {
 return groupPosition;
 }

 @Override
 public View getGroupView(int groupPosition, boolean isExpanded,
 View convertView, ViewGroup parent) {
 String headerTitle = (String) getGroup(groupPosition);
 if (convertView == null) {
 LayoutInflater infalInflater = (LayoutInflater) this._context
 .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 convertView = infalInflater.inflate(R.layout.list_group, null);
 }

 TextView lblListHeader = (TextView) convertView
 .findViewById(R.id.lblListHeader);
 lblListHeader.setTypeface(null, Typeface.BOLD);
 lblListHeader.setText(headerTitle);

 return convertView;
 }

 @Override
 public boolean hasStableIds() {
 return false;
 }

 @Override
 public boolean isChildSelectable(int groupPosition, int childPosition) {
 return true;
 }
 }
 */
////