# Native SDK Android

The SDK allows you to add to application for upload to the Bintray

### Installation

1.) Create new android application.

2.) Import Native SDK Android module to the application.

3.) After you finished update code, you have to change build.gradle script on Native SDK Android
in the part libraryVersion before upload to Bintray.
```
Example:
'1.0.0' << For master
'1.0.0-dbs' << For specify project
'1.0.0-21' << For specify compileSdkVersion 21
```

```sh
ext {
  ...
  libraryVersion = '{library version name}'
  ...
}
```
4.) Open terminal on android studio and make sure current point to application root.

5.) Run script gradle install
```
  ./gradlew install
```
Warning: make sure gradle install successful
6.) Run script bintray upload
```
  ./gradlew bintrayUpload
```
