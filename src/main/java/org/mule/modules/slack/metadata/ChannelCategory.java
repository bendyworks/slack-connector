/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.slack.metadata;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.modules.slack.SlackConnector;
import org.mule.modules.slack.client.model.channel.Channel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@MetaDataCategory
public class ChannelCategory {

    @Inject
    private SlackConnector connector;

    @MetaDataKeyRetriever
    public List<MetaDataKey> getEntities() throws Exception {
        List<MetaDataKey> entities = new ArrayList<MetaDataKey>();
        List<Channel> channelList = connector.slack().channels.getChannelList();
        for (Channel channel : channelList) {
            entities.add(new DefaultMetaDataKey(channel.getId(), channel.getName() + " - " + channel.getId()));
        }

        return entities;
    }

    @MetaDataRetriever
    public MetaData describeEntity(MetaDataKey entityKey) throws Exception {
        return null;
    }

    public SlackConnector getConnector() {
        return connector;
    }

    public void setConnector(SlackConnector connector) {
        this.connector = connector;
    }

}