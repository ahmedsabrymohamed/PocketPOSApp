package com.example.pocketposapp.ui.bills;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pocketposapp.R;

public class BillsFragment extends Fragment {

    private BillsViewModel billsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        billsViewModel =
                ViewModelProviders.of(this).get(BillsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bills, container, false);
        final TextView textView = root.findViewById(R.id.text_bills);
        billsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("Ahmed Sabry");
            }
        });
        return root;
    }
}
