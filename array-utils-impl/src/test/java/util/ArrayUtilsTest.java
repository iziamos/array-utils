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

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static util.ArrayUtils.replaceBytes;
import static util.ArrayUtils.removeBytes;

/**
 * Unit tests for {@link ArrayUtils}.
 *
 * DISCLAIMER: We don't test things like negative positions or deletions
 * because thats not the contract we are making. We're trying to leverage
 * {@link System#arraycopy(Object, int, Object, int, int)} so that we can
 * benchmark vs saner implementations.
 */
public final class ArrayUtilsTest {

    @Test
    public void testBasicInsert() {
        //given
        final byte[] source = "hello world".getBytes();
        final byte[] insert = "beautiful ".getBytes();
        final byte[] expected = "hello beautiful world".getBytes();

        //when
        byte[] actual = replaceBytes(source, insert, 6, 0);

        //then
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testAppend() {
        //given
        final byte[] source = "hello".getBytes();
        final byte[] insert = " world".getBytes();
        final byte[] expected = "hello world".getBytes();

        //when
        final byte[] actual = replaceBytes(source, insert, source.length, 0);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReplace() {
        //given
        final byte[] source = "the ret goes moo".getBytes();
        final byte[] insert = "cow".getBytes();
        final byte[] expected = "the cow goes moo".getBytes();

        //when
        final byte[] actual = replaceBytes(source, insert, 4, 3);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPrepend() {
        //given
        final byte[] source = "world".getBytes();
        final byte[] insert = "hello ".getBytes();
        final byte[] expected = "hello world".getBytes();

        //when
        final byte[] actual = replaceBytes(source, insert, 0, 0);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertToEmptyArray() {
        //given
        final byte[] source = "".getBytes();
        final byte[] insert = "hello".getBytes();
        final byte[] expected = "hello".getBytes();

        //when
        final byte[] actual = replaceBytes(source, insert, 0, 0);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveTail() {
        //given
        final byte[] source =  "ice cream soda".getBytes();
        final byte[] expected =  "ice cream".getBytes();

        //when
        final byte[] actual = removeBytes(source, 9 , 5);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveHead() {
        //given
        final byte[] source =  "ice cream soda".getBytes();
        final byte[] expected =  "cream soda".getBytes();

        //when
        final byte[] actual = removeBytes(source, 0 , 4);

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveMid() {
        //given
        final byte[] source =  "ice cream soda".getBytes();
        final byte[] expected =  "ice soda".getBytes();

        //when
        final byte[] actual = removeBytes(source, 4, 6);

        //then
        assertArrayEquals(expected, actual);
    }
}
