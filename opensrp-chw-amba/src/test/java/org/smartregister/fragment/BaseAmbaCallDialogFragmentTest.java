package org.smartregister.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.amba.domain.MemberObject;
import org.smartregister.chw.amba.fragment.BaseAmbaCallDialogFragment;

@PrepareForTest(BaseAmbaCallDialogFragment.class)
public class BaseAmbaCallDialogFragmentTest {
    @Spy
    public BaseAmbaCallDialogFragment baseAmbaCallDialogFragment;

    @Mock
    public ViewGroup viewGroup;

    @Mock
    public View view;

    @Mock
    public MemberObject memberObject;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Whitebox.setInternalState(BaseAmbaCallDialogFragment.class, "MEMBER_OBJECT", memberObject);
    }

    @Test(expected = Exception.class)
    public void setCallTitleFamilyHead() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Head of family", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleAnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getAncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message ANC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitleCareGiver() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("123456");
        Mockito.when(memberObject.getPrimaryCareGiver()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Primary Caregiver", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitlePnc() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getPncMember()).thenReturn("0");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message PNC Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void setCallTitle() throws Exception {
        TextView textView = Mockito.mock(TextView.class);

        Mockito.when(memberObject.getBaseEntityId()).thenReturn("1");
        Mockito.when(memberObject.getFamilyHead()).thenReturn("123456");

        Mockito.when(viewGroup.findViewById(view.getId())).thenReturn(textView);

        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "setCallTitle", viewGroup, view.getId(), "message");
        Assert.assertEquals("message Amba Client", textView.getText());
    }

    @Test(expected = Exception.class)
    public void initUI() throws Exception {
        Mockito.when(memberObject.getPhoneNumber()).thenReturn("123456789");
        Whitebox.invokeMethod(baseAmbaCallDialogFragment, "initUI", viewGroup);
        PowerMockito.verifyPrivate(baseAmbaCallDialogFragment).invoke("setCallTitle", viewGroup, view.getId(), "message");

    }
}
