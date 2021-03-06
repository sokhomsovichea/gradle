/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.nativeplatform.fixtures.app

import static org.gradle.nativeplatform.fixtures.app.SourceFileElement.ofFile

class CppLogger extends CppSourceFileElement {
    final SourceFileElement header = ofFile(sourceFile("headers", "logger.h", """
#include <string>

#ifdef _WIN32
#define EXPORT_FUNC __declspec(dllexport)
#else
#define EXPORT_FUNC
#endif

class Logger {
    public:
    void EXPORT_FUNC log(std::string &str);
};
"""))

    final SourceFileElement source = ofFile(sourceFile("cpp", "logger.cpp", """
#include <iostream>
#include "logger.h"

void Logger::log(std::string &str) {
    std::cout << str << std::endl;
}
"""))
}
