# Lifecycle Aware ViewBindingProvider

[ViewBindingProvider](https://github.com/jamesalee213/viewbinding-provider/blob/main/library/src/main/java/com/jal/viewbinding/ViewBindingProvider.kt) is a library designed to help you easily integrate Android's view binding to your fragments. <br>
It keeps track of the view binding with fragment view's lifecycle, so that you don't have to.

## Dependency
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency
```groovy
dependencies {
    implementation 'com.github.jamesalee213:viewbinding-provider:1.0.5'
}
```

## Problem
Android's [view binding](https://developer.android.com/topic/libraries/view-binding) is great!
You no longer have to find your views or worry about casting them. <br>
However, you have to keep track of the binding if you are using it in a fragment.

```kotlin
private var _binding: ResultProfileBinding? = null
// This property is only valid between onCreateView and
// onDestroyView.
private val binding get() = _binding!!

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    _binding = ResultProfileBinding.inflate(inflater, container, false)
    val view = binding.root
    return view
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
```

## Solution
With this library, you no longer have to keep track of it!<br>
Just use the ViewBindingProvider and it will keep track of the binding with the fragment's view lifecycle owner <br>
You can look at 
[MainFragment](https://github.com/jamesalee213/viewbinding-provider/blob/main/demo/app/src/main/java/com/jal/viewbinding/demo/MainFragment.kt)
in the demo for more detailed example <br>

```kotlin
private val viewBindingProvider by viewBindingProvider<ResultProfileBinding>()

override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    return viewBindingProvider.initialize {
       // You still have to inflate/bind by calling the static method
       ResultProfileBinding.inflate(layoutInflater, container, false)
    }
}
```

<br> If you decide to use this library, that is great.<br>
But I highly recommend using [Compose](https://developer.android.com/jetpack/compose) for your next project.
