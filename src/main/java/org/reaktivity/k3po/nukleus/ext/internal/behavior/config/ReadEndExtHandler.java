/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.k3po.nukleus.ext.internal.behavior.config;

import java.util.EnumSet;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.kaazing.k3po.driver.internal.behavior.handler.codec.ConfigDecoder;
import org.kaazing.k3po.driver.internal.netty.channel.ShutdownInputEvent;

public class ReadEndExtHandler extends AbstractReadExtHandler
{
    public ReadEndExtHandler(
        ConfigDecoder decoder)
    {
        super(EnumSet.of(ChannelEventKind.INPUT_SHUTDOWN), decoder);
    }

    @Override
    public void inputShutdown(
        ChannelHandlerContext ctx,
        ShutdownInputEvent evt)
    {
        doReadExtension(ctx);

        super.inputShutdown(ctx, evt);
    }
}