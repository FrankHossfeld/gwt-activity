# GWT Activity

![GWT3/J2CL compatible](https://img.shields.io/badge/GWT3/J2CL-compatible-brightgreen.svg)  [![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Chat on Gitter](https://badges.gitter.im/hal/elemento.svg)](https://gitter.im/gwtproject/gwt-modules) ![CI](https://github.com/gwtproject/gwt-activity/workflows/CI/badge.svg)

A future-proof port of the `com.google.gwt.activity.Activity` GWT module, with no dependency on `gwt-user` (besides the Java Runtime Emulation), to prepare for GWT 3 / J2Cl.

##  Migrating from `com.google.gwt.activity.Activity`

1. Add the dependency to your build.

   For Maven:

   ```xml
   <dependency>
     <groupId>org.gwtproject.activity</groupId>
     <artifactId>gwt-activity</artifactId>
     <version>HEAD-SNAPSHOT</version>
   </dependency>
   ```

   For Gradle:

   ```gradle
   implementation("org.gwtproject.activity:gwt-activity:HEAD-SNAPSHOT")
   ```

2. Update your GWT module to use

   ```xml
   <inherits name="org.gwtproject.activity.Activity" />
   ```

3. Change the `import`s in your Java source files:

   ```java
   import org.gwtproject.activity.shared.xxx;
   ```

## Instructions

To build gwt-event:

* run `mvn clean verify`

on the parent directory. This will build the artifact and run tests against GWT2. The J2CL test need to be executed with `mvn j2cl:clean` an `mvn j2cl:test` due to a problem with modules that use processors. See: ![https://github.com/Vertispan/j2clmavenplugin/issues/14](https://github.com/Vertispan/j2clmavenplugin/issues/14)

## System Requirements

**GWT Activity requires GWT 2.9.0 or newer!**


## Dependencies

GWT Activity depends on the following module:

* GWT Place
* GWT Event
* GWT Widgets

