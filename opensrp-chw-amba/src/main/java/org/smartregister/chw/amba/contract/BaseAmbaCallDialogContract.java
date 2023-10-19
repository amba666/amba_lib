package org.smartregister.chw.amba.contract;

import android.content.Context;

public interface BaseAmbaCallDialogContract {

    interface View {
        void setPendingCallRequest(Dialer dialer);
        Context getCurrentContext();
    }

    interface Dialer {
        void callMe();
    }
}
