// Generated by view binder compiler. Do not edit!
package com.example.projects.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projects.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHoursByCategoryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final DatePicker endDatePicker;

  @NonNull
  public final ListView hoursListView;

  @NonNull
  public final Button loadHoursButton;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final DatePicker startDatePicker;

  private ActivityHoursByCategoryBinding(@NonNull ConstraintLayout rootView,
      @NonNull DatePicker endDatePicker, @NonNull ListView hoursListView,
      @NonNull Button loadHoursButton, @NonNull ConstraintLayout main,
      @NonNull DatePicker startDatePicker) {
    this.rootView = rootView;
    this.endDatePicker = endDatePicker;
    this.hoursListView = hoursListView;
    this.loadHoursButton = loadHoursButton;
    this.main = main;
    this.startDatePicker = startDatePicker;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHoursByCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHoursByCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_hours_by_category, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHoursByCategoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.endDatePicker;
      DatePicker endDatePicker = ViewBindings.findChildViewById(rootView, id);
      if (endDatePicker == null) {
        break missingId;
      }

      id = R.id.hoursListView;
      ListView hoursListView = ViewBindings.findChildViewById(rootView, id);
      if (hoursListView == null) {
        break missingId;
      }

      id = R.id.loadHoursButton;
      Button loadHoursButton = ViewBindings.findChildViewById(rootView, id);
      if (loadHoursButton == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.startDatePicker;
      DatePicker startDatePicker = ViewBindings.findChildViewById(rootView, id);
      if (startDatePicker == null) {
        break missingId;
      }

      return new ActivityHoursByCategoryBinding((ConstraintLayout) rootView, endDatePicker,
          hoursListView, loadHoursButton, main, startDatePicker);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
