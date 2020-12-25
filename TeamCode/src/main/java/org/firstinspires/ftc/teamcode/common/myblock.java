package org.firstinspires.ftc.teamcode.common;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Disabled
public class myblock{


    private DcMotor bl;
    private DcMotor br;
    private DcMotor fl;
    private DcMotor fr;
    HardwareMap hwm;
    Telemetry telemetry;

    public void MoveTank(int targetposition, double motorpower) throws InterruptedException{
        int starting_position = 0;
        boolean going_backwards = false;
        if (targetposition < 0){
            //we are going backwards
            going_backwards = true;

        }

        boolean has_stopped = false;

        bl = hwm.get(DcMotor.class, "bl");
        br = hwm.get(DcMotor.class, "br");
        fl = hwm.get(DcMotor.class, "fl");
        fr = hwm.get(DcMotor.class, "fr");

        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        br.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.REVERSE);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bl.setPower(motorpower);
        br.setPower(motorpower);
        fl.setPower(motorpower);
        fr.setPower(motorpower);

        while (! has_stopped){
            starting_position = bl.getCurrentPosition();
            if (starting_position >= targetposition && ! going_backwards){
                bl.setPower(0.0);
                br.setPower(0.0);
                fl.setPower(0.0);
                fr.setPower(0.0);
                has_stopped = true;


            }

            else if (starting_position <= targetposition &&  going_backwards) {
                bl.setPower(0.0);
                br.setPower(0.0);
                fl.setPower(0.0);
                fr.setPower(0.0);
                has_stopped = true;
            }
            telemetry.addData("Current Position: ", starting_position);
            telemetry.update();
        }

    }


    public void Strafe(int target_position, double motorpower) throws InterruptedException{
        // negative targetposition is left, positive is right
        // in order to strafe left, we must have the left two go towards, and the right two go away
        // Also, in order to strafe right, we must have the right two go towards, and the left two go away
        double frpower;
        double blpower;
        double brpower;
        double flpower;
        if (target_position > 0){ // right
            blpower = -1 * motorpower;
            flpower = motorpower;
            brpower = motorpower;
            frpower = -1 * motorpower;

        }
        else{
            blpower = motorpower;
            flpower = -1 * motorpower;
            brpower = -1 * motorpower;
            frpower = motorpower;

        }

        boolean has_stopped = false;

        bl = hwm.get(DcMotor.class, "bl");
        br = hwm.get(DcMotor.class, "br");
        fl = hwm.get(DcMotor.class, "fl");
        fr = hwm.get(DcMotor.class, "fr");

        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        br.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.REVERSE);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bl.setPower(blpower);
        br.setPower(brpower);
        fl.setPower(flpower);
        fr.setPower(frpower);

        while (!has_stopped) {
            int current_position = fl.getCurrentPosition();
            if (current_position >= target_position && frpower == -1 * motorpower) {
                bl.setPower(0.0);
                br.setPower(0.0);
                fl.setPower(0.0);
                fr.setPower(0.0);
                has_stopped = true;

            }
            else if (current_position <= target_position && frpower ==  motorpower) {
                bl.setPower(0.0);
                br.setPower(0.0);
                fl.setPower(0.0);
                fr.setPower(0.0);
                has_stopped = true;

            }
        }


    }


}