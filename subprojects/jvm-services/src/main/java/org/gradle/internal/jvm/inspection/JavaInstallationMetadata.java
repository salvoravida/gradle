/*
 * Copyright 2020 the original author or authors.
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

package org.gradle.internal.jvm.inspection;

import org.gradle.api.JavaVersion;

import java.nio.file.Path;

public interface JavaInstallationMetadata {

    enum DistributionType {
        JRE,
        JDK
    }

    // XXX: to be determined if we encode impl (j9/hs) into the vendor
    enum JvmVendor {
        ADOPT_OPENJDK_HOTSPOT,
        ADOPT_OPENJDK_J9,
        AMAZON,
        AZUL,
        BELLSOFT,
        HEWLETT_PACKARD,
        IBM,
        JAVA_NET,
        JETBRAINS,
        ORACLE,
        ORACLE_OPEN_JDK,
        SAP,
        UNKNOWN
    }

    Path getJavaHome();

    // XXX maybe pull down JavaLanguageVersion to here
//    JavaLanguageVersion getLanguageVersion();
    JavaVersion getLanguageVersion();

    JvmVendor getVendor();

    String getImplementationVersion();

    DistributionType getDistributionType();

    boolean isValidInstallation();
    String getError();
}
