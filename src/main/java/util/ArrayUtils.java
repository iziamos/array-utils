/*
 * MIT License
 *
 * Copyright (c) 2019 Ioannis Ziamos
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package util;

import static java.lang.System.arraycopy;

/**
 * Some basic array utils that I needed for some reason and couldn't find
 * online. I also wanted to benchmark this approach vs some suggestions I
 * saw online.
 */
public final class ArrayUtils {

    private ArrayUtils () {}

    public static byte [] replaceBytes(byte [] source, byte [] insert, int pos, int del) {

        final byte [] ret = new byte[source.length + insert.length - del];

        arraycopy(source, 0, ret, 0, pos);
        arraycopy(insert, 0, ret, pos, insert.length);
        arraycopy(source, pos + del, ret, pos + insert.length,source.length - del - pos);

        return ret;
    }

    public static byte [] removeBytes (byte [] source, int pos, int del) {

        final byte [] ret = new byte[source.length - del];

        arraycopy(source, 0 , ret, 0, pos);
        arraycopy(source, pos + del, ret, pos, source.length - pos - del);

        return ret;
    }
}
