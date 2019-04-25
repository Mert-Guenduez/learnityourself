package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class RewardAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Reward[] rewards;

    public RewardAdapter (Context context, Reward[] rewards) {
        inflater = LayoutInflater.from(context);
        this.rewards = rewards;
    }

    @Override
    public int getCount() {
        return rewards.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RewardAdapter.ViewHolder holder;
        RewardAdapter.ViewHolder pointHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            holder = new RewardAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);

            pointHolder = new RewardAdapter.ViewHolder();
            pointHolder.text2 = convertView.findViewById(R.id.TextView02);
            convertView.setTag(pointHolder);
        } else {
            holder = (RewardAdapter.ViewHolder) convertView.getTag();
            pointHolder = (RewardAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(rewards[position].getTitle());
        pointHolder.text2.setText(Integer.toString(rewards[position].getCost()));

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
        TextView text2;
    }
}
