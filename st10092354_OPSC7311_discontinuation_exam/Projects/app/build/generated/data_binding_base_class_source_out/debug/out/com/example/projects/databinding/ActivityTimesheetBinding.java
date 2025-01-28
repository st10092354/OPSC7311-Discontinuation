// Generated by view binder compiler. Do not edit!
package com.example.projects.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projects.R;
import com.google.android.material.navigation.NavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTimesheetBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final Button buttonAddPhoto;

  @NonNull
  public final Button buttonSubmit;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final EditText editTextDate;

  @NonNull
  public final EditText editTextDescription;

  @NonNull
  public final EditText editTextEndTime;

  @NonNull
  public final EditText editTextStartTime;

  @NonNull
  public final NavigationView navView;

  @NonNull
  public final ImageView newImage;

  @NonNull
  public final Spinner spinnerCategory;

  @NonNull
  public final TextView textViewCategory;

  @NonNull
  public final TextView textViewDate;

  @NonNull
  public final TextView textViewDescription;

  @NonNull
  public final TextView textViewEndTime;

  @NonNull
  public final TextView textViewStartTime;

  @NonNull
  public final Toolbar toolbar;

  private ActivityTimesheetBinding(@NonNull DrawerLayout rootView, @NonNull Button buttonAddPhoto,
      @NonNull Button buttonSubmit, @NonNull DrawerLayout drawerLayout,
      @NonNull EditText editTextDate, @NonNull EditText editTextDescription,
      @NonNull EditText editTextEndTime, @NonNull EditText editTextStartTime,
      @NonNull NavigationView navView, @NonNull ImageView newImage,
      @NonNull Spinner spinnerCategory, @NonNull TextView textViewCategory,
      @NonNull TextView textViewDate, @NonNull TextView textViewDescription,
      @NonNull TextView textViewEndTime, @NonNull TextView textViewStartTime,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.buttonAddPhoto = buttonAddPhoto;
    this.buttonSubmit = buttonSubmit;
    this.drawerLayout = drawerLayout;
    this.editTextDate = editTextDate;
    this.editTextDescription = editTextDescription;
    this.editTextEndTime = editTextEndTime;
    this.editTextStartTime = editTextStartTime;
    this.navView = navView;
    this.newImage = newImage;
    this.spinnerCategory = spinnerCategory;
    this.textViewCategory = textViewCategory;
    this.textViewDate = textViewDate;
    this.textViewDescription = textViewDescription;
    this.textViewEndTime = textViewEndTime;
    this.textViewStartTime = textViewStartTime;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTimesheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTimesheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_timesheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTimesheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAddPhoto;
      Button buttonAddPhoto = ViewBindings.findChildViewById(rootView, id);
      if (buttonAddPhoto == null) {
        break missingId;
      }

      id = R.id.buttonSubmit;
      Button buttonSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonSubmit == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.editTextDate;
      EditText editTextDate = ViewBindings.findChildViewById(rootView, id);
      if (editTextDate == null) {
        break missingId;
      }

      id = R.id.editTextDescription;
      EditText editTextDescription = ViewBindings.findChildViewById(rootView, id);
      if (editTextDescription == null) {
        break missingId;
      }

      id = R.id.editTextEndTime;
      EditText editTextEndTime = ViewBindings.findChildViewById(rootView, id);
      if (editTextEndTime == null) {
        break missingId;
      }

      id = R.id.editTextStartTime;
      EditText editTextStartTime = ViewBindings.findChildViewById(rootView, id);
      if (editTextStartTime == null) {
        break missingId;
      }

      id = R.id.nav_view;
      NavigationView navView = ViewBindings.findChildViewById(rootView, id);
      if (navView == null) {
        break missingId;
      }

      id = R.id.newImage;
      ImageView newImage = ViewBindings.findChildViewById(rootView, id);
      if (newImage == null) {
        break missingId;
      }

      id = R.id.spinnerCategory;
      Spinner spinnerCategory = ViewBindings.findChildViewById(rootView, id);
      if (spinnerCategory == null) {
        break missingId;
      }

      id = R.id.textViewCategory;
      TextView textViewCategory = ViewBindings.findChildViewById(rootView, id);
      if (textViewCategory == null) {
        break missingId;
      }

      id = R.id.textViewDate;
      TextView textViewDate = ViewBindings.findChildViewById(rootView, id);
      if (textViewDate == null) {
        break missingId;
      }

      id = R.id.textViewDescription;
      TextView textViewDescription = ViewBindings.findChildViewById(rootView, id);
      if (textViewDescription == null) {
        break missingId;
      }

      id = R.id.textViewEndTime;
      TextView textViewEndTime = ViewBindings.findChildViewById(rootView, id);
      if (textViewEndTime == null) {
        break missingId;
      }

      id = R.id.textViewStartTime;
      TextView textViewStartTime = ViewBindings.findChildViewById(rootView, id);
      if (textViewStartTime == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityTimesheetBinding((DrawerLayout) rootView, buttonAddPhoto, buttonSubmit,
          drawerLayout, editTextDate, editTextDescription, editTextEndTime, editTextStartTime,
          navView, newImage, spinnerCategory, textViewCategory, textViewDate, textViewDescription,
          textViewEndTime, textViewStartTime, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
