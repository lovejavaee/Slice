/*-
 * #%L
 * Slice - Persistence
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
package com.cognifide.slice.persistence.impl.serializer;

import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;

import com.cognifide.slice.persistence.api.SerializerContext;
import com.cognifide.slice.persistence.api.serializer.ObjectSerializer;

public class NativeArraySerializer implements ObjectSerializer {

	@Override
	public int getPriority() {
		return 100;
	}

	@Override
	public boolean accepts(Class<?> clazz) {
		if (!clazz.isArray()) {
			return false;
		}
		final Class<?> arrayType = clazz.getComponentType();
		return NativePropertySerializer.isNativeJcrClass(arrayType);
	}

	@Override
	public void serialize(String propertyName, Object object, Resource parent, SerializerContext ctx)
			throws PersistenceException {
		final ModifiableValueMap map = parent.adaptTo(ModifiableValueMap.class);

		if (object == null) {
			map.remove(propertyName);
		} else {
			map.put(propertyName, object);
		}
	}
}
