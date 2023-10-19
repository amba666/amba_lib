package org.smartregister.presenter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.amba.contract.AmbaProfileContract;
import org.smartregister.chw.amba.domain.MemberObject;
import org.smartregister.chw.amba.presenter.BaseAmbaProfilePresenter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseAmbaProfilePresenterTest {

    @Mock
    private AmbaProfileContract.View view = Mockito.mock(AmbaProfileContract.View.class);

    @Mock
    private AmbaProfileContract.Interactor interactor = Mockito.mock(AmbaProfileContract.Interactor.class);

    @Mock
    private MemberObject memberObject = new MemberObject();

    private BaseAmbaProfilePresenter profilePresenter = new BaseAmbaProfilePresenter(view, interactor, memberObject);


    @Test
    public void fillProfileDataCallsSetProfileViewWithDataWhenPassedMemberObject() {
        profilePresenter.fillProfileData(memberObject);
        verify(view).setProfileViewWithData();
    }

    @Test
    public void fillProfileDataDoesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(null);
        verify(view, never()).setProfileViewWithData();
    }

    @Test
    public void ambaTestDatePeriodIsLessThanSeven() {
        profilePresenter.recordAmbaButton("");
        verify(view).hideView();
    }

    @Test
    public void ambaTestDatePeriodGreaterThanTen() {
        profilePresenter.recordAmbaButton("OVERDUE");
        verify(view).setOverDueColor();
    }

    @Test
    public void ambaTestDatePeriodIsMoreThanFourteen() {
        profilePresenter.recordAmbaButton("EXPIRED");
        verify(view).hideView();
    }

    @Test
    public void refreshProfileBottom() {
        profilePresenter.refreshProfileBottom();
        verify(interactor).refreshProfileInfo(memberObject, profilePresenter.getView());
    }

    @Test
    public void saveForm() {
        profilePresenter.saveForm(null);
        verify(interactor).saveRegistration(null, view);
    }
}
