<p align="center"><a href="/" target="_blank"><img src="https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/LogoGoGym.png" width="400" alt="GoGym Logo"></a></p>

## Mobile Development Documentation
The source code of Android app of GoGym using Kotlin in order to complete Bangkit Capstone Project.

 - ### Architecture for this project  
![architecture gogym](https://github.com/bangkit-gogym/GoGym/assets/84064388/68fe8fc7-4f98-42b8-96c3-7f0731ad072e)

 - ### Feature
      * **Splash Screen**, There is logo screen before into the login page

      * **Login**, Allows a user to gain access to an application by entering their username and password

      * **SignUp**, Enables users to independently register and gain access to the system

      * **Home**, The start page that is displayed when you have logged in on your device

      * **Pick Image From Gallery**, You can select an image from the gallery in preparation for uploading an image to detect the equipment.
 
      * **Take Image From Camera**, You can take image from camera in preparation for uploading an image to detect the equipment.

      * **Send image to server to detect a equipment**, After you prepare the image, you can click the process button to send the image and detect the image and get the detail about the equipment

      * **Article About Equipment Gym**,  in this application you can read articles about equipment


* #### Dependencies :
  - [Lottie Files](https://lottiefiles.com/)
  - [Retrofit 2](https://square.github.io/retrofit/)    
  - [Ok Http 3](https://square.github.io/okhttp/) 
  - [Jetpack Compose](https://developer.android.com/jetpack/compose)
  - [kotlinx-coroutines](https://developer.android.com/kotlin/coroutines)  
  - [Lifecycle & Livedata](https://developer.android.com/jetpack/androidx/releases/lifecycle)
  - [Navigation Component](https://developer.android.com/jetpack/androidx/releases/navigation)
  - [Google Play services Maps](https://developers.google.com/maps/documentation/android-sdk/get-api-key) 

### Getting Started Application

  - ### Prerequisites
      - ##### Tools Sofware
        - [Android Studio](https://developer.android.com/studio)
        - JRE (Java Runtime Environment) or JDK (Java Development Kit).

      - #### Installation
        - Get an API Key at [Google Maps Platform](https://developers.google.com/maps/documentation/android-sdk/get-api-key)
        - Connect Android Studio with Firebase [Connect to Firebase](https://developer.android.com/studio/write/firebase)
        - Clone this repository and import into Android Studio    
            ```
               https://github.com/bangkit-gogym/GoGym.git
            ``` 
        - Enter your API in buildConfigField `build.graddle`
           ``` defaultConfig {
               buildConfigField("String", "MAPS_TOKEN", '"Your Api Key"')}

  ## Acknowledgements
  * [Android Jetpack Pro](https://developer.android.com/jetpack)
  * [Android Application Fundamental](https://developer.android.com/guide/components/fundamentals)
  * [Clean Architecture Guide](https://developer.android.com/jetpack/guide)
  * [Dependency injection](https://developer.android.com/training/dependency-injection)
