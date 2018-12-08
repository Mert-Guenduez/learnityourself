package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class MissionMemberAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private String[] members;

    public MissionMemberAdapter(Context context, String[] members) {
        mInflater = LayoutInflater.from(context);
        this.members = members;
    }

    public int getCount() {
        return members.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        MissionMemberAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_row, null);
            holder = new MissionMemberAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (MissionMemberAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(members[position].toString());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }

}
