/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.connection.nio;

import com.hazelcast.nio.SelectionHandler;

import java.nio.channels.SelectionKey;

/**
 * @author ali 16/12/13
 */
public class ClientInSelectorImpl extends ClientAbstractIOSelector {

    public ClientInSelectorImpl(ThreadGroup threadGroup) {
        super(threadGroup, "InSelector");
    }

    protected void handleSelectionKey(SelectionKey sk) {
        if (sk.isValid() && sk.isReadable()) {
            final SelectionHandler handler = (SelectionHandler) sk.attachment();
            handler.handle();
        }
    }
}
