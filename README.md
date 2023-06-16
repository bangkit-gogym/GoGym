<p align="center"><a href="/" target="_blank"><img src="https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/LogoGoGym.png" width="400" alt="GoGym Logo"></a></p>

## Cloud Computing Documentation

The source code of GoGym Backend/API which make uses of Laravel 10 as the framework provider with some dependencies and Google Cloud Platform in order to complete Bangkit Capstone Project. Here are the related links/websites that the application uses :

- [Laravel](https://laravel.com/).
- [Google Cloud Console](https://console.cloud.google.com/).
- Package [Google Cloud Storage filesystem driver for Laravel](https://github.com/spatie/laravel-google-cloud-storage) by spatie.
- Authentication [Laravel Sanctum](https://laravel.com/docs/10.x/sanctum).

### Getting Started

  - ### Prerequisites
      - ##### Tools/Software/etc
        - [Visual Studio Code](https://code.visualstudio.com/)
        - Google Cloud Platform Account, [sign up here](https://cloud.google.com/)
        - Google App Engine and a Google Cloud Bucket
        - [PHP](https://www.php.net/)
        - [Composer](https://getcomposer.org/)
        - [Google Cloud SDK](https://cloud.google.com/sdk/docs/install-sdk)

      - #### Installation
        - Clone the [backend-api](https://github.com/bangkit-gogym/GoGym/tree/backend-api) branch in this repository and import into Visual Studio Code   
            ```
               https://github.com/bangkit-gogym/GoGym.git
            ```
        - Initialize Laravel in the related directory [Install Laravel](https://laravel.com/docs/10.x/installation)
        - Install the related dependencies
        - Run composer command   
            ```
               composer install
            ``` 
        - Update the Google Cloud Service Package with your corresponding credentials in the filesystems.php
        - Migrate the database and seed the database
            ```
               php artisan migrate
               php artisan db:seed --class=EquipmentsSeeder
            ``` 
        - Initialize Google Cloud SDK
            ```
               gcloud init
            ``` 
        - Deploy the API to the Google App Engine
            ```
               gcloud app deploy
            ``` 

## License

The Laravel framework is open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).
