/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.slack.automation.functional;

import org.junit.Test;
import org.mule.modules.slack.client.model.file.FileUploadResponse;
import org.mule.modules.slack.automation.runner.AbstractSlackTestCase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

/**
 * Created by estebanwasinger on 8/8/15.
 */
public class UploadFileAsInputStreamTestCases extends AbstractSlackTestCase {

    @Test
    public void testUploadFileAsInputStream() throws IOException {
        String text = "Text as inputStream";
        InputStream stream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        FileUploadResponse fileUploadResponse = getConnector().uploadFileAsInputStreams(GROUP_ID,null,null,null,null,stream);
        assertEquals(text,fileUploadResponse.getPreview());
    }

}
