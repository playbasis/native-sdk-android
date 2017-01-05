# Native SDK Android

This SDK don't need to be include as module on the customer app, but require to be upload on bintray.
The following instruction explain how to update and upload the SDK into bintray.

### Installation

1.) Create new android application.

2.) Import Native SDK Android module to the application.

3.) Update the SDK code.

4.) Once it's done, you need to change the Native SDK Android version name on build.gradle file.
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

5.) Add bintray user and api_key to bottom of "local.properties" file at root project folder.

PS: you can ask K.Thanakij for user and api key
```
bintray.user={USER}
bintray.apikey={API_KEY}
```

6.) Open a terminal session on the app folder.

7.) Run gradle install script

Warning: make sure gradle install successful

Recommend: you should run this command 2 times
```
  ./gradlew install
```

8.) Run bintray upload script
```
  ./gradlew bintrayUpload
```
