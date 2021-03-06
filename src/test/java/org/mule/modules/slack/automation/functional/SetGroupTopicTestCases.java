/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.slack.automation.functional;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mule.modules.slack.automation.runner.AbstractSlackTestCase;

public class SetGroupTopicTestCases extends AbstractSlackTestCase {

    @Test
    public void testSetGroupTopic() {
        String date = getDateString();
        getConnector().setGroupTopic(GROUP_ID, date);
        String topic = getConnector().getGroupInfo(GROUP_ID).getTopic().getValue();
        assertEquals(topic,date);
    }

}
