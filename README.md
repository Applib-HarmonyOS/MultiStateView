# MultiStateView

A HMOS library which provide MultiStateView feature.

## Source

Inspired by [XuDaojie/MultiStateView](https://github.com/XuDaojie/MultiStateView/)

## Feature

This library provides different switching states of View. Included by default are Content, Empty, Fail, Loading states.

<img src="screenshots/ezgif.com-gif-maker (4).gif" width="500">

## Dependency
1. For using multistateview module in sample app, include the source code and add the below dependencies in entry/build.gradle to generate hap/support.har.
```groovy
	dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar', '*.har'])
        implementation project(path: ':multistateview')
        testImplementation 'junit:junit:4.13'
        ohosTestImplementation 'com.huawei.ohos.testkit:runner:1.0.0.100'
        }

```
2. For using multistateview in separate application using har file, add the har file in the entry/libs folder and add the dependencies in entry/build.gradle file.
```groovy
	dependencies {
		implementation fileTree(dir: 'libs', include: ['*.har'])
		testImplementation 'junit:junit:4.13'
	}
```

## Usage
### Include following code in your layout
``` xml
<?xml version="1.0" encoding="utf-8"?>
<me.xdj.view.SimpleMultiStateView
    xmlns:ohos="http://schemas.huawei.com/res/ohos"
    xmlns:app="http://schemas.huawei.com/apk/res-auto"
    ohos:id="$+id:multi_state_view"
    ohos:width="match_parent"
    ohos:height="match_parent"
    ohos:alignment="center"
    ohos:text_size="50vp"
    app:msv_emptyView="$layout:msv_view_state_empty"
    app:msv_failView="$layout:msv_view_state_fail"
    app:msv_loadingView="$layout:msv_view_state_loading">
    <DirectionalLayout
        ohos:height="match_parent"
        ohos:width="match_parent"
        ohos:alignment="vertical_center"
        ohos:orientation="vertical">
    </DirectionalLayout>
</me.xdj.view.SimpleMultiStateView>
```

### Include following code in your activity
``` java 
public void setViewState(int state) // Set the view state 
public int getViewState()           // Get the current state 
public View getView(int state)      // Get the view of the specified state 
public void addViewForStatus(int status, int resLayoutID) // Increase the state 
public void setOnInflaterListener(OnInflateListener onInflateListener) // Triggered when each state is Layout inflate (except CONTENT)
```

## License
Copyright XuDaojie

Licensed under the Apache License, Version 2.0 (the "License");<br>
you may not use this file except in compliance with the License.<br>
You may obtain a copy of the License at<br>

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software<br>
distributed under the License is distributed on an "AS IS" BASIS,<br>
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>
See the License for the specific language governing permissions and<br>
limitations under the License.<br>