// Generated code from Butter Knife. Do not modify!
package com.example.toni.spscanner.ui.scan;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.toni.spscanner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScanActivity_ViewBinding implements Unbinder {
  private ScanActivity target;

  private View view2131165274;

  private View view2131165239;

  @UiThread
  public ScanActivity_ViewBinding(ScanActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ScanActivity_ViewBinding(final ScanActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.scan_btn, "method 'startScan'");
    view2131165274 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.startScan();
      }
    });
    view = Utils.findRequiredView(source, R.id.history_btn, "method 'navigateToHistoryActivity'");
    view2131165239 = view;
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


    view2131165274.setOnClickListener(null);
    view2131165274 = null;
    view2131165239.setOnClickListener(null);
    view2131165239 = null;
  }
}
