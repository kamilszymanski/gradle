/*
 * Copyright 2012 the original author or authors.
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
 */

package org.gradle.api.internal.artifacts.ivyservice.ivyresolve;

import org.gradle.api.Nullable;
import org.gradle.api.internal.artifacts.ivyservice.ModuleVersionResolveException;

/**
 * The result of attempting to resolve a dependency descriptor to the meta-data for a module version.
 */
public interface BuildableModuleVersionSelectionResolveResult {

    static enum State {
        Listed, ProbablyEmpty, Failed, Unknown
    }

    /**
     * Returns the current state of this descriptor.
     */
    State getState();

    /**
     * Returns the versions that match the selector.
     *
     * @throws org.gradle.api.internal.artifacts.ivyservice.ModuleVersionResolveException If the resolution was not successful.
     */
    ModuleVersions getVersions() throws ModuleVersionResolveException;

    @Nullable
    ModuleVersionResolveException getFailure();

    /**
     * Marks the module as having been listed to have the specified versions available.
     */
    void listed(ModuleVersions versions);

    /**
     * Marks the module as having no versions available.
     */
    void noVersions();

    /**
     * Marks the module as probably having no versions available.
     */
    void probablyNoVersions();

    /**
     * Marks the list as failed with the given exception.
     */
    void failed(ModuleVersionResolveException failure);
}
