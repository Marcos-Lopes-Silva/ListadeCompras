package com.example.listadecompras;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listadecompras.domain.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private static ArrayList<Item> itemList;
        private static CustomAdapter adapter;

    public void onCreate(Bundle instance) {
        super.onCreate(instance);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<Item>();
        adapter = new CustomAdapter(this, R.layout.list_item, itemList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button button = findViewById(R.id.btnAddItem);
        button.setOnClickListener(v -> showDialog());

    }

    private void showDialog() {

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_view, null);
        EditText editText = dialogView.findViewById(R.id.itemName);
        AlertDialog.Builder alertName = new AlertDialog.Builder(MainActivity.this);

        alertName
                .setTitle("Novo item.")
                .setMessage("Insira o nome do novo item.")
                .setView(dialogView)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setItem(editText.getText().toString().trim());
                    }
                })
                .setNegativeButton("Cancelar", null)
                .create().show();
    }

    private void setItem(String nameItem) {

        if(!nameItem.isEmpty()) {
            itemList.add(new Item(nameItem));
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(MainActivity.this, "Insira uma palavra", Toast.LENGTH_SHORT).show();
        }
    }

    public static ArrayList<Item> getItemList() {
        return itemList;
    }

    public static void setItemList(ArrayList<Item> newItemList) {
        itemList = newItemList;
        adapter.notifyDataSetChanged();
    }


}
