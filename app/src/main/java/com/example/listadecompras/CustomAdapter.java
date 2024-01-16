package com.example.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listadecompras.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    public CustomAdapter(Context context, int resource, List<Item> itens) {
        super(context, resource, itens);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.list_item, null);
        }

        TextView textView = view.findViewById(R.id.textStatus);
        Button btnToggle = view.findViewById(R.id.btnToggleStatus);
        ImageView btnRemove = view.findViewById(R.id.btnRemove);

        Item item = getItem(position);

        if(item != null) {
            textView.setText(item.getNameItem());
            btnToggle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    item.setBought(!item.getBought());

                    if (item.getBought()) {
                        btnToggle.setText(R.string.bought);
                        btnToggle.setBackgroundColor(getContext().getResources().getColor(R.color.red));
                    } else {
                        btnToggle.setText(R.string.not_bought);
                        btnToggle.setBackgroundColor(getContext().getResources().getColor(R.color.green));
                    }
                }
            });
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<Item> itemList = MainActivity.getItemList();
                    itemList.remove(item);
                    MainActivity.setItemList(itemList);
                }
            });
        }

        return view;
    }
}
