package org.smartregister.chw.amba.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.amba.contract.AmbaRegisterContract;
import org.smartregister.chw.amba.util.AppExecutors;
import org.smartregister.chw.amba.util.AmbaUtil;

public class BaseAmbaRegisterInteractor implements AmbaRegisterContract.Interactor {

    private AppExecutors appExecutors;

    @VisibleForTesting
    BaseAmbaRegisterInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseAmbaRegisterInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void saveRegistration(final String jsonString, final AmbaRegisterContract.InteractorCallBack callBack) {

        Runnable runnable = () -> {
            try {
                AmbaUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            appExecutors.mainThread().execute(() -> callBack.onRegistrationSaved());
        };
        appExecutors.diskIO().execute(runnable);
    }
}
