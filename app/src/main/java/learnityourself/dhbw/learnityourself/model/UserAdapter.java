package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class UserAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private User[] users;

    public UserAdapter(Context context, User[] users) {
        mInflater = LayoutInflater.from(context);
        this.users = users;
    }

    public int getCount() {
        return users.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        UserAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_row, null);
            holder = new UserAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (UserAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(users[position].getUsername());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }
}
