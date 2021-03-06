/*
 * Copyright 2019 Arcus Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.iris.client.impl.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class TextChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
   private final TextMessageHandler handler;
   
   TextChannelHandler(TextMessageHandler handler) {
      this.handler = handler;
   }

   @Override
   protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg)
         throws Exception {
      String json = msg.text();
      if (json != null && !json.isEmpty()) {
         handler.handleMessage(json);
      }
   }
}

