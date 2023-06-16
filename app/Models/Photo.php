<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Photo extends Model
{
    use HasFactory;

    protected $fillable = ['filename', 'filepath', 'user_id', 'predictedname'];

    public function users()
    {
        return $this->belongsTo(User::class, 'user_id');
    }
}
