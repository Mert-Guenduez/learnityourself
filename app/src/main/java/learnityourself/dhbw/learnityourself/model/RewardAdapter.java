package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class RewardAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Reward[] rewards;
    private User user;

    public RewardAdapter(Context context, User user, Reward[] rewards) {
        inflater = LayoutInflater.from(context);
        this.rewards = rewards;
        this.user = user;
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
        RewardAdapter.ViewHolder seekBarHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_rewards, null);
            holder = new RewardAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.listRowRewards_TextView01);
            convertView.setTag(holder);

            pointHolder = new RewardAdapter.ViewHolder();
            pointHolder.text2 = convertView.findViewById(R.id.listRowRewards_TextView02);
            convertView.setTag(pointHolder);

            seekBarHolder = new RewardAdapter.ViewHolder();
            seekBarHolder.seekBar = convertView.findViewById(R.id.seekbar_balance_points);
            convertView.setTag(seekBarHolder);
        } else {
            holder = (RewardAdapter.ViewHolder) convertView.getTag();
            pointHolder = (RewardAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(rewards[position].getTitle());
        pointHolder.text2.setText(Integer.toString(rewards[position].getCost()));

        int userPoints = user.getPoints();
        int rewardPoints = rewards[position].getCost();

        seekBarHolder.seekBar.setMax(rewardPoints);
        seekBarHolder.seekBar.setEnabled(false);
        seekBarHolder.seekBar.setThumbOffset(10000);    // moves the thumb out of view (to left)

        if(userPoints >= rewardPoints) {
            seekBarHolder.seekBar.setProgress(rewardPoints);
        } else {
            seekBarHolder.seekBar.setProgress(userPoints);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
        TextView text2;
        SeekBar seekBar;
    }
}
