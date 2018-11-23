package learnityourself.dhbw.learnityourself.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;

public class TaskAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Task[] tasks;

    public TaskAdapter(Context context, Task[] tasks) {
        mInflater = LayoutInflater.from(context);
        this.tasks = tasks;
    }

    public int getCount() {
        return tasks.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TaskAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_row, null);
            holder = new TaskAdapter.ViewHolder();
            holder.text1 = (TextView) convertView
                    .findViewById(R.id.TextView01);
            convertView.setTag(holder);
        } else {
            holder = (TaskAdapter.ViewHolder) convertView.getTag();
        }

        holder.text1.setText(tasks[position].getTaskname());

        return convertView;
    }

    static class ViewHolder {
        TextView text1;
    }

}
