/*
* Copyright 2017 WalmartLabs
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.ernnavigationApi.ern.api;

import androidx.annotation.NonNull;

import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEventListener;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeEvent;
import com.walmartlabs.electrode.reactnative.bridge.ElectrodeBridgeHolder;
import com.walmartlabs.electrode.reactnative.bridge.EventListenerProcessor;
import com.walmartlabs.electrode.reactnative.bridge.EventProcessor;

import java.util.UUID;

final class EnNavigationEvents implements EnNavigationApi.Events {
    EnNavigationEvents() {}

    @Override
    public UUID addOnNavButtonClickEventListener(@NonNull final ElectrodeBridgeEventListener<String> eventListener) {
        return new EventListenerProcessor<>(EVENT_ON_NAV_BUTTON_CLICK, String.class, eventListener).execute();
    }

                @Override
                public ElectrodeBridgeEventListener<ElectrodeBridgeEvent> removeOnNavButtonClickEventListener(@NonNull final UUID uuid) {
                    return ElectrodeBridgeHolder.removeEventListener(uuid);
                }

    //------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public void emitOnNavButtonClick(String buttonId) {
        new EventProcessor<>(EVENT_ON_NAV_BUTTON_CLICK, buttonId).execute();
    }
}
