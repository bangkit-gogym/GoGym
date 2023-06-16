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
            'name' => 'Barbell/Dumbell',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Barbel/y2mate.com%20-%20A%20beginners%20guide%20to%20properly%20exercise%20with%20a%20barbell_480p.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Barbel/y2mate.com%20-%20How%20to%20use%20a%20barbell%20%20Beginner%20tips%20%20etiquette%20at%20the%20gym%20PRIDEFIT_1080p.mp4',
            'description' => 'Barbell/Dumbell adalah salah satu jenis alat fitness yang digunakan untuk melatih kekuatan dan membangun otot. Barbell terdiri dari sebuah batang logam yang panjang dengan beban di kedua ujungnya. Beban pada barbell dapat berupa piringan logam yang dilepas atau berat tetap yang melekat pada batang.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Dumbell.png'
        ]);


        // Equipments::create([
        //     'id' => 2,
        //     'name' => 'Dumbell',
        //     'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Dumbell/y2mate.com%20-%2010%20Dumbbell%20Exercises%20You%20Should%20Be%20Doing_1080p.mp4',
        //     'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Dumbell/y2mate.com%20-%20Basic%20Beginner%20Introductory%20Easy%20Dumbbell%20Workout%20Exercises%20For%20Beginners%20At%20Home%20At%20The%20Gym_1080p.mp4',
        //     'description' => 'Dumbell adalah alat fitness yang umum digunakan untuk melatih kekuatan dan membangun otot. Dumbell terdiri dari sepasang beban yang terhubung dengan pegangan di tengahnya. Pegangan yang lebih panjang memungkinkan pengguna untuk memegangnya dengan kedua tangan secara bersamaan, sementara pegangan yang lebih pendek memungkinkan pengguna untuk memegangnya dengan satu tangan.',
        //     'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Dumbell.png'
        // ]);

        Equipments::create([
            'id' => 2,
            'name' => 'Bench Press',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Bench%20Press/How%20To_%20Barbell%20Bench%20Press.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Bench%20Press/y2mate.com%20-%20How%20to%20Bench%20Press%20for%20the%20PERFECT%20Chest%205%20Steps_1080p.mp4',
            'description' => 'Alat bench press adalah peralatan yang dirancang khusus untuk melaksanakan latihan bench press. Peralatan ini terdiri dari bench press bench atau bangku yang datar atau dapat diatur posisinya, dan sering kali dilengkapi dengan rak atau pegangan untuk menempatkan barbell.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/BenchPress.jpg'
        ]);

        Equipments::create([
            'id' => 3,
            'name' => 'Elliptical Trainer',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Elliptical%20Trainer/y2mate.com%20-%20HOW%20TO%20USE%20AN%20ELLIPTICAL%20%20Beginners%20Guide_1080pFHR.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Elliptical%20Trainer/y2mate.com%20-%20Youre%20Using%20the%20Elliptical%20WRONG%20%20Physical%20Therapist%20Explains_1080pFHR.mp4',
            'description' => 'Elliptical trainer adalah sebuah alat olahraga yang mensimulasikan gerakan berjalan atau berlari dengan menggabungkan gerakan langkah dan gerakan elips. Alat ini sering juga disebut sebagai cross-trainer. Elliptical trainer dirancang untuk memberikan latihan kardiovaskular yang efektif sambil mengurangi dampak pada sendi tubuh.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Elliptical%20Trainer.jpg'
        ]);

        Equipments::create([
            'id' => 4,
            'name' => 'Aerobic Stepper',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Aerobic%20Stepper/y2mate.com%20-%2025%20Minute%20Beginnerintermediate%20Step%20Workout%20Part%20I_1080p.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Aerobic%20Stepper/y2mate.com%20-%20DECK%20An%20aerobic%20step%20and%20incline%20strength%20bench%20in%20one_1080p.mp4',
            'description' => 'Aerobic stepper adalah sebuah alat yang digunakan dalam olahraga aerobik dan latihan kebugaran. Alat ini terdiri dari platform kecil dengan permukaan anti-selip, yang biasanya dapat disesuaikan dalam ketinggiannya. Platform tersebut digunakan sebagai pijakan untuk melakukan gerakan-gerakan kardiovaskular seperti langkah-langkah, melompat, atau gerakan-gerakan lainnya.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/aeorbicstepper.jpg'
        ]);

        Equipments::create([
            'id' => 5,
            'name' => 'Rowing Machine',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Rowing%20Machine/Rowing%20Machine%20_%20TECHNIQUE%20and%20BENEFITS.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Rowing%20Machine/y2mate.com%20-%20The%20Official%202021%20Rowing%20Form%20Checklist%20PERFECT%20STROKE_1080p.mp4',
            'description' => 'Rowing machine, juga dikenal sebagai ergometer air atau ergometer angkat dayung, adalah jenis mesin kebugaran yang mensimulasikan gerakan dayung dalam olahraga dayung. Rowing machine dirancang untuk melibatkan hampir semua otot utama dalam tubuh, termasuk otot-otot kaki, punggung, lengan, dan inti.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Rowing%20Machine.jpg'
        ]);

        Equipments::create([
            'id' => 6,
            'name' => 'Treadmill',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Treadmill/y2mate.com%20-%20HOW%20TO%20USE%20A%20TREADMILL%20%20Beginners%20Guide_1080pFHR.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Treadmill/y2mate.com%20-%20How%20To%20Use%20The%20Treadmill_1080p.mp4',
            'description' => 'Treadmill adalah mesin olahraga yang dirancang untuk mensimulasikan gerakan berjalan atau berlari di tempat. Ini adalah salah satu mesin kebugaran yang paling umum ditemukan di pusat kebugaran, gym, atau di rumah. Treadmill terdiri dari sebuah platform berjalan yang dilengkapi dengan sabuk bergerigi yang berputar saat pengguna berjalan atau berlari di atasnya.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Treadmill.jpg'
        ]);

        Equipments::create([
            'id' => 7,
            'name' => 'Stationary Bike',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Stasionary%20Bike/How%20to%20Correctly%20%26%20Effectively%20Use%20Your%20Exercise%20Bike.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Stasionary%20Bike/y2mate.com%20-%20Stationary%20Bike%20Workout%20for%20Beginners%20%2020%20Minute_1080p.mp4',
            'description' => 'Stationary bike adalah sebuah alat olahraga atau mesin yang dirancang untuk mensimulasikan pengalaman bersepeda di tempat, tanpa pergerakan maju. Alat ini juga dikenal sebagai exercise bike atau indoor bike. Stationary bike biasanya digunakan di pusat kebugaran, gym, atau bisa juga ditempatkan di rumah untuk melaksanakan latihan kardiovaskular dan membantu meningkatkan kebugaran tubuh.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/Stasionery%20Bike.jpg'
        ]);

        Equipments::create([
            'id' => 8,
            'name' => 'Smith Machine',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Smith%20Machine/How%20To%20Use%20The%20Smith%20Machine%20(1).mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Smith%20Machine/How%20to%20Use%20the%20Smith%20Machine.mp4',
            'description' => 'Smith machine adalah sebuah mesin kebugaran yang terdiri dari sebuah batang angkat beban yang bergerak dalam suatu lintasan yang terkendali. Mesin ini dirancang untuk melatih berbagai kelompok otot, terutama otot-otot tubuh bagian atas seperti otot dada, bahu, dan trisep.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/SmithMachine.jpg'
        ]);

        Equipments::create([
            'id' => 9,
            'name' => 'Leg Press Machine',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Leg%20Press/y2mate.com%20-%20Leg%20Press%20%20Seated%20Leg%20Press%20%20HOW%20TO%20USE%20%20FORM_1080pFHR.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Leg%20Press/y2mate.com%20-%20Leg%20Press%20Exercise%20with%20Ade%20Rai%20EdisiLatihanKaki_v240P.mp4',
            'description' => 'Leg press machine adalah peralatan kebugaran yang dirancang untuk melatih otot-otot kaki, terutama otot paha (quadriceps), hamstring, dan gluteus. Mesin ini menggunakan mekanisme yang memungkinkan pengguna untuk melakukan gerakan menekan beban dengan kaki mereka.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/LegPressMachine.jpg'
        ]);

        Equipments::create([
            'id' => 10,
            'name' => 'Cable Machine',
            'ref1Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Cable%20Machine/How%20to%20use%20the%20Cable%20Machine%20at%20the%20Gym%20_%20Beginner%20Cable%20Workout.mp4',
            'ref2Url' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/tutorial/Cable%20Machine/y2mate.com%20-%20HOW%20TO%20USE%20GYM%20EQUIPMENT%20%20Cable%20Machines_1080pFHR.mp4',
            'description' => 'Cable machine adalah mesin kebugaran yang menggunakan tali kabel dan pegangan yang terhubung dengan berbagai macam alat dan aksesori untuk melatih kelompok otot tubuh. Mesin ini dirancang untuk memberikan latihan yang beragam dan memungkinkan gerakan bebas dalam berbagai arah.',
            'photoUrl' => 'https://storage.googleapis.com/gogym-bangkit-capstone.appspot.com/photo/CableMachine.jpg'
        ]);
    }
}
