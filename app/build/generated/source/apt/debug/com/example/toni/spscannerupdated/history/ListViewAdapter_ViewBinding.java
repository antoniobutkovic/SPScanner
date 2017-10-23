// Generated code from Butter Knife. Do not modify!
package com.example.toni.spscannerupdated.history;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.toni.spscannerupdated.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListViewAdapter_ViewBinding implements Unbinder {
  private ListViewAdapter target;

  @UiThread
  public ListViewAdapter_ViewBinding(ListViewAdapter target, View source) {
    this.target = target;

    target.num = Utils.findRequiredViewAsType(source, R.id.num, "field 'num'", TextView.class);
    target.value = Utils.findRequiredViewAsType(source, R.id.value, "field 'value'", TextView.class);
    target.timestamp = Utils.findRequiredViewAsType(source, R.id.timestamp, "field 'timestamp'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListViewAdapter target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.num = null;
    target.value = null;
    target.timestamp = null;
  }
}
