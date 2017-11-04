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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class Util {

    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static final String ERROR_END_OF_STREAM = "Unexpectedly reached the end of the data stream. The connection might be lost.";

    private Util() {
    }

    /**
     * Reads bytes from the {@link InputStream} until a line feed (0x0A)
     * has been read. Returns all bytes but not the line feed.
     */
    static String readLine(final InputStream is) throws IOException {
        final StringBuilder sb = new StringBuilder();

        int readByte = is.read();
        while (readByte != -1) {
            if (readByte == 0x0A) {
                return sb.toString();
            } else {
                sb.append((char) readByte);
            }

            readByte = is.read();
        }

        throw new IOException(ERROR_END_OF_STREAM);
    }

    /**
     * Converts a {@link String} to ISO-8859-1 and writes in to the given {@link OutputStream}.
     */
    static void writeString(final String input, final OutputStream os) throws IOException {
        os.write(input.getBytes(ISO_8859_1));
    }
}
