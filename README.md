# AndroidDaggerPractice1
Another practice project to get more reps in using dagger
## Purpose
This project focuses only on dagger.  It deliberately leaves out MVP to make it more obvious what dagger components are necessary to make dependency injection with dagger work
### App dependencies
For this project, I chose the latest Android SDK (27), and its related support library.
I discovered that `com.android.support:appcompat-v7` and `com.android.support:design`
both have to be explicitly configured in the app `build.gradle` to reference the same support version.
### Dagger code generation
The DaggerAppComponent class, which is mandatory for the App class, will only generate after the Activity/Activities
referenced in the BuildersModule is created.  It contains the concrete implementation of providers, builders, factories and subcomponents that define the object of the app whose initial point of contact is AppComponent.
