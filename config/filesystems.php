<?php

return [

    /*
    |--------------------------------------------------------------------------
    | Default Filesystem Disk
    |--------------------------------------------------------------------------
    |
    | Here you may specify the default filesystem disk that should be used
    | by the framework. The "local" disk, as well as a variety of cloud
    | based disks are available to your application. Just store away!
    |
    */

    'default' => env('FILESYSTEM_DISK', 'local'),

    /*
    |--------------------------------------------------------------------------
    | Filesystem Disks
    |--------------------------------------------------------------------------
    |
    | Here you may configure as many filesystem "disks" as you wish, and you
    | may even configure multiple disks of the same driver. Defaults have
    | been set up for each driver as an example of the required values.
    |
    | Supported Drivers: "local", "ftp", "sftp", "s3"
    |
    */

    'disks' => [

        'local' => [
            'driver' => 'local',
            'root' => storage_path('app'),
            'throw' => false,
        ],

        'public' => [
            'driver' => 'local',
            'root' => storage_path('app/public'),
            'url' => env('APP_URL').'/storage',
            'visibility' => 'public',
            'throw' => false,
        ],

        's3' => [
            'driver' => 's3',
            'key' => env('AWS_ACCESS_KEY_ID'),
            'secret' => env('AWS_SECRET_ACCESS_KEY'),
            'region' => env('AWS_DEFAULT_REGION'),
            'bucket' => env('AWS_BUCKET'),
            'url' => env('AWS_URL'),
            'endpoint' => env('AWS_ENDPOINT'),
            'use_path_style_endpoint' => env('AWS_USE_PATH_STYLE_ENDPOINT', false),
            'throw' => false,
        ],

        'gcs' => [
            'driver' => 'gcs',
            'key_file_path' => env('GOOGLE_CLOUD_KEY_FILE', null), // optional: /path/to/service-account.json
            'key_file' => [
                "type"=> "service_account",
                "project_id"=> "gogym-bangkit-capstone",
                "private_key_id"=> "fdcab9388c9ab7792fbb991907f97094fba6c869",
                "private_key"=> "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCs1agb5iqrBRhE\ncx/e4vzr3uLKwg/6Rp40XlxaoDrxSo6z0cagFZOhD82+M98AIbfSXED2/qP9RIiW\n3rRE2VbsZeewsQs6r7p6NWOZ1cZd6mt8xlCxDxykKQ8E7iuVcy6mbcODynE9DO6R\nUzhBMsWdtvIr2ERugSJ1ydm3vJzdWLBDPNECvUI/s5howTgapus+ZaFA++ngt9Oi\ns1r/npTrtgItSvzpBo12aFpOtIH1oQG3odMBQTovT90eO6P/aCd0TYZcga6vqiUX\nhbSoKu+7KQLC0Rcc+JP6Ms6/nN1lRSdjPU9fujz8giuip6jHzm3uAekUgKpEL3LY\ntKf5b4F7AgMBAAECggEAL+8RsKslKkk/cbx8GlTZ0JEAVTt9Muxi9CM3eer2bfU/\nnp+PdtaFGyZG6Xl5X4/6a10qp1X4JUXcm/soA/BDK00X9OklNCGIllw4Q3IGkgVx\nyik2N+T5DI5WnAdyDwDi70WB9AsxXL05bRSnhW2PYS5b+8z/Laai6AgTWeH1n22D\noW7KLGddrY/stIvUO1vD8bPP2gy6bkRPMjldoR3SyiOgY6lZNsPTWEHXnekS0DaK\nlNwIkx+7U8A6YkH98MqvAWKkFb+iw5PAATmrLP6L4QlRJpnRLAStg/itRtsgk4ZC\nLU5PZ7GXVmXTLnyEJ88CtCiwsQHUKg0LpfkPwNsgAQKBgQDyB+tvXyPb6Aky/1Xc\nw65LopC0dSbBXJ62a8p9NLhESeMWyzQB4r7vjb7i36N/GhUWFcCL5et/oZ2eGd/0\nfjMeL14mlyhrDRRxwAfqSxyR8ERcghG0W9XOlV8Oh37QFHWmKpaagNmlboyX++Lv\nNIiZ4OCTOd2CufIlrZOry4oo6wKBgQC2z1cTvCQTHjwN6YZGgZAR5d0ECaCWju7I\nnYyzDar+CoWzZKgmvcIQ5MIIHQdPkmaV1oTrZnxJJv+RdfyVjM3T6ouxAT1tDfxp\nIX73ynC4Y9WFIJfW9DVXTNpEu5rK2xSbiYu16a4gdMKDI9fXtihibd8DdsVVy5MU\nkAUvpS3lsQKBgFFCDW5n388t+SCxDy++Vt835iNgDbHvma2fRO2CbLcoo2B8uqpD\naV1eFo9vDCJZLGksxmdxuv4v0Y5KG6GnWRwyRQbpyv0d+BY0pbOooh/xLdJtLOqD\nxqXECpUDMrVDmTg/pi6bQfdDxVoljExJM++Ny3hCfjcsnLq/qwuLm4gfAoGAQ9gb\nFuXh9X5pBzi9bnkzAJFwPslb4cRV9foSd3kBFprNF9CpXwdZeG+NWvl69xr8G2ur\nlLlKMtPYUSGahd3lnVoUUbKGG2zvWgzmVAu7XZMfcPKxp0KmcSnCb3O4dMRtl3Oq\nd+6rgrwSXBz3Q8UEo9LmyyBPCBIvGZiBdDc3G2ECgYAh6o/xvXV+dKPYbfSrkUyH\nX58K/OR69zwRPlzqkPo4SCa3OulfBkQ0jNv9eCQ2ugQ50k/Wb8Qw162xQXMR3VHe\nPudvcLIYQc9iUf287aGS/TanFL1UV5D87utRKFxNPekI5ENzYZGAmMRLUjx5n2Au\nDrXZl+BawbSHlsyAG5bn+A==\n-----END PRIVATE KEY-----\n",
                "client_email"=> "gogym-image-upload@gogym-bangkit-capstone.iam.gserviceaccount.com",
                "client_id"=> "109903395192785913875",
                "auth_uri"=> "https://accounts.google.com/o/oauth2/auth",
                "token_uri"=> "https://oauth2.googleapis.com/token",
                "auth_provider_x509_cert_url"=> "https://www.googleapis.com/oauth2/v1/certs",
                "client_x509_cert_url"=> "https://www.googleapis.com/robot/v1/metadata/x509/gogym-image-upload%40gogym-bangkit-capstone.iam.gserviceaccount.com",
                "universe_domain"=> "googleapis.com"
            ], // optional: Array of data that substitutes the .json file (see below)
            'project_id' => env('GOOGLE_CLOUD_PROJECT_ID', 'gogym-bangkit-capstone'), // optional: is included in key file
            'bucket' => env('GOOGLE_CLOUD_STORAGE_BUCKET', 'gogym-bangkit-capstone.appspot.com'),
            'path_prefix' => env('GOOGLE_CLOUD_STORAGE_PATH_PREFIX', ''), // optional: /default/path/to/apply/in/bucket
            'storage_api_uri' => env('GOOGLE_CLOUD_STORAGE_API_URI', null), // see: Public URLs below
            'apiEndpoint' => env('GOOGLE_CLOUD_STORAGE_API_ENDPOINT', null), // set storageClient apiEndpoint
            'visibility' => 'public', // optional: public|private
            'visibility_handler' => null, // optional: set to \League\Flysystem\GoogleCloudStorage\UniformBucketLevelAccessVisibility::class to enable uniform bucket level access
            'metadata' => ['cacheControl'=> 'public,max-age=86400'], // optional: default metadata
        ],
    ],

    /*
    |--------------------------------------------------------------------------
    | Symbolic Links
    |--------------------------------------------------------------------------
    |
    | Here you may configure the symbolic links that will be created when the
    | `storage:link` Artisan command is executed. The array keys should be
    | the locations of the links and the values should be their targets.
    |
    */

    'links' => [
        public_path('storage') => storage_path('app/public'),
    ],

];
