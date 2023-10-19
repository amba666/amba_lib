package org.smartregister.chw.amba.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.amba.contract.AmbaProfileContract;
import org.smartregister.chw.amba.domain.MemberObject;
import org.smartregister.chw.amba.util.AppExecutors;
import org.smartregister.chw.amba.util.AmbaUtil;
import org.smartregister.domain.AlertStatus;

import java.util.Date;

public class BaseAmbaProfileInteractor implements AmbaProfileContract.Interactor {
    protected AppExecutors appExecutors;

    @VisibleForTesting
    BaseAmbaProfileInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseAmbaProfileInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void refreshProfileInfo(MemberObject memberObject, AmbaProfileContract.InteractorCallBack callback) {
        Runnable runnable = () -> appExecutors.mainThread().execute(() -> {
            callback.refreshFamilyStatus(AlertStatus.normal);
            callback.refreshMedicalHistory(true);
            callback.refreshUpComingServicesStatus("Amba Visit", AlertStatus.normal, new Date());
        });
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveRegistration(final String jsonString, final AmbaProfileContract.InteractorCallBack callback) {

        Runnable runnable = () -> {
            try {
                AmbaUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        appExecutors.diskIO().execute(runnable);
    }
}
