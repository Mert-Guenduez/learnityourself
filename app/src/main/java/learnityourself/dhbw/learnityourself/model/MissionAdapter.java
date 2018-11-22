package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import learnityourself.dhbw.learnityourself.R;

public class MissionAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Mission[] missions;

    public MissionAdapter(Context context, Mission[] missions) {
        mInflater = LayoutInflater.from(context);
        this.missions = missions;
    }

    public int getCount() {
        return missions.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.mission_row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(missions[position].getMissionname());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }
}