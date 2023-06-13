<?php

namespace Database\Seeders;

use App\Models\Equipments;
use Illuminate\Database\Seeder;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;

class EquipmentsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Equipments::create([
            'id' => 1,
            'name' => 'Barbell',
            'ref1Url' => 'https://youtu.be/hJDqffL1EmQ',
            'ref2Url' => 'https://youtu.be/DeRlR3O1sd4',
            'description' => 'Barbell adalah salah satu jenis alat fitness yang digunakan untuk melatih kekuatan dan membangun otot. Barbell terdiri dari sebuah batang logam yang panjang dengan beban di kedua ujungnya. Beban pada barbell dapat berupa piringan logam yang dilepas atau berat tetap yang melekat pada batang.',
            'photoUrl' => 'https://img.freepik.com/free-vector/barbells-dumbbells-fitness-realistic-composition-with-isolated-image-heavy-barbell-vector-illustration_1284-66982.jpg?w=2000'
        ]);


        Equipments::create([
            'id' => 2,
            'name' => 'Dumbell',
            'ref1Url' => 'https://youtu.be/BNsKEG3hIzI',
            'ref2Url' => 'https://youtu.be/WDNQk_vJ2xE',
            'description' => 'Dumbell adalah alat fitness yang umum digunakan untuk melatih kekuatan dan membangun otot. Dumbell terdiri dari sepasang beban yang terhubung dengan pegangan di tengahnya. Pegangan yang lebih panjang memungkinkan pengguna untuk memegangnya dengan kedua tangan secara bersamaan, sementara pegangan yang lebih pendek memungkinkan pengguna untuk memegangnya dengan satu tangan.',
            'photoUrl' => 'https://img.freepik.com/free-vector/barbells-dumbbells-fitness-realistic-composition-with-isolated-image-heavy-barbell-vector-illustration_1284-66982.jpg?w=2000'
        ]);

        Equipments::create([
            'id' => 3,
            'name' => 'Bench Press',
            'ref1Url' => 'https://youtu.be/4Y2ZdHCOXok',
            'ref2Url' => 'https://youtu.be/rT7DgCr-3pg',
            'description' => 'Alat bench press adalah peralatan yang dirancang khusus untuk melaksanakan latihan bench press. Peralatan ini terdiri dari bench press bench atau bangku yang datar atau dapat diatur posisinya, dan sering kali dilengkapi dengan rak atau pegangan untuk menempatkan barbell.',
            'photoUrl' => 'https://img.freepik.com/free-photo/lifting-strength-fitness-guy-man_1139-689.jpg?w=900&t=st=1686321853~exp=1686322453~hmac=ee3cc62363eb0026cf9b5feefe34a7dada27fd59dfb51f8b097d1aeb38b39dd5'
        ]);

        Equipments::create([
            'id' => 4,
            'name' => 'Elliptical Trainer',
            'ref1Url' => 'https://youtu.be/EesEvYohy5o',
            'ref2Url' => 'https://youtu.be/j38LNpTLwzY',
            'description' => 'Elliptical trainer adalah sebuah alat olahraga yang mensimulasikan gerakan berjalan atau berlari dengan menggabungkan gerakan langkah dan gerakan elips. Alat ini sering juga disebut sebagai cross-trainer. Elliptical trainer dirancang untuk memberikan latihan kardiovaskular yang efektif sambil mengurangi dampak pada sendi tubuh.',
            'photoUrl' => 'https://img.freepik.com/free-photo/woman-using-stepper-showing-ok-sign_23-2148328458.jpg?w=740&t=st=1686323118~exp=1686323718~hmac=8d6c5d8928a995d2eb16271c1bf627ba3795ee6e54d4af40c6717a6ad52495c2'
        ]);

        Equipments::create([
            'id' => 5,
            'name' => 'Multi Machine',
            'ref1Url' => 'https://youtu.be/4Y2ZdHCOXok',
            'ref2Url' => 'https://youtu.be/rT7DgCr-3pg',
            'description' => 'Elliptical Trainer adalah alat olahraga atau mesin yang dirancang untuk mensimulasikan gerakan berjalan atau berlari tanpa memberikan tekanan pada sendi-sendi tubuh. Biasanya, elliptical trainer memiliki pegangan tangan yang bergerak bersama dengan gerakan kaki, sehingga melibatkan latihan angkat beban ringan pada bagian atas tubuh juga.',
            'photoUrl' => 'https://img.freepik.com/free-photo/lifting-strength-fitness-guy-man_1139-689.jpg?w=900&t=st=1686321853~exp=1686322453~hmac=ee3cc62363eb0026cf9b5feefe34a7dada27fd59dfb51f8b097d1aeb38b39dd5'
        ]);

        Equipments::create([
            'id' => 6,
            'name' => 'Rowing Machine',
            'ref1Url' => 'https://youtu.be/w2hGNM4l5so',
            'ref2Url' => 'https://youtu.be/ZN0J6qKCIrI',
            'description' => 'Rowing machine, juga dikenal sebagai ergometer air atau ergometer angkat dayung, adalah jenis mesin kebugaran yang mensimulasikan gerakan dayung dalam olahraga dayung. Rowing machine dirancang untuk melibatkan hampir semua otot utama dalam tubuh, termasuk otot-otot kaki, punggung, lengan, dan inti.',
            'photoUrl' => 'https://img.freepik.com/free-photo/man-using-press-machine-fitness-club_155003-2294.jpg?w=740&t=st=1686323167~exp=1686323767~hmac=6a928e6c88f1c2c1bd1ffd23ab0047876c678dc5823eff790359e98aa514f037'
        ]);

        Equipments::create([
            'id' => 7,
            'name' => 'Treadmill',
            'ref1Url' => 'https://youtu.be/8i3Vrd95o2k',
            'ref2Url' => 'https://youtu.be/HxsFneJFM2c',
            'description' => 'Treadmill adalah mesin olahraga yang dirancang untuk mensimulasikan gerakan berjalan atau berlari di tempat. Ini adalah salah satu mesin kebugaran yang paling umum ditemukan di pusat kebugaran, gym, atau di rumah. Treadmill terdiri dari sebuah platform berjalan yang dilengkapi dengan sabuk bergerigi yang berputar saat pengguna berjalan atau berlari di atasnya.',
            'photoUrl' => 'https://img.freepik.com/free-photo/running-tracks-empty-health-club_637285-8442.jpg?w=740&t=st=1686323222~exp=1686323822~hmac=19aa3d1ce7e3a9c62b100502a562f192b7ad925a4e104b00ded184c3c80c2374'
        ]);

        Equipments::create([
            'id' => 8,
            'name' => 'Stasionary Bike',
            'ref1Url' => 'https://youtu.be/rEqRmKAQ5xM',
            'ref2Url' => 'https://youtu.be/jhPqTyejY_0',
            'description' => 'Stationary bike adalah sebuah alat olahraga atau mesin yang dirancang untuk mensimulasikan pengalaman bersepeda di tempat, tanpa pergerakan maju. Alat ini juga dikenal sebagai exercise bike atau indoor bike. Stationary bike biasanya digunakan di pusat kebugaran, gym, atau bisa juga ditempatkan di rumah untuk melaksanakan latihan kardiovaskular dan membantu meningkatkan kebugaran tubuh.',
            'photoUrl' => 'https://img.freepik.com/free-photo/person-doing-indoor-cycling_23-2149270220.jpg?w=740&t=st=1686323256~exp=1686323856~hmac=b90e7fe2012a2ac6fe2f2fdb6ff68e9e3d79cccc52d81a091f5866f2ff655694'
        ]);

        Equipments::create([
            'id' => 9,
            'name' => 'Smith Machine',
            'ref1Url' => 'https://youtu.be/qPWXdq7idrIk',
            'ref2Url' => 'https://youtu.be/IHBLxCPmnVc',
            'description' => 'Smith machine adalah sebuah mesin kebugaran yang terdiri dari sebuah batang angkat beban yang bergerak dalam suatu lintasan yang terkendali. Mesin ini dirancang untuk melatih berbagai kelompok otot, terutama otot-otot tubuh bagian atas seperti otot dada, bahu, dan trisep.',
            'photoUrl' => 'https://th.bing.com/th/id/OIP.T8oFu43VgovtObapIa6qbwHaHa?pid=ImgDet&rs=1'
        ]);

        Equipments::create([
            'id' => 10,
            'name' => 'Leg Press Machine',
            'ref1Url' => 'https://youtu.be/TKhrxoOjS3s',
            'ref2Url' => 'https://youtu.be/UYdx6ammdwU',
            'description' => 'Leg press machine adalah peralatan kebugaran yang dirancang untuk melatih otot-otot kaki, terutama otot paha (quadriceps), hamstring, dan gluteus. Mesin ini menggunakan mekanisme yang memungkinkan pengguna untuk melakukan gerakan menekan beban dengan kaki mereka.',
            'photoUrl' => 'https://images-na.ssl-images-amazon.com/images/I/81St0dA4VwL._SL1500_.jpg'
        ]);

        Equipments::create([
            'id' => 11,
            'name' => 'Cable Machine',
            'ref1Url' => 'https://youtu.be/22AFyTaVs5g',
            'ref2Url' => 'https://youtu.be/OW6_KS8MOwU',
            'description' => 'Cable machine adalah mesin kebugaran yang menggunakan tali kabel dan pegangan yang terhubung dengan berbagai macam alat dan aksesori untuk melatih kelompok otot tubuh. Mesin ini dirancang untuk memberikan latihan yang beragam dan memungkinkan gerakan bebas dalam berbagai arah.',
            'photoUrl' => 'https://i5.walmartimages.com/asr/de16b2dc-4a40-47a5-a9aa-b579cad7b983_1.235283d01dd3309d070a61ae279a8eaa.jpeg'
        ]);
    }
}
