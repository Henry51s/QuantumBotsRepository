package org.firstinspires.ftc.teamcode.NonOpmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.NonOpmodes.PIDMotor;

import java.util.List;


public class Hardware{


    public DcMotor motor1 = null;
    public PIDMotor customMotor = null;
    public Servo servo1 = null;

    public void initHardware(HardwareMap hardwareMap){
        
        List<LynxModule> allHubs = hardwareMap.getAll(LynxModule.class);
        for (LynxModule hub : allHubs){
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }

        customMotor = new PIDMotor(hardwareMap, "motor1");

        //this.motor1 = hardwareMap.get(DcMotor.class, "motor1");
        //this.motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        this.servo1 = hardwareMap.get(Servo.class, "servo1");
    }
}

