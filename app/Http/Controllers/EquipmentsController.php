<?php

namespace App\Http\Controllers;

use App\Models\Equipments;
use Illuminate\Http\Request;

class EquipmentsController extends Controller
{
    public function getAllEquipments(Equipments $data)
    {
        $data = Equipments::all();
            return response()->json([
                'error' => false,
                'message' => '',
                'equipment' => $data
            ], 200);
    }

    public function getEquipment(Equipments $data, $id)
    {
        $data = Equipments::where('id', $id)->first();
            return response()->json([
                'error' => false,
                'message' => '',
                'equipment' => $data
            ], 200);
    }
}
