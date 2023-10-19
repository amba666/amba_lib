package org.smartregister.chw.amba.listener;


import android.view.View;

import org.smartregister.chw.amba.fragment.BaseAmbaCallDialogFragment;
import org.smartregister.chw.amba.util.AmbaUtil;
import org.smartregister.amba.R;

import timber.log.Timber;

public class BaseAmbaCallWidgetDialogListener implements View.OnClickListener {

    private BaseAmbaCallDialogFragment callDialogFragment;

    public BaseAmbaCallWidgetDialogListener(BaseAmbaCallDialogFragment dialogFragment) {
        callDialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.amba_call_close) {
            callDialogFragment.dismiss();
        } else if (i == R.id.amba_call_head_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                AmbaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        } else if (i == R.id.call_amba_client_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                AmbaUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }
}
