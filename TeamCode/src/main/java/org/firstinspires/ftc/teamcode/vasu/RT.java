package org.firstinspires.ftc.teamcode.vasu;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


//DON'T KNOW IF THIS WORKS

//hfdsjfsd

@Disabled
@TeleOp
public class RT extends OpMode {

    DcMotor fl;
    DcMotor br;
    DcMotor fr;
    DcMotor bl;

    public void init() {

        fl = hardwareMap.dcMotor.get("fl");
        br = hardwareMap.dcMotor.get("br");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");



    }
    public void loop() {

        br.setPower(-gamepad1.right_trigger);
        fl.setPower(gamepad1.right_trigger);
        fr.setPower(-gamepad1.right_trigger);
        bl.setPower(gamepad1.right_trigger);



    }
}
