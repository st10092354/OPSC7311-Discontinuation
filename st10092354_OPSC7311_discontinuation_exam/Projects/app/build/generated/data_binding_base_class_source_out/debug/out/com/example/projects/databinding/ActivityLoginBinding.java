// Generated by view binder compiler. Do not edit!
package com.example.projects.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projects.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView Pass;

  @NonNull
  public final TextView User;

  @NonNull
  public final ImageView back;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final Button btnSignUp;

  @NonNull
  public final EditText etPassword;

  @NonNull
  public final EditText etUser;

  @NonNull
  public final ImageView logo;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull TextView Pass,
      @NonNull TextView User, @NonNull ImageView back, @NonNull Button btnLogin,
      @NonNull Button btnSignUp, @NonNull EditText etPassword, @NonNull EditText etUser,
      @NonNull ImageView logo) {
    this.rootView = rootView;
    this.Pass = Pass;
    this.User = User;
    this.back = back;
    this.btnLogin = btnLogin;
    this.btnSignUp = btnSignUp;
    this.etPassword = etPassword;
    this.etUser = etUser;
    this.logo = logo;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Pass;
      TextView Pass = ViewBindings.findChildViewById(rootView, id);
      if (Pass == null) {
        break missingId;
      }

      id = R.id.User;
      TextView User = ViewBindings.findChildViewById(rootView, id);
      if (User == null) {
        break missingId;
      }

      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btnSignUp;
      Button btnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (btnSignUp == null) {
        break missingId;
      }

      id = R.id.etPassword;
      EditText etPassword = ViewBindings.findChildViewById(rootView, id);
      if (etPassword == null) {
        break missingId;
      }

      id = R.id.etUser;
      EditText etUser = ViewBindings.findChildViewById(rootView, id);
      if (etUser == null) {
        break missingId;
      }

      id = R.id.logo;
      ImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, Pass, User, back, btnLogin,
          btnSignUp, etPassword, etUser, logo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
