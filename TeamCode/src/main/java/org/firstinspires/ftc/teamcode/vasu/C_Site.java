package org.firstinspires.ftc.teamcode.vasu;
import org.firstinspires.ftc.teamcode.common.myblock;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name="CS", group="CS")
@Disabled
public class C_Site extends myblock {

    //MoveTank motor = new MoveTank();


/*
    public void MoveTank(int target_position, double motorPower) throws InterruptedException {
        float current_position;
        boolean has_stopped = false;

        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");

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

        bl.setPower(motorPower);
        br.setPower(motorPower);
        fl.setPower(motorPower);
        fr.setPower(motorPower);

        while (! has_stopped){
            current_position = bl.getCurrentPosition();
            if (current_position >= target_position){
                bl.setPower(0.0);
                br.setPower(0.0);
                fl.setPower(0.0);
                fr.setPower(0.0);
                has_stopped = true;

            }
            telemetry.addData("Current Position: ", current_position);
            telemetry.update();
        }





    }
*/
    public void run() throws InterruptedException {
        MoveTank(9500, 0.5);

    }
}