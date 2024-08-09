package eu.strasbourg.webservices.csmap.application.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.test.rule.Inject;
import eu.strasbourg.webservice.csmap.application.EventApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class EventApplicationTest {

    @DeleteAfterTestRun
    private Group _group;

    @Inject
    private EventApplication _eventApplication;

    private User _user;

    @Before
    public void setUp() throws Exception {
        _group = GroupTestUtil.addGroup();
        _user = TestPropsValues.getUser();

    }

    @Test
    public void testAddFoo() throws Exception {
        Assert.assertNotNull(_eventApplication);
    }

}
