package org.firstinspires.ftc.teamcode.NonOpmodes;

import static org.firstinspires.ftc.teamcode.NonOpmodes.UtilConstants.*;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

public class CVMaster {

    private OpenCvCamera webcam;
    private MasterPipeline pipeline = new MasterPipeline();
    private FtcDashboard dashboard;

    public void initWebcam(HardwareMap hardwareMap){

        int cameraMonitorId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId","id",hardwareMap.appContext.getPackageName());

        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "webcam"), cameraMonitorId);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {

            @Override
            public void onOpened() {
                webcam.setPipeline(pipeline);
                webcam.startStreaming(xWidth, yWidth, OpenCvCameraRotation.UPRIGHT);
                dashboard.startCameraStream(webcam, dashboardStreamFps);
            }

            @Override
            public void onError(int errorCode) {
            }
        });
    }


class MasterPipeline extends OpenCvPipeline{
    @Override
    public Mat processFrame(Mat input) {
        return null;
        }
    }
}
