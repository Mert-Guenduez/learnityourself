package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class AddUserAdapter extends BaseAdapter {

    public static final int IS_MEMBER = 0;
    public static final int IS_NO_MEMBER = 1;

    private LayoutInflater mInflater;
    private User[] users;

    public AddUserAdapter(Context context, User[] users) {
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
        AddUserAdapter.ViewHolder holder;
        if (convertView == null) {
            if (getItemViewType(position) == IS_NO_MEMBER){
                convertView = mInflater.inflate(R.layout.list_row, null);
            } else {
                convertView = mInflater.inflate(R.layout.list_row_selected, null);
            }
            holder = new AddUserAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (AddUserAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(users[position].getUsername());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }

    @Override
    public int getViewTypeCount(){
        return 2;
    }

    @Override
    public int getItemViewType(int position){
        User user = users[position];
        if (user.isMember()){
            return IS_MEMBER;
        }
        return IS_NO_MEMBER;
    }
}