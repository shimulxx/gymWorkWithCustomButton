package com.example.gymwork;

import android.util.Log;

import java.util.ArrayList;

public class Utilities {
    private static final String TAG = "Utilities";

    private static ArrayList<GymTraining> trainings;
    private static ArrayList<Plan> usersPlan;

    public Utilities() {
    }
    public static void initTrainig(){
        if(trainings == null)
            trainings = new ArrayList<>();

        if(usersPlan == null)
            usersPlan = new ArrayList<>();

        GymTraining squat = new GymTraining();
        squat.setName("Squat");
        squat.setShortDesc("A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up.");
        squat.setLongDesc("During the descent of a squat, the hip and knee joints flex while the ankle joint dorsiflexes; conversely the hip and knee joints extend and the ankle joint plantarflexes when standing up. Squats are considered a vital exercise for increasing the strength and size of the lower body muscles as well as developing core strength. The primary agonist muscles used during the squat are the quadriceps femoris, the adductor magnus, and the gluteus maximus. The squat also isometrically uses the erector spinae and the abdominal muscles, among others.");
        squat.setImageUrl("https://previews.123rf.com/images/tonobalaguer/tonobalaguer1412/tonobalaguer141200047/34242402-dumbbell-squat-woman-workout-exercise-at-gym.jpg");

        GymTraining pushup = new GymTraining();
        pushup.setName("Pushup");
        pushup.setShortDesc("A push-up (or press-up if the hands are wider than shoulders placing more emphasis on the pectoral muscles) is a common calisthenics exercise beginning from the prone position.");
        pushup.setLongDesc("By raising and lowering the body using the arms, push-ups exercise the pectoral muscles, triceps, and anterior deltoids, with ancillary benefits to the rest of the deltoids, serratus anterior, coracobrachialis and the midsection as a whole. Push-ups are a basic exercise used in civilian athletic training or physical education and commonly in military physical training. They are also a common form of punishment used in the military, school sport, or in some martial arts disciplines.");
        pushup.setImageUrl("https://previews.123rf.com/images/vadymvdrobot/vadymvdrobot1712/vadymvdrobot171201490/91706308-full-length-portrait-of-a-fit-strong-shirtless-male-bodybuilder-doing-push-ups-with-bars-isolated-ov.jpg");

        GymTraining chestFly = new GymTraining();
        chestFly.setName("Chest Fly");
        chestFly.setShortDesc("A fly or flye is a strength training exercise in which the hand and arm move through an arc while the elbow is kept at a constant angle.");
        chestFly.setLongDesc("Flies are used to work the muscles of the upper body. Because these exercises use the arms as levers at their longest possible length, the amount of weight that can be moved is significantly less than equivalent press exercises for the same muscles (the military press and bench press for the shoulder and chest respectively).");
        chestFly.setImageUrl("https://previews.123rf.com/images/ozimician/ozimician1604/ozimician160400003/55243411-young-adult-man-doing-cable-fly-in-gym-.jpg");

        GymTraining legpress = new GymTraining();
        legpress.setName("Leg Press");
        legpress.setShortDesc("The leg press is a weight training exercise in which the individual pushes a weight or resistance away from them using their legs.");
        legpress.setLongDesc("The term leg press also refers to the apparatus used to perform this exercise. The leg press can be used to evaluate an athlete's overall lower body strength (from knee joint to hip). It has the potential to inflict grave injury: the knees could bend the wrong way if they are locked during a leg press.");
        legpress.setImageUrl("https://previews.123rf.com/images/zamuruev/zamuruev1709/zamuruev170900234/85849281-woman-doing-fitness-training-on-a-leg-extension-push-machine-with-weights-in-a-gym.jpg");

        trainings.add(squat);
        trainings.add(pushup);
        trainings.add(chestFly);
        trainings.add(legpress);
    }

    public static ArrayList<GymTraining> getTrainings() {
        return trainings;
    }

    public static void setTrainings(ArrayList<GymTraining> trainings) {
        Utilities.trainings = trainings;
    }

    public static ArrayList<Plan> getUsersPlan() {
        return usersPlan;
    }

    public static void setUsersPlan(ArrayList<Plan> usersPlan) {
        Utilities.usersPlan = usersPlan;
    }

    public static boolean addToUsersPlan(Plan plan){
        Log.d(TAG, "addToUsersPlan: Started");
        return usersPlan.add(plan);
    }

    public static boolean removeUsersPlan(Plan plan){
        Log.d(TAG, "removeUsersPlan: Started");
        return usersPlan.remove(plan);
    }
}
