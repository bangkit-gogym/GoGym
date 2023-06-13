<?php

use App\Models\Equipments;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Storage;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\PhotoController;
use App\Http\Controllers\EquipmentsController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

// Public routes
Route::get('/equipments', [EquipmentsController::class, 'getAllEquipments']);
Route::get('/equipments/{id}', [EquipmentsController::class, 'getEquipment']);
Route::post('/register', [AuthController::class, 'register'] );
Route::post('/login', [AuthController::class , 'login'] );

// Protected routes
Route::group(['middleware' => ['auth:sanctum']], function () {
    Route::post('/logout', [AuthController::class, 'logout']);
    Route::post('/equipments/detection/post', [PhotoController::class, 'storePhotoForDetection']);
    Route::get('/equipments/detection/history', [PhotoController::class, 'getHistoryDetection']);
});

// Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
//     return $request->user();
// });
