package org.smartregister.chw.amba.custom_views;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;

import org.smartregister.chw.amba.domain.MemberObject;
import org.smartregister.chw.amba.fragment.BaseAmbaCallDialogFragment;
import org.smartregister.amba.R;

public class BaseAmbaFloatingMenu extends LinearLayout implements View.OnClickListener {
    private MemberObject MEMBER_OBJECT;

    public BaseAmbaFloatingMenu(Context context, MemberObject MEMBER_OBJECT) {
        super(context);
        initUi();
        this.MEMBER_OBJECT = MEMBER_OBJECT;
    }

    protected void initUi() {
        inflate(getContext(), R.layout.view_amba_floating_menu, this);
        FloatingActionButton fab = findViewById(R.id.amba_fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.amba_fab) {
            Activity activity = (Activity) getContext();
            BaseAmbaCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }  else if (view.getId() == R.id.refer_to_facility_layout) {
            Activity activity = (Activity) getContext();
            BaseAmbaCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }
    }
}