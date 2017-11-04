package de.textmode.lpdbox;

/*
 * Copyright 2017 Michael Knigge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.List;

/**
 * The {@link ReportQueueStateShortCommandHandler} is responsible for handling the daemon command
 * "Send queue state (short)".
 */
public interface ReportQueueStateShortCommandHandler {

    /**
     * Handles the daemon command "Send queue state (short)". Returns an textual description
     * of the print queue with the given name. If the List is empty, all jobs are
     * returned. Note that every line of the textual description must end with an line feed.
     */
    default String handle(final String queueName, final List<String> jobs) {
        return "This dummy LPD-Server can not report print queue entries.\n";
    }
}
