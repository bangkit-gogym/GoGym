<?php

namespace App\Http\Controllers;

use App\Models\Auth;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Hash;

class AuthController extends Controller
{
    public function register(Request $request)
    {
        $name = $request->get('name');
        $email = $request->get('email');
        $password = $request->get('password');
        if (isset($name) && trim($name) != "" && isset($email) && trim($email) != "" && isset($password) && trim($password) != "") {
            try {
                $res = User::create([
                    'name' => $name,
                    'email' => $email,
                    'password' => Hash::make($password)
                ]);
                echo json_encode([
                    'error' => false,
                    'message' => 'User Created!',
                    'data' => $res
                ], 201);

            } catch (\Illuminate\Database\QueryException $exception) {
                echo json_encode([
                    'error' => true,
                    'message' => 'Email sudah digunakan!'
                ]);
            }
        }
        else{
            echo json_encode([
                'error' => true,
                'message' => 'Data tidak lengkap!'
            ]);
        }
    }

    public function login(Request $request)
    {
        $email = $request->get('email');
        $password = $request->get('password');
        $user = User::where('email', $email)->first();
        if ($user == null) {
            echo json_encode([
                'error' => true,
                'message' => 'User tidak ditemukan!'
            ]);
        } else {
            if (Hash::check($password, $user->makeVisible('password')->toArray()['password'])) {
                $token = $user->createToken(hash("sha256", $user->id . date('Y-m-d hh:mm:ss')))->plainTextToken;
                Auth::create([
                    'id_user' => $user->id,
                    'token' => $token
                ]);
                echo json_encode([
                    'error' => false,
                    'message' => 'Berhasil login!',
                    'data' => [
                        'token' => $token,
                        'name' => $user->name,
                        'id' => $user->id,
                    ]
                ], 200);
            } else {
                echo json_encode([
                    'error' => true,
                    'message' => 'Password tidak benar!'
                ]);
            }
        }
    }

    public function logout(Request $request)
    {
        return $this->verifyToken($request, function (Request $request, $token) {
            $auth = Auth::where('token', $token)->first();
            if ($auth != null) {
                $auth->delete();
            }
            return response()->json([[
                'error' => true,
                'message' => 'Berhasil logout!'
            ]], 200);
        });
    }
}
