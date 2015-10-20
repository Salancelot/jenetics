/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.internal.collection;

import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

import org.jenetics.internal.util.require;

import org.jenetics.util.ISeq;
import org.jenetics.util.MSeq;

/**
 * Contains static {@code Seq} definitions.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class Empty {

	private Empty() {require.noInstance();}

	/**
	 * Empty {@code MSeq} implementation.
	 */
	public static final MSeq<Object> MSEQ = new MSeq<Object>() {

		@Override
		public void set(final int index, final Object value) {
			throw new ArrayIndexOutOfBoundsException("MSeq is empty.");
		}

		@Override
		public ListIterator<Object> listIterator() {
			return asList().listIterator();
		}

		@Override
		public MSeq<Object> subSeq(final int start, final int end) {
			throw new ArrayIndexOutOfBoundsException("MSeq is empty.");
		}

		@Override
		public MSeq<Object> subSeq(final int start) {
			throw new ArrayIndexOutOfBoundsException("MSeq is empty.");
		}

		@Override
		public <B> MSeq<B> map(final Function<? super Object, ? extends B> mapper) {
			requireNonNull(mapper);
			return mseq();
		}

		@Override
		public ISeq<Object> toISeq() {
			return ISEQ;
		}

		@Override
		public MSeq<Object> copy() {
			return this;
		}

		@Override
		public Object get(final int index) {
			throw new ArrayIndexOutOfBoundsException("MSeq is empty.");
		}

		@Override
		public int length() {
			return 0;
		}

		@Override
		public List<Object> asList() {
			return Collections.emptyList();
		}

		@Override
		public Iterator<Object> iterator() {
			return asList().iterator();
		}

	};


	/**
	 * Empty {@code ISeq} implementation.
	 */
	public static final ISeq<Object> ISEQ = new ISeq<Object>() {

		@Override
		public Iterator<Object> iterator() {
			return asList().iterator();
		}

		@Override
		public ISeq<Object> subSeq(final int start, final int end) {
			throw new ArrayIndexOutOfBoundsException("ISeq is empty.");
		}

		@Override
		public ISeq<Object> subSeq(final int start) {
			throw new ArrayIndexOutOfBoundsException("ISeq is empty.");
		}

		@Override
		public Object get(final int index) {
			throw new ArrayIndexOutOfBoundsException("ISeq is empty.");
		}

		@Override
		public int length() {
			return 0;
		}

		@Override
		public List<Object> asList() {
			return Collections.emptyList();
		}

		@Override
		public <B> ISeq<B> map(final Function<? super Object, ? extends B> mapper) {
			requireNonNull(mapper);
			return iseq();
		}

		@Override
		public MSeq<Object> copy() {
			return MSEQ;
		}

	};

	@SuppressWarnings("unchecked")
	public static <T> MSeq<T> mseq() {
		return (MSeq<T>)MSEQ;
	}

	@SuppressWarnings("unchecked")
	public static <T> ISeq<T> iseq() {
		return (ISeq<T>)ISEQ;
	}

}
