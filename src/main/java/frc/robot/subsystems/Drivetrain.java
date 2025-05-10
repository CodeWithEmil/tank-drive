package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;


public class Drivetrain extends SubsystemBase {

    // Declaring each motor controller considering its respective motor's ID
    private final VictorSPX leadingLeftMotor = new VictorSPX(Constants.frontRightMotorId);
    private final VictorSPX followerLeftMotor = new VictorSPX(Constants.backRightMotorId);
    private final VictorSPX leadingRightMotor = new VictorSPX(Constants.frontLeftMotorId);
    private final VictorSPX followerRightMotor = new VictorSPX(Constants.backLeftMotorId);


    // Configuring motors according to their position
    public void setConfig() {
        leadingRightMotor.setInverted(true);
        leadingLeftMotor.setInverted(false);
        followerLeftMotor.follow(leadingLeftMotor);
        followerRightMotor.follow(leadingRightMotor);
    }

    // A very basic drive method using differential drive logic
    // It is easy to comprehend: both leading motors get the same translational power (they'll drive in the same direction),
    // and get inverted rotational power so they rotate to the same direction
    // Both of these values are passed from the controller's left and right joysticks respectively
    public void drive(double translationalPower, double rotationalPower) {
        leadingRightMotor.set(ControlMode.PercentOutput, translationalPower + rotationalPower);
        leadingLeftMotor.set(ControlMode.PercentOutput, translationalPower - rotationalPower);
    }
}

// Electronics Postulation — Emilio Nájera, 2025