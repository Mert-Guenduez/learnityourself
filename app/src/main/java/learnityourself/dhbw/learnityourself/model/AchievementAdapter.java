package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class AchievementAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private Achievement[] achievements;

    public AchievementAdapter(Context context, Achievement[] achievements) {
        mInflater = LayoutInflater.from(context);
        this.achievements = achievements;
    }

    public int getCount() {
        return achievements.length;
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
            convertView = mInflater.inflate(R.layout.list_row, null);
            holder = new ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text1.setText(achievements[position].getDescription());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }
}