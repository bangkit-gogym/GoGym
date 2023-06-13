<?php

namespace App\Http\Controllers;

use App\Models\Auth;
use Illuminate\Routing\Controller as BaseController;
use Illuminate\Foundation\Validation\ValidatesRequests;
use Illuminate\Foundation\Auth\Access\AuthorizesRequests;

class Controller extends BaseController
{
    use AuthorizesRequests, ValidatesRequests;

    public function verifyToken($request, $execute){
        $token = explode(' ',$request->header('Authorization'));
        if(count($token) == 2){
            if(strtolower(trim($token[0])) == 'bearer' && trim($token[1]) != ""){
                $auth = Auth::where('token', $token[1])->first();
                if($auth == null){
                    return response()->json([
                        'error' => true,
                        'message' => 'Not Authorized. Token Invalid',
                        'data' => []
                    ], 401);
                }
                return $execute($request, $token[1]);
            }
        }
        return response()->json([
            'error' => true,
            'message' => 'Not Authorized. Token Invalid',
            'data' => []
        ], 401);
    }
}
