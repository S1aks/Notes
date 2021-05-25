package ru.s1aks.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.fragment.app.Fragment;

import java.util.GregorianCalendar;

public class DatePickerFragment extends Fragment {

    private static final String ARG_INDEX = "index";
    private int index;

    private DatePicker datePicker;
    private GregorianCalendar timeCreate;

    public DatePickerFragment() {
    }

    public static DatePickerFragment newInstance(int index) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_date_picker, container, false);
        datePicker = view.findViewById(R.id.datePicker);
        timeCreate = AppData.notes.get(index).getCreateTime();
        datePicker.updateDate(
                timeCreate.get(GregorianCalendar.YEAR),
                timeCreate.get(GregorianCalendar.MONTH),
                timeCreate.get(GregorianCalendar.DATE));
        view.findViewById(R.id.saveDateButton).setOnClickListener(v -> {
            timeCreate.set(
                    datePicker.getYear(),
                    datePicker.getMonth(),
                    datePicker.getDayOfMonth());
            AppData.notes.get(index).setCreateTime(timeCreate);
            FragmentChangeListener fragmentChangeListener = (FragmentChangeListener) getActivity();
            assert fragmentChangeListener != null;
            fragmentChangeListener.closeFragmentAndBackTo(index);
        });
        return view;
    }
}