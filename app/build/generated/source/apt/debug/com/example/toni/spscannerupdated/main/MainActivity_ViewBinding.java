// Generated code from Butter Knife. Do not modify!
package com.example.toni.spscannerupdated.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.toni.spscannerupdated.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131492966;

  private View view2131492967;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.scan_btn, "method 'startScan'");
    view2131492966 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startScan();
      }
    });
    view = Utils.findRequiredView(source, R.id.history_btn, "method 'navigateToHistoryActivity'");
    view2131492967 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.navigateToHistoryActivity();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131492966.setOnClickListener(null);
    view2131492966 = null;
    view2131492967.setOnClickListener(null);
    view2131492967 = null;
  }
}
