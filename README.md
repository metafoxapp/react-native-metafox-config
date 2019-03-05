
# react-native-phpfox-config

## Getting started

`$ npm install react-native-phpfox-config --save`

### Mostly automatic installation

`$ react-native link react-native-phpfox-config`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-phpfox-config` and add `RNPhpfoxConfig.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNPhpfoxConfig.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNPhpfoxConfigPackage;` to the imports at the top of the file
  - Add `new RNPhpfoxConfigPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-phpfox-config'
  	project(':react-native-phpfox-config').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-phpfox-config/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-phpfox-config')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNPhpfoxConfig.sln` in `node_modules/react-native-phpfox-config/windows/RNPhpfoxConfig.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Phpfox.Config.RNPhpfoxConfig;` to the usings at the top of the file
  - Add `new RNPhpfoxConfigPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNPhpfoxConfig from 'react-native-phpfox-config';

// TODO: What to do with the module?
RNPhpfoxConfig;
```
  