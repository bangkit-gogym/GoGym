<?php

namespace App\Http\Controllers;

use App\Models\Photo;
use Illuminate\Http\File;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Validator;

class PhotoController extends Controller
{

    public function getPublicUrl(Request $request)
    {
        $bucketName = "gogym-bangkit-capstone.appspot.com";
        $fileName = $request->file('photo')->getClientOriginalName();

        return "https://storage.googleapis.com/" . $bucketName . "/" . "scan" . "/" . $fileName;
    }

    public function storePhotoForDetection(Request $request)
    {
        return $this->verifyToken($request, function (Request $request) {
            $disk = Storage::disk('gcs');

            if ($request->hasFile('photo') && $request->file('photo')->isValid()) {
                $photo = $request->file('photo');
                $extensionAllowed = ['jpg', 'png', 'jpeg'];
                $extension = $request->photo->extension();
                if (in_array($extension, $extensionAllowed)) {
                    $user =  auth('sanctum')->user();
                    $predictedname = $request->get('predictedname');
                    $disk->putFileAs('scan', new File($photo), $photo->getClientOriginalName());
                    Photo::create([
                        'user_id' => $user->id,
                        'filename' => $photo->getClientOriginalName(),
                        'filepath' => $this->getPublicUrl($request),
                        'predictedname' => $predictedname
                    ]);
                    return response()->json([
                        'error' => false,
                        'message' => 'Success.',
                    ], 200);
                } else {
                    return response()->json([
                        'error' => true,
                        'message' => 'Foto tidak valid.',
                    ], 200);
                }
            } else {
                return response()->json([
                    'error' => true,
                    'message' => 'Gagal menyimpan foto.',
                ], 200);
            }
        });
    }

    public function getHistoryDetection(Request $request)
    {
        return $this->verifyToken($request, function (Request $request) {
        $user =  auth('sanctum')->user();
        $data = Photo::where('user_id', $user->id)->get();
            return response()->json([
                'error' => false,
                'message' => '',
                'photo' => $data
            ], 200);
        });
    }
}
