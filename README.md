# GWT Activities

[![Build Status](https://travis-ci.org/gwtplus/gwt-activity.svg?branch=master)](https://travis-ci.org/gwtplus/gwt-activity)
[![jitpack.io](https://jitpack.io/v/gwtplus/gwt-activity.svg)](https://jitpack.io/#gwtplus/gwt-activity)

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

1. Update your GWT module to use

   ```xml
   <inherits name="org.gwtproject.activity.Activity" />
   ```

1. Change the `import`s in your Java source files:

   ```java
   import org.gwtproject.activity.*;
   ```

1. Provide implementation of `ActivityDisplay<V>` or use any of provided ones (`WidgetActivityDisplay` from `WidgetActivity` module or `ElementalActivityDisplay` from `ElementalActivity`. Note that `ActivityDisplay` uses `show()` instead od `setWidget()`.

1. Specialize other `org.gwtproject.activity.*` references to `<V>`


## Dependencies

GWT Activity depends on the following modules:
* gwt-places
* gwt-event
