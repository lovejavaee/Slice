/*-
 * #%L
 * Slice - Core
 * %%
 * Copyright (C) 2012 Wunderman Thompson Technology
 * %%
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
 * #L%
 */
package com.cognifide.slice.core.internal.scanner;

import java.util.regex.Pattern;

public class BundleMatcher {

	private final Pattern pattern;

	private final BundleInfo bundleInfo;

	public BundleMatcher(final BundleInfo bundleInfo) {
		this.bundleInfo = bundleInfo;
		this.pattern = Pattern.compile(bundleInfo.getBundleNameFilter());
	}

	public boolean matches(final String bundleName) {
		return pattern.matcher(bundleName).matches();
	}

	public BundleInfo getBundleInfo() {
		return bundleInfo;
	}

}
