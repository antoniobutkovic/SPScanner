// Generated code from Butter Knife. Do not modify!
package com.example.toni.spscanner.ui.history.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.toni.spscanner.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ScanHistoryAdapter$TaskViewHolder_ViewBinding implements Unbinder {
  private ScanHistoryAdapter.TaskViewHolder target;

  @UiThread
  public ScanHistoryAdapter$TaskViewHolder_ViewBinding(ScanHistoryAdapter.TaskViewHolder target,
      View source) {
    this.target = target;

    target.scannedValueTv = Utils.findRequiredViewAsType(source, R.id.num, "field 'scannedValueTv'", TextView.class);
    target.resultTv = Utils.findRequiredViewAsType(source, R.id.value, "field 'resultTv'", TextView.class);
    target.timestampTv = Utils.findRequiredViewAsType(source, R.id.timestamp, "field 'timestampTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ScanHistoryAdapter.TaskViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.scannedValueTv = null;
    target.resultTv = null;
    target.timestampTv = null;
  }
}
