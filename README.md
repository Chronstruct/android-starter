# Chronstruct's Android Starter App

### Up and Running

```shell
$ git clone git@github.com:Chronstruct/android-starter.git <YOUR_REPO_NAME>
$ cd <YOUR_REPO_NAME>
$ git remote set-url origin <YOUR_NEWLY_CREATED_GIT_REPO_URL>
$ git remote add upstream git@github.com:Chronstruct/android-starter.git #for merging future updates
```

Now, rename the project with the steps listed in [this](https://stackoverflow.com/questions/16804093/android-studio-rename-package/29092698#29092698) SO post.

You should be able to run the app without errors (gradle has some red warnings, but that is OK).

### Deploying
##### Sign the APK
You need a `keystore.properties` in the root of your project with the following format (without the `<``>`s):
```text
storeFile=<full/path/to/keystore.properties>
storePassword=<KEY_PASSWORD>
keyAlias=<ALIAS>
keyPassword=<ALIAS_PASSWORD>
```

Don't have a key to sign with you? Follow this link. TODO

##### Deploy to Internal track from gradle
You need a `key.p12` file in the root of your project to use Play Console's API.

Don't have a `key.p12` yet? Follow this link. TODO

Also, fill in the `serviceAccountEmail = '<YOUR_SERVICE_ACCOUNT_EMAIL>'` (project's `build.gradle`) with your generated email with Play Store API access.

## This starter includes
<p><details>
  <summary><b>Instant Apps</b></summary>
  <p>Discovery via Instant App</br>
    </br>
     Search - query to instant app</br>
     ads - to instant app</br>
     links</br>
    </br>
     "Try Now" is like window shopping. A gateway to try without commitment. "Try Now" removes commitment anxiety, and reduces install friction.</br>
    </br>
     Web banners: from "Install" to "Open"</br>
   </p>
</details></p>
<p><details>
  <summary><b>Single Activity Apps</b></summary>
  <p>Activity manages common app chrome (appbar, bottom bar, etc).</br>
     transitions and animations managed by Navigation, not by hand</br>
     </br>
     fragments now form the screens
   </p>
</details></p>

## Dev Notes
Since this app is not set up with dynamic `feature` modules, it's root folder name is `app`. If you switch over to using feature modules, be sure to rename `app` -> `base`.

Follow codelabs like [Your First Android App Bundle](https://codelabs.developers.google.com/codelabs/your-first-dynamic-app/index.html?index=..%2F..%2Findex#0) and [Navigation Codelab](https://codelabs.developers.google.com/codelabs/android-navigation/index.html?index=..%2F..%2Findex#0) to get going. 

### Run Targets
- `./gradlew connectedAndroidTest` - run UI tests


## Tips
### Testing
Test focused on a single behavior. Test behaviors independently.

Use common setup methods only for scaffolding (creating object under test and wiring up depenecies)

Only mock your own classes, not something from the Android framework

Use Roboelectric for unit tests with android framework (for unit tests). This is better than mocks.

Android Test - for on-device and off-device
- scaffolding (AndroidJUnit4)
- given (ActivityTestRule, Builder)
- when (espresso)
- then (intents, assertions)

#### UI tests with Espresso and Robots
[Espresso cheat sheet  \|  Android Developers](https://developer.android.com/training/testing/espresso/cheat-sheet)

[Adam McNeilly \- Espresso Patronum: The Magic Of The Robot Pattern on Vimeo](https://vimeo.com/266512108)

#### Naming
from [Android Architecture Part 5: How to Test Clean Architecture • Five](http://five.agency/android-architecture-part-5-test-clean-architecture/)

specification-style naming: Name does not say anything about the implementation, and from the tests’ names – specification – we can write the actual concrete class. Specification-style names are usually the best way to go, but if you think you cannot test some implementation specific edge cases, you can always throw in few example-style tests.

```
@Test
 public void shouldDeleteExistingFeed() throws Exception {  

}

  @Test 
public void shouldIgnoreDeletingNonExistingFeed() throws Exception {  

}
```

Example-style tests are examples of system usage. They are nice when testing edge cases, but don’t use them for everything, they are too coupled with the implementation.

```
@Test
 public void doSomethingWithIdsSmallerThanZero() throws Exception {  

}

  @Test
 public void ignoreWhenNullIsPassed() throws Exception {

  }
```

#### Tests as documentation
- documentation goes stale
- tests should not

#### TDD
With Android TDD, to get your first Integration test to fail (correctly, not throw exceptions), just need an empty Activity with some resource IDs.

from [Unit Testing in Android Studio Canary with Kotlin – AndroidPub](https://android.jlelse.eu/unit-testing-in-android-studio-canary-with-kotlin-612cea3c0790)
- Sit down and think and write a rough specification.
- Write the tests to exercise the specification.
- Write stubs for the code.
- Run the tests from the command line — yay! everything fails!
- Start writing the code, augmenting the tests where I feel it’s a good idea to catch edge cases. (Don’t reduce the number of tests — always increase)
- Run the tests again, potentially with debug to step through the code to see where I’ve been an idiot.
- Repeat the last two steps as often as is required.

from [Droidcon 2015 / TDD for Android \- Matteo Vaccari \- YouTube](https://www.youtube.com/watch?v=RLo6hs1uDLA):
Start with failing acceptance test.

Cycle into RGF of UNIT tests. After many cycles, your original acceptance test will pass.

Write new failing acceptance test and cycle.

---

Mock your view before it exists.

Use Mocks for designing YOUR interfaces, not Android's

----

giveSomeSetupCondition()
whenSomethingExecutes()
thenAssertsHappen()

instead of
// Given
code
code
code
// When
code
code
code
// Then
code
code
code

#### Integration Tests
Only test a single View, Fragment, or Activity

### Kotlin
Use `.also()` in chains for logging
