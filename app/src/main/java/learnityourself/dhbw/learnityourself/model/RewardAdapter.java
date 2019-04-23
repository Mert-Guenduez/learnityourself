package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        return 0;
//        return rewards.length;
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row, null);
            holder = new RewardAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (RewardAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(rewards[position].getRewardName());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }
}
